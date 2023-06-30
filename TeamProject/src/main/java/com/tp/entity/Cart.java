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

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
=======
import lombok.Builder;
>>>>>>> branch 'main' of https://github.com/mae-hyeng/endProject.git
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
<<<<<<< HEAD
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
=======
@Getter
@Setter
>>>>>>> branch 'main' of https://github.com/mae-hyeng/endProject.git
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int quantity;
	
	@Column
	private int quantity;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "userName")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")
	private Menu menu;
	
	
<<<<<<< HEAD
//	public void addQuantity(int quantity) {
//		this.quantity += quantity;
//	}
	
	public static Cart createCart(UserEntity user) {
		Cart cart = new Cart();
		cart.setQuantity(0);
		cart.setUser(user);
		
		return cart;
	}
	
=======
//	@ManyToMany(mappedBy = "cart")
//	private List<MenuOrder> menuOrder;

>>>>>>> branch 'main' of https://github.com/mae-hyeng/endProject.git
}

