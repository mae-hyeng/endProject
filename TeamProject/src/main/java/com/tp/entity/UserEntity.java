package com.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class UserEntity extends BaseTimeEntity{
	
	
	 @Id
	 @GeneratedValue(generator = "system-uuid")
	 @GenericGenerator(name="system-uuid", strategy = "uuid")
	 private String id;
	 @Column(length = 30, nullable=false)
	 private String username;
	 @Column
	 private String password;
	 @Column(length = 30, nullable=false)
	 private String name;
	 @Column(length = 30, nullable=false)
	 private String phone;
	 @Column(length = 30, nullable=false)
	 private String email;
	 @Column(length = 30, nullable=false)
	 private String address;
	 
//	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	 private List<Cart> cart;
	 


}