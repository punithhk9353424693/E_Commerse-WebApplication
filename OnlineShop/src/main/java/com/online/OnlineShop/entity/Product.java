package com.online.OnlineShop.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	  private String productName;
	  private String description;
	    private double cost;
     private String productColor;
     private String model;

	@ManyToOne @JoinColumn(name = "id")
	private User user;
	

		public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

		public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}
    

		

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
       
		public String getProductColor() {
			return productColor;
		}

		public void setProductColor(String productColor) {
			this.productColor = productColor;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
					+ ", cost=" + cost + ", productColor=" + productColor + ", model=" + model + "]";
		}
		

		
		
  
}