package com.tp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
