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

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int quantity;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "userName")
	private UserEntity user;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")
	private List<Menu> menu = new ArrayList<Menu>();
	
	
//	public void addQuantity(int quantity) {
//		this.quantity += quantity;
//	}
	
	public static Cart createCart(UserEntity user) {
		Cart cart = new Cart();
		cart.setQuantity(0);
		cart.setUser(user);
		
		return cart;
	}
	
}
