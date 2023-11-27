package com.codecafe.backend.total;


import java.util.Map;
import java.util.HashMap;
import java.util.List;

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
public class HandleTotal {

	@Autowired
	SpringExceptionHandler excp;
	@Autowired
	private WebRequest webRequest;
	
	@Autowired
	OrdersRepo repo;
	public ResponseEntity<Map<String,String>> handleTotal(Orders order) throws Exception {
			try {
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Order ID:",order.getOrdersId().toString());
				
				List<Orders> returnedOrder =repo.findByordersId(order.getOrdersId());
				
				if(returnedOrder.isEmpty()) {
					throw new Exception("No such orders!");
				}
				else {
					double total=order.getORDRPRIC()*order.getORDRQNTY()+order.getORDRTTAX()-order.getORDRDISC();
					order.setORDRTOTL(total);
					
					return ResponseEntity.ok(orderMap);					
				}
				
				
			}catch(Exception E) {
				excp.handleAllException(E,webRequest);
				
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Order ID:",order.getOrdersId().toString());
				orderMap.put("Discount %:","0");
				orderMap.put("Message:", E.getMessage());
				
				return  new ResponseEntity<Map<String,String>>(orderMap,HttpStatus.BAD_REQUEST);
			}	
	}
}