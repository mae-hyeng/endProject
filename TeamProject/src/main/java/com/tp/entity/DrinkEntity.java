package com.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="drink")
public class DrinkEntity {

	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Long price;
	
}
