package com.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Data
@Entity(name = "user")
@Table(name = "user")
public class UserEntity extends BaseTimeEntity{

	 @Id // 湲곕낯�궎(Primary key)
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
