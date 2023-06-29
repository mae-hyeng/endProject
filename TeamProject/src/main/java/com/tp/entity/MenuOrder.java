package com.tp.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
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

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "menuOrder")
@Builder
public class MenuOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@CreationTimestamp
	private Timestamp orderDate;
	
	@Column
	private int quantity;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")
	private List<Menu> menu = new ArrayList<Menu>();
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "userName")
	private List<UserEntity> user = new ArrayList<UserEntity>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartId")
	private Cart cart;

}
