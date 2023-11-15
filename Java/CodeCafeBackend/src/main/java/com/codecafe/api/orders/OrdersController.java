package com.codecafe.api.orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrdersController {
	@Autowired
	OrdersRepo repo;
	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/orders",produces = { "application/json" })
	@ResponseBody
	public List<Orders> getOrders(){
		return repo.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/orders/{orderid}",produces = { "application/json" })
	@ResponseBody
	public List<Orders> getOrder(@PathVariable int orderid){
		return repo.findByordersId(orderid);
	}

}
