package com.tp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

//	//카테고리별
//	List<Menu> findByCategory(String category);
	
}
