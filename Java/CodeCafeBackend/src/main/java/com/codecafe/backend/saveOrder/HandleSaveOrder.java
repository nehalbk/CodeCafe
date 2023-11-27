package com.codecafe.backend.saveOrder;


import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.codecafe.api.orders.Orders;
import com.codecafe.api.orders.OrdersRepo;
import com.codecafe.exceptions.SpringExceptionHandler;

@Service
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")
public class HandleSaveOrder {

	@Autowired
	SpringExceptionHandler excp;
	@Autowired
	private WebRequest webRequest;
	
	@Autowired
	OrdersRepo repo;
	public ResponseEntity<Map<String,String>> handleSaveOrder(Orders order) throws Exception {
			try {
				repo.save(order);
				
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Order ID:",order.getOrdersId().toString());
				orderMap.put("Message:", "Order Saved!");
				
				return  new ResponseEntity<Map<String,String>>(orderMap,HttpStatus.OK);
				
			}catch(Exception E) {
				excp.handleAllException(E,webRequest);
				
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Order ID:",order.getOrdersId().toString());
				orderMap.put("Message:", E.getMessage());
				
				return  new ResponseEntity<Map<String,String>>(orderMap,HttpStatus.BAD_REQUEST);
			}	
	}
}