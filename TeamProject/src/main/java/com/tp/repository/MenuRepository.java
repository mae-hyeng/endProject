package com.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByType(String type);
	
}
