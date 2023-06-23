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
@NoArgsConstructor // �⺻������
@AllArgsConstructor
@Data // ���ͼ�������Ʈ��
@Entity(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment�� ����
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "drink_id")
	private DrinkEntity drink;
	
	@Column
	private Long quantity;
	
	@CreationTimestamp
	@Column
	private Timestamp orderDate;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartEntity cart;
	
	@Column
	private String test;
	
}