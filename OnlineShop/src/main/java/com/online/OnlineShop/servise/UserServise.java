package com.online.OnlineShop.servise;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.OnlineShop.entity.User;
import com.online.OnlineShop.repository.UserProdNeed;

@Service
public class UserServise {

	@Autowired
	private UserProdNeed one;
	
	public User save(User user) {
		User user2=one.save(user);
		return user2;
	}
	public boolean login(Integer id,String password) {
		
		if(one.login(id, password)==true) {
			return true;
		}else {
			return false;
		}
	}
	public User findById(Integer id) {
		return one.findById(id);
		
	}
    @Transactional
	public String userDelete(Integer id) {
		return one.userDelete(id);
	}
	
	public User deleteAllProducts(Integer id) {
		return one.deleteAllProducts(id);
	}
	public String updateUser(Integer id,String password) {
		return one.updatePassword(id, password);
		
	}
	public List<User> list(){
		return one.findAll();
	}
}
