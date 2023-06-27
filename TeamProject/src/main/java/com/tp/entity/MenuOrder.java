package com.tp.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "menuOrder")
public class MenuOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@CreationTimestamp
	private Timestamp orderDate;
	
	@Column
	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")
	private Menu menu;
	
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userName")
	private UserEntity user;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartId")
	private Cart cart;

}
