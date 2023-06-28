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
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor // 기본생성자
@AllArgsConstructor
@Data // 게터세터투스트링
@Entity
public class MenuOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment로 지정
	private Long id;
	
	@Column
	private int quantity;
	
	@CreationTimestamp
	@Column
	private Timestamp orderDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	
    public static MenuOrder createMenuorder(UserEntity user){
    	MenuOrder menuorder = new MenuOrder();
        menuorder.user = user;
        menuorder.quantity = 0;
 
        return menuorder;
    }

	
}