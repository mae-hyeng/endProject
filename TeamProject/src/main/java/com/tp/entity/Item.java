package com.tp.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@ManyToOne
	private String user_id;
	
	@Column
	private Boolean isSoldout;
	
	@Column
	private Long count;
	
	@Column
	private Long stock;
	
	@Column
	private String filename;
	
	@Column
	private String filepath;

//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private UserEntity user;
	
//	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
//	private List<UserEntity> user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name="user_id")
	 private UserEntity user;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	 private List<Cart_item> cart_item;
	
}
