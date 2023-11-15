package com.codecafe.api.customers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface CustomersRepo extends JpaRepository<Customers,Integer>{
	
	List<Customers> findBycustomersId(int orderid);
}
