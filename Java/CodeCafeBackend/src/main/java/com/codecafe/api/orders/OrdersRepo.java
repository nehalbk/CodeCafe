package com.codecafe.api.orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface OrdersRepo extends JpaRepository<Orders,Integer>{
	
	List<Orders> findByordersId(int orderid);
}
