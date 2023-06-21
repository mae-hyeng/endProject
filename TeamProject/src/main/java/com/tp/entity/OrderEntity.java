package com.tp.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Entity(name = "order")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment�� ����
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;
	
	@CreationTimestamp
	@Column
	private Timestamp order_date;
	
}
