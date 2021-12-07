package com.spring.mysql.springmysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	@NotNull(message ="name cannot be null")
	private String name;
	@Column
	@NotNull(message ="price cannot be null")
	private float price;
	/*
	 * public Integer getId() { return id; } public void setId(Integer id) { this.id
	 * = id; } public String getName() { return name; } public void setName(String
	 * name) { this.name = name; } public float getPrice() { return price; } public
	 * void setPrice(float price) { this.price = price; }
	 */
	
	
}
