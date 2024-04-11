package com.telusk.springbootbookstore.order.repository;

import com.telusk.springbootbookstore.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OrderRepo extends JpaRepository<OrderEntity , Long> {

    List<OrderEntity> findAllByUserEntity_Id(Long userId);

}
