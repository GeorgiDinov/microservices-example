package com.georgidinov.orderservice.api.repository;

import com.georgidinov.orderservice.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}//end of interface OrderRepository
