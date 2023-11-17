package com.codecafe.api.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import com.codecafe.exceptions.SpringExceptionHandler;

@Service
public class CustomersService {
	
	@Autowired
	SpringExceptionHandler excp;
	
	@Autowired
	private WebRequest webRequest;
	
	@Autowired
	CustomersRepo repo;
	
	
	public ResponseEntity<List<Customers>> getAllCustomers() throws Exception {
		try{
			List<Customers> returnedCustomers =repo.findAll();
			if(returnedCustomers.isEmpty()) {
				throw new Exception("No customers found!");
			}else {
				return new ResponseEntity<>(returnedCustomers,HttpStatus.OK);
			}
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Customers>> getCustomersById(int orderid) throws Exception{
		
		try{
			List<Customers> returnedCustomers =repo.findBycustomersId(orderid);
			if(returnedCustomers.isEmpty()) {
				throw new Exception("No customers found!");
			}else {
				return new ResponseEntity<>(returnedCustomers,HttpStatus.OK);
			}
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}	
}