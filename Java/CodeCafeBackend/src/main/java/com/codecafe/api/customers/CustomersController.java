package com.codecafe.api.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomersController {
	@Autowired
	CustomersRepo repo;
	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/customers",produces = { "application/json" })
	@ResponseBody
	public List<Customers> getOrders(){
		return repo.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(value="/customers/{customerid}",produces = { "application/json" })
	@ResponseBody
	public List<Customers> getOrder(@PathVariable int customerid){
		return repo.findBycustomersId(customerid);
	}

}
