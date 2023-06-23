package com.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.CartEntity;
import com.tp.entity.DrinkEntity;
import com.tp.entity.OrderEntity;
import com.tp.entity.UserEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

	List<OrderRepository> findBy

	
}
