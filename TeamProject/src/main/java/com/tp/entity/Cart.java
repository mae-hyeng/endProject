package com.tp.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Service
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "userName")
	private UserEntity user;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")
	private Menu menu;
	
	
//	@ManyToMany(mappedBy = "cart")
//	private List<MenuOrder> menuOrder;
	
	
}