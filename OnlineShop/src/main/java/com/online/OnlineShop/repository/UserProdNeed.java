package com.online.OnlineShop.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.online.OnlineShop.entity.Product;
import com.online.OnlineShop.entity.User;

@Repository
public class UserProdNeed {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public User save(User user) {
		et.begin();
		em.persist(user);
		et.commit();
		return user;
	}

	public boolean login(Integer id, String password) {
		et.begin();
		User user = em.find(User.class, id);
		et.commit();
		if (user == null) {
			return false;
		} else if (user.getId() == id && user.getPassword().equals(password) && user != null) {
			return true;
		} else {
			return false;
		}

	}

	public Product saveProduct(Product product) {
		et.begin();
		em.persist(product);
		et.commit();
		return product;
	}

	public User findById(Integer id) {
		et.begin();
		User user = em.find(User.class, id);
		et.commit();
		return user;
	}

	@Transactional
	public String userDelete(Integer id) {
		et.begin();
		User user = em.find(User.class, id);
		if (user != null) {
			for (Product p : user.getProducts()) {
				em.remove(p);
			}

			em.remove(user);

			et.commit();
			return "Account was Deleted";
		} else {
			et.rollback();
			return "User not found for deletion";
		}
	}

	public Product findByProductId(Integer productId) {
		et.begin();
		Product product = em.find(Product.class, productId);
		et.commit();
		return product;
	}

	public Integer findByProductIdforCheck(Integer productId) {
		et.begin();
		Product product = em.find(Product.class, productId);
		et.commit();
		return product.getProductId();
	}

	public List<Product> findAllProducts() {
		Query query = em.createQuery("select s from Product s");
		List<Product> list = query.getResultList();
		return list;
	}

	public Product productDeleted(Integer productId) {
		et.begin();
		Product product = em.find(Product.class, productId);
		em.remove(product);
		et.commit();
		return product;

	}

	public User deleteAllProducts(Integer id) {
		User user = em.find(User.class, id);
		List<Product> products = user.getProducts();
		if (user != null) {
			for (Product product : products) {
				em.remove(product);
			}

		}
		return user;
	}

	public String updatePassword(Integer id, String password) {
		et.begin();
		User user = em.find(User.class, id);
		user.setPassword(password);
		em.merge(user);
		em.persist(user);
		et.commit();
		return "Password was Updated";

	}
	public List<User> findAll(){
		Query query=em.createQuery("select s from User s");
		 List<User> list=query.getResultList();
		 return list;
	}

}
