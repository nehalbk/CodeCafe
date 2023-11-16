package com.codecafe.backend.discount;

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

public class DiscountController {
	
	@Autowired
	CalculateDiscount disc;
	
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping(value="/discount",consumes="application/json")
	@ResponseBody
	public ResponseEntity<Map<String,String>> getDiscount(@RequestBody Orders order) throws Exception {
		return disc.getDiscount(order);
	
	}
	
//	public double getDiscount(@RequestBody int order) {
//		
//		return disc.getDiscount(order);
//	
//	}
//	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/discount",produces="application/json")
	@ResponseBody
	public String geta() {
		return "Hello!, Ready for a  surprise?";
	}
}
