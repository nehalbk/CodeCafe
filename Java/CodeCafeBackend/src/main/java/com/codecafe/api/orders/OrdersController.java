package com.codecafe.api.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrdersController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping(value="/orders",produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<List<Orders>> getOrders() throws Exception{
		return orderService.getallorders();
//		return "Hello";
	}
	
	@GetMapping(value="/orders/{orderid}",produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<List<Orders>> getOrder(@PathVariable int orderid) throws Exception{
		return orderService.getordersbyid(orderid);
	}
	
	@PostMapping(value="/orders",consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order) throws Exception{
		return orderService.saveOrder(order);
	}

}
