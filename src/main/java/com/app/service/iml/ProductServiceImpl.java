package com.app.service.iml;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Product;
import com.app.repository.ProductRepository;
import com.app.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;

	//save method
	@Transactional
	public Integer saveProduct(Product p) {
		//calculations here
		p=repo.save(p);
		return p.getId();
	}

	//get all product details from databse
	@Transactional
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}

	//delete record based on id
	@Transactional
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
		
	}

	//get record based on id
	@Transactional
	public Product getProductById(Integer id) {
		
		return repo.getProductById(id);
	}

}
