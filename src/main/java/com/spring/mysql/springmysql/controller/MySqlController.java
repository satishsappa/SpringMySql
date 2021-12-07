package com.spring.mysql.springmysql.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mysql.springmysql.dao.MySqlRepository;
import com.spring.mysql.springmysql.entity.Product;


@RestController
public class MySqlController {

	@Autowired
	MySqlRepository mySqlRepository;

	@GetMapping("/fetchAllProducts")
	public List<Product> fetchProduct() {
		return mySqlRepository.findAll();
	}
	
	@PostMapping("/saveProducts")
	public List<Product> addProducts(@Valid @RequestBody List<Product> products){
		return mySqlRepository.saveAll(products);
	}
	
	@PostMapping("/saveProduct")
	public Product addProduct(@Valid @RequestBody Product product){
		return mySqlRepository.save(product);
	}
	
	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@Valid @RequestParam int productId){
		Optional<Product> productFound=mySqlRepository.findById(productId);
		if(productFound.isPresent()) {
			mySqlRepository.deleteById(productId);
			return "succesfully deleted.";
		}else{
			return "Product couldnt find.";
		}
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@Valid @RequestBody Product product){
		Optional<Product> productFound=mySqlRepository.findById(product.getId());
		if(productFound.isPresent()) {
			Product p=productFound.get();
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			mySqlRepository.save(p);
			return "succesfully updated.";
		}else{
			return "Product couldnt find.";
		}
	}
	
}
