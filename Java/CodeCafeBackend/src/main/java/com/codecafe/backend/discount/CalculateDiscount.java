package com.codecafe.backend.discount;


import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.codecafe.api.orders.Orders;
import com.codecafe.exceptions.SpringExceptionHandler;

@Service
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")
public class CalculateDiscount {

	@Autowired
	SpringExceptionHandler excp;
	@Autowired
	private WebRequest webRequest;
	public ResponseEntity<Map<String,String>> getDiscount(Orders order) throws Exception {
			try {
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Order ID:",order.getordersId().toString());
	
				double disc=0;
				
				if(order.getORDRTOTL()>300)
					disc= 10;
				else if(order.getORDRTOTL()>200)
					disc=5;
				
				orderMap.put("Discount %:", Double.toString(disc));
				
				return ResponseEntity.ok(orderMap);
				
			}catch(Exception E) {
				excp.handleAllException(E,webRequest);
				
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Error", "Error in order");
				
				return  new ResponseEntity<Map<String,String>>(orderMap,HttpStatus.BAD_REQUEST);
			}	
	}
}