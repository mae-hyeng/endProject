package com.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, String> {

	CartEntity findByUserIdAndDrinkId(String userId, Long drinkId);
	
}
