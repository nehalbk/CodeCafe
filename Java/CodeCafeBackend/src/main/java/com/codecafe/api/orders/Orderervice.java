package com.codecafe.api.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import com.codecafe.exceptions.SpringExceptionHandler;

@Service
public class Orderervice {
	
	@Autowired
	SpringExceptionHandler excp;
	@Autowired
	private WebRequest webRequest;
	@Autowired
	OrdersRepo repo;
	
	
	public ResponseEntity<List<Orders>> getallorders() throws Exception {
		try{
			List<Orders> returnedOrders =repo.findAll();
			if(returnedOrders.isEmpty()) {
				throw new Exception("No orders found!");
			}else {
				return new ResponseEntity<>(returnedOrders,HttpStatus.OK);
			}
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<List<Orders>> getordersbyid(int orderid) throws Exception{
		
		try{
			List<Orders> returnedOrders =repo.findByordersId(orderid);
			if(returnedOrders.isEmpty()) {
				throw new Exception("No orders found!");
			}else {
				return new ResponseEntity<>(returnedOrders,HttpStatus.OK);
			}
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
	
	
	
}
