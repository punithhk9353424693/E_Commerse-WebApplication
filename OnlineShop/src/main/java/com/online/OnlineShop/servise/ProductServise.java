package com.online.OnlineShop.servise;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.OnlineShop.entity.Product;
import com.online.OnlineShop.repository.UserProdNeed;

@Service
public class ProductServise {
	@Autowired
	private UserProdNeed one;

	public Product persisteProduct(Product product) {
		Product product1=one.saveProduct(product);
		return product1;
	}
	public List<Product> findProducts(){
		return one.findAllProducts();
	}
	public Product findById(Integer productId) {
	return one.findByProductId(productId);
		
	}
	public Product deleteProduct(Integer productId) {
	return	one.productDeleted(productId);
	}
	public Integer findByIdForExist(Integer productId) {
		return one.findByProductIdforCheck(productId);
			
		}
}