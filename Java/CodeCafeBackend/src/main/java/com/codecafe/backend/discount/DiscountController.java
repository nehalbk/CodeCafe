package com.codecafe.backend.discount;

import com.codecafe.api.orders.Orders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class DiscountController {
	
	@CrossOrigin(origins="http://localhost:8080")
	@PostMapping(value="/discount",consumes="application/json")
	@ResponseBody
	public double getDiscount(@RequestBody Orders order) {
		if(order.getORDRTOTL()>300)
			return 0.10;
		else if(order.getORDRTOTL()>200)
			return 0.05;
		else
			return 0;
	}
	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/discount",produces="application/json")
	@ResponseBody
	public String geta() {
		return "Hello!, Ready for a  surprise?";
	}
}
