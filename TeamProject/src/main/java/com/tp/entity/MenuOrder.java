package com.tp.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "orders")
public class MenuOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id" , referencedColumnName = "username")
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	@Column
	private Integer quantity;

	@CreationTimestamp
	@Column
	private Timestamp orderDate;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

}