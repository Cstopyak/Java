package com.colbystopyak.productcategory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.colbystopyak.productcategory.models.Category;
import com.colbystopyak.productcategory.models.Product;
import com.colbystopyak.productcategory.models.ProductCategory;
import com.colbystopyak.productcategory.services.MainService;

@Controller
public class MainController {
	
	
	@Autowired
	private MainService mainServ;
	
	//--creating product--
	@GetMapping("/")
	public String index(@ModelAttribute("product") Product emptyProduct) {
	    return "index.jsp";
	}
//accepting the information in the form--
	@PostMapping("product/new")
	public String createProduct(@ModelAttribute("product") Product filledProduct) {
		mainServ.createProduct(filledProduct);
		return "redirect:/category/new";
	}
	//--Creating Category--
	@GetMapping("/category/new")
	public String newCategory(@ModelAttribute("category") Category emptyCategory) {
		return "category.jsp";
	}
	//--accepting form info category.jsp
	@PostMapping("/category/new")
	public String createCategory(@ModelAttribute("category") Category filledCategory) {
		mainServ.createCategory(filledCategory);
		return "redirect:/";
	}
	
	//creating relationship between product
	@GetMapping("product/{product_id}")
	public String showProduct(@PathVariable("product_id") Long product_id, Model model, @ModelAttribute("productcategory") ProductCategory emptyProductCategory) {
		
		Product product = mainServ.getProductById(product_id);
		model.addAttribute("prodObj", product);
		//System.out.println(product_id);
		
		
		//get all category from DB
		List<Category> allCategoryDB = mainServ.getAllCategory();
		//pass all product from DB
		model.addAttribute("allCategory", allCategoryDB);
		return "product.jsp";
	}
}
