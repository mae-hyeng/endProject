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

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuId")
	private List<Menu> menu;
	
	@OneToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "userName")
	private UserEntity user;
	
	private int count;  // 담긴 상품 개수
	
	public static Cart createCart(MenuOrder menuorder,Menu menu,int count){
        Cart cart = new Cart();
        cart.setMenu((List<Menu>) menu);
        cart.setCount(count);

        return cart;
    }
	
	public void addCount(int count){
        this.count += count;
    }
	
}

