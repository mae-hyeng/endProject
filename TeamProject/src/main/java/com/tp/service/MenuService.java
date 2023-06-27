package com.tp.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tp.entity.Menu;
import com.tp.repository.BoardRepository;
import com.tp.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuService {
	
	private final MenuRepository menuRepository;
	
	@Transactional
	public Menu selectOne(Long num) {
		return menuRepository.findById(num).get();
	}
	
}

