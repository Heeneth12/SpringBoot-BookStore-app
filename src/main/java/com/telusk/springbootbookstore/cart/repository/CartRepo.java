package com.telusk.springbootbookstore.cart.repository;

import com.telusk.springbootbookstore.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepo extends JpaRepository<CartEntity , Long> {

    List<CartEntity> findByUserEntityId(Long userId);
}
