package com.spring.mysql.springmysql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mysql.springmysql.entity.Product;

@Repository
public interface MySqlRepository extends JpaRepository<Product, Integer>{
	
	
	List<Product> findByName(String name);

}
