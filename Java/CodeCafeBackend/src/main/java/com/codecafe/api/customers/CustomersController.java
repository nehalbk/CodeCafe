package com.codecafe.api.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersController {
	@Autowired
	CustomersService customerService;
	
	@GetMapping(value="/customers",produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<List<Customers>> getOrders() throws Exception{
		return customerService.getAllCustomers();
	}
	

	@GetMapping(value="/customers/{customerid}",produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<List<Customers>> getOrder(@PathVariable int customerid) throws Exception{
		return customerService.getCustomersById(customerid);
	}

}
