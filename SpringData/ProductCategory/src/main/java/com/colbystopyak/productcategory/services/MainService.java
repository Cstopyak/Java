package com.colbystopyak.productcategory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colbystopyak.productcategory.models.Category;
import com.colbystopyak.productcategory.models.Product;
import com.colbystopyak.productcategory.repositories.CategoryRepository;
import com.colbystopyak.productcategory.repositories.ProductCategoryRepository;
import com.colbystopyak.productcategory.repositories.ProductRepository;
@Service
public class MainService {
	@Autowired
	private ProductRepository pRepo;

	@Autowired
	private ProductCategoryRepository cpRepo;

	@Autowired
	private CategoryRepository cRepo;

	public Product createProduct(Product filledProduct) {
		return pRepo.save(filledProduct);
		
	}

	public Category createCategory(Category filledCategory) {
		return cRepo.save(filledCategory);
		
	}

	public Product getProductById(Long product_id) {
		
		return pRepo.findById(product_id).orElse(null);
	}
	//all products from db
	public List<Product> getAllProducts() {
		
		return pRepo.findAll();
	}

	public List<Category> getAllCategory() {
		
		return cRepo.findAll();
	}

	

	
	
}
