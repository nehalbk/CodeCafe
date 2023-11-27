package com.codecafe.backend.refund;


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
public class CalculateRefund {

	@Autowired
	SpringExceptionHandler excp;
	@Autowired
	private WebRequest webRequest;
	
	public ResponseEntity<Map<String,String>> getRefund(Orders order) throws Exception {
			try {
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Order ID:",order.getOrdersId().toString());
	
				double refund=0;
				 	
				if(!order.isORDRDELV()) {
					if(order.getORDRTOTL()>300)
						refund= 10;
					else 
						refund=5;
				}
				else {
					throw new Exception("Order already delivered! No refund possible");
				}
	
				orderMap.put("Refund %:", Double.toString(refund));
				orderMap.put("Message: ", "Sorry for the inconvinience");
				
				return ResponseEntity.ok(orderMap);
				
			}catch(Exception E) {
				excp.handleAllException(E,webRequest);
				
				Map<String,String> orderMap= new HashMap<String,String>();
				orderMap.put("Order ID:",order.getOrdersId().toString());
				orderMap.put("Refund %:", "0");
				orderMap.put("Message: ", E.getMessage()	);
				
				return  new ResponseEntity<Map<String,String>>(orderMap,HttpStatus.BAD_REQUEST);
			}	
	}
}