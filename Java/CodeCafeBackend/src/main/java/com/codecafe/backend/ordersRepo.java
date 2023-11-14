package com.codecafe.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface ordersRepo extends JpaRepository<orders,Integer>{
	
	List<orders> findByordersId(int orderid);
}
