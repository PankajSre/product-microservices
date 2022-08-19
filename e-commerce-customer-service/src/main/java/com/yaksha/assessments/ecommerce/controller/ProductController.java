package com.yaksha.assessments.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/all")
	public ResponseEntity<List<ProductEntity>> listAllProducts() {
		List<ProductEntity> list = productRepository.findAll();
		return ResponseEntity.ok(list);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
		Optional<ProductEntity> product = productRepository.findById(id);
		if (product.isPresent()) {
			return ResponseEntity.ok(product.get());
		} else {
			return ResponseEntity.ok("Product with id " + id + " does not exists");
		}

	}

}
