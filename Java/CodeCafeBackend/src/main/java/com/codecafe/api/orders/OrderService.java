package com.codecafe.api.orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import com.codecafe.backend.discount.HandleDiscount;
import com.codecafe.backend.saveOrder.HandleSaveOrder;
import com.codecafe.backend.tax.HandleTax;
import com.codecafe.backend.total.HandleTotal;
import com.codecafe.exceptions.SpringExceptionHandler;

@Service
public class OrderService {
	
	@Autowired
	SpringExceptionHandler excp;
	@Autowired
	private WebRequest webRequest;
	@Autowired
	private OrdersRepo repo;
	@Autowired
	private HandleDiscount disc;
	@Autowired
	private HandleTotal total;
	@Autowired
	private HandleTax tax;
	@Autowired
	private HandleSaveOrder save;
	
	public ResponseEntity<Orders> saveOrder(Orders order) throws Exception {
		try{
			System.out.println(order);
			save.handleSaveOrder(order);
			disc.handleDiscount(order);
			tax.handleTax(order);
			total.handleTotal(order);
			save.handleSaveOrder(order);
			
			return new ResponseEntity<>(order,HttpStatus.OK);
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		

	}
	
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
	
	public ResponseEntity<Object> deleteOrder(Integer orderid) throws Exception{
		
		try{	
			Optional<Orders> returnedCustomers =repo.findById(orderid);
			if(returnedCustomers.isEmpty()) {
				throw new Exception("No orders found!");
			}else {
				repo.deleteById(orderid);
				return new ResponseEntity<Object>("Order deleted Successully!",HttpStatus.OK);
			
			}
			
		}catch(Exception E) {
			excp.handleAllException(E,webRequest);
			
			return  new ResponseEntity<Object>("Error in deleting Order!",HttpStatus.BAD_REQUEST);
		}
	}
	
}
