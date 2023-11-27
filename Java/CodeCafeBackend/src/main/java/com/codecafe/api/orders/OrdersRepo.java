package com.codecafe.api.orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


@Component
public interface OrdersRepo extends JpaRepository<Orders,Integer>{
	
	List<Orders> findByordersId(int orderid);
	
	@Modifying
	@Query("update Orders set ORDRDISC= :disc where ordersId = :orderId")
	int setDisc(@Param("orderId")Integer orderId,@Param("disc") Double disc);
}
