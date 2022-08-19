package com.yaksha.assessments.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yaksha.assessments.ecommerce.entity.ProductEntity;
import com.yaksha.assessments.ecommerce.repository.ProductRepository;

@RestController
@RequestMapping("/api/admin/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/add")
	public ResponseEntity<?> registerProduct(@Valid @RequestBody ProductEntity productEntity, BindingResult result) {
		productRepository.save(productEntity);
		return ResponseEntity.ok(productEntity);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ProductEntity>> listAllProducts() {
		List<ProductEntity> list = productRepository.findAll();
		return ResponseEntity.ok(list);

	}

}
