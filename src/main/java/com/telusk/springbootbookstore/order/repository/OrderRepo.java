package com.telusk.springbootbookstore.order.repository;

import com.telusk.springbootbookstore.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepo extends JpaRepository<OrderEntity , Long> {
}
