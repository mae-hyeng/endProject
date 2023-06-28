package com.tp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tp.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
	
	//제목으로 검색
//	Page<Board> findByTitleContaining(String keyword, Pageable pageable);
}
