package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Product;
import com.app.service.ProductService;

@Controller
@RequestMapping("/emp")
public class ProductController {

	@Autowired
	private ProductService service;
	
	//1.show product from with backing object
	@RequestMapping("/reg")
	public String showReg(Model map) {
		//from Backing object
		map.addAttribute("product",new Product());
		return "Register";
	}
	
	//2.read from data on click submit
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveData(@ModelAttribute Product product,Model map) {
		
		//call service layer
		Integer id=service.saveProduct(product);
		map.addAttribute("message","Product '"+id+"' created..!");
		//check from backing object
		map.addAttribute("product",new Product());
		return "Register";
	}
	
	//3.fetch all rows from ui
	@RequestMapping("/all")
	public String showAll(Model map) {
		//fetch all rows from database
		List<Product> obs=service.getAllProducts();
		//send to ui
		map.addAttribute("list",obs);
		return "Data";
	}
	
	//4.delete row based on id
	@RequestMapping("/delete")
	public String remove(@RequestParam Integer id) {
		
		//delete row based id
		service.deleteProduct(id);
		//response redirect
		return "redirect:all";
	}
	
	//5.show edit page
	@RequestMapping(value = "edit")
	public String showEdit(@RequestParam Integer id,Model map) {
		//load object from database
		Product p=service.getProductById(id);
		//from backing object
		map.addAttribute("product",p);
		map.addAttribute("Mode","Edit");
		return "Register";
	}
}
