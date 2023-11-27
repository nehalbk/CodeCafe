package com.codecafe.backend.refund;

import com.codecafe.api.orders.Orders;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class RefundController {
	
	@Autowired
	CalculateRefund disc;
	
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping(value="/refund",consumes="application/json")
	@ResponseBody
	public ResponseEntity<Map<String,String>> getDiscount(@RequestBody Orders order) throws Exception {
		return disc.getRefund(order);
	
	}
	
//	public double getDiscount(@RequestBody int order) {
//		
//		return disc.getDiscount(order);
//	
//	}
//	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/refund",produces="application/json")
	@ResponseBody
	public String geta() {
		return "Hello!, Sorry for the inconvinience!";
	}
}
