package com.colbystopyak.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.colbystopyak.productcategory.models.ProductCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
	List<ProductCategory> findAll();
}
