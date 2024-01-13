package com.online.OnlineShop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.online.OnlineShop.entity.Product;
import com.online.OnlineShop.entity.User;
import com.online.OnlineShop.repository.UserProdNeed;
import com.online.OnlineShop.servise.ProductServise;
import com.online.OnlineShop.servise.UserServise;

@Controller
public class UserController {

	@Autowired
	private UserServise ser;
	@Autowired
	private ProductServise serv;
	@Autowired
	private UserProdNeed repo;

	@RequestMapping("/lets")
	public String letsdo() {
		return "home";
	}
	@RequestMapping("/logout")
	public ModelAndView outLog() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("../../index");
		return mav;
	}
	@RequestMapping(value = "/registerPage")
	public ModelAndView save(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		User user2 = ser.save(user);
		mav.addObject("out", user2.getId());
		mav.setViewName("regsucces");
		return mav;
	}

	@RequestMapping("/registerfor")
	public String regGo() {
		return "register";
	}

	@RequestMapping("/login")
	public ModelAndView save(@RequestParam("id") Integer id, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView();
		User user = ser.findById(id);
		try{if (ser.login(id, password) == false || user == null) {
			mav.setViewName("logshow");
			mav.addObject("log", "Login failed?");
			return mav;
		} else if (ser.login(id, password) == true) {
			User user1=ser.findById(id);
			mav.addObject("user", user);
			List<Product> products=serv.findProducts();
			mav.addObject("products",products);
			mav.setViewName("purchaseProducts");
			return mav;
		} else {
			mav.addObject("log", "Login failed?");
			mav.setViewName("logshow");
			return mav;
		}
		}catch(Exception e) {
			e.printStackTrace();
			mav.addObject("error", "theire is some issue from the technical side!! try again some time  ");
			mav.setViewName("error");
			return mav;
		}
	}
	
	@RequestMapping("/justin")
	private String justGo() {
		return "home";
		
	}
	@RequestMapping("updatePassword")
	public String upPassword() {
		return "userUpdate";
	}
	@RequestMapping("userUpdate")
	public ModelAndView upUserdate(@RequestParam("id") Integer id,@RequestParam("password") String password) {
		ModelAndView mav=new ModelAndView();
		String up=ser.updateUser(id, password);
		mav.addObject("up", up);
		mav.setViewName("pswdupdate");
		return mav;
		
	}
	
}