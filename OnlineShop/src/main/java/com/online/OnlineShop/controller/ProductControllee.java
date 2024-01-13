package com.online.OnlineShop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.online.OnlineShop.entity.Payment;
import com.online.OnlineShop.entity.Product;
import com.online.OnlineShop.entity.User;
import com.online.OnlineShop.servise.ProductServise;
import com.online.OnlineShop.servise.UserServise;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
@RequestMapping("/product")
public class ProductControllee {

	@Autowired
	private ProductServise ser;
	@Autowired
	private UserServise serv;

	@RequestMapping("/go")
	public String showAddProductForm(Model model) {
		model.addAttribute("product", new Product());
		return "addingProduct";
	}

	@RequestMapping("/saver")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("out", ser.persisteProduct(product));
		mav.setViewName("upload");
		return mav;
	}

	@RequestMapping("/viewProduct/{productId}/{id}")
	public ModelAndView viewThatProduct(@PathVariable("productId") Integer productId, @PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		User user = serv.findById(id);
		Product product = ser.findById(productId);
		mav.addObject("user", user);
		mav.addObject("product", product);
		mav.setViewName("singleprodetails");
		return mav;
	}

	@RequestMapping("findAll")
	public ModelAndView findAllProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", ser.findProducts());
		mav.setViewName("purchaseProducts");
		return mav;

	}

	@RequestMapping("/iamcame/{productId}/{id}")
	public ModelAndView readyforPurchase(@PathVariable("productId") Integer productId, @PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		try {
			User user = serv.findById(id);
			Product product = ser.findById(productId);

			mav.addObject("user", user);
			if (user != null) {
				product.setUser(user);
				Product saverdProduct = ser.persisteProduct(product);
				if (user.getProducts() == null) {
					user.setProducts(new ArrayList<Product>());
				}
				user.getProducts().add(saverdProduct);
				serv.save(user);
				mav.addObject("user", user);
				mav.addObject("products", user.getProducts());

			}
			mav.setViewName("finalpurchase");
		} catch (Exception e) {
			e.printStackTrace();
			User user = serv.findById(id);
			mav.addObject("user", user);
			mav.addObject("error", "you have alredy purchased this item!!");
			mav.setViewName("error"); // Provide a custom error page

		}
		return mav;
	}

	@RequestMapping("/justproduct/{productId}/{id}")
	public ModelAndView directPurchase(@PathVariable("productId") Integer productId, @PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		try {
			User user = serv.findById(id);
			Product product = ser.findById(productId);

			mav.addObject("user", user);

			if (user != null && product != null) {
				List<Product> userProducts = user.getProducts();

				if (userProducts == null) {
					userProducts = new ArrayList<Product>();
				}

					product.setUser(user);
					Product savedProduct = ser.persisteProduct(product);
					userProducts.add(savedProduct);
					serv.save(user);
					mav.addObject("user", user);
					mav.addObject("product", product);
					mav.setViewName("paymentValidation");
					return mav;
				} else {
				mav.addObject("error", "Invalid user or product");
				mav.setViewName("error");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error",
					"Theire is some issues from the technical team!! please try agin later or By refreshin");

			mav.setViewName("error");
			return mav;
		}
	}

	@RequestMapping("/viewOrders")
	public ModelAndView orderedProducts(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		try {
			User user2 = serv.findById(id);
			List<Product> products = user2.getProducts();
			mav.addObject("user", user2);
			mav.addObject("products", products);
			mav.addObject("cal", 0.0);
			mav.setViewName("OrderProducts");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error", "theire is Some Issues While fetching the Products!");
			mav.setViewName("error"); // Provide a custom error page
			return mav;
		}
	}

	private boolean isProductAlreadyInCart(List<Product> userProducts, Integer productId) {
		if (userProducts != null) {
			for (Product product : userProducts) {
				if (productId.equals(product.getProductId())) {

					return true;
				}
			}
		}
		return false;
	}

	@RequestMapping("/calculate")
	public ModelAndView totalCost(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		User user = serv.findById(id);
		double sum = 0;
		if (user != null && user.getProducts() != null) {
			for (Product p : user.getProducts()) {
				sum = sum + p.getCost();
			}
			List<Product> products = user.getProducts();
			mav.addObject("user", user);
			mav.addObject("products", products);
			mav.addObject("cal", sum);
			mav.setViewName("OrderProducts");
			return mav;
		} else if (user.getProducts() == null) {
			mav.addObject("cal", 0);
			mav.setViewName("OrderProducts");
			return mav;
		}
		return mav;
	}

	@RequestMapping("/deleteUser")
	public ModelAndView userDelete(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		try {
			String s = serv.userDelete(id);
			mav.addObject("del", s);
			mav.setViewName("deletedAccount");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error", "You can't Delete your Account at this time!! Try another Some time??");
			mav.setViewName("error");
			return mav;
		}

	}

	@RequestMapping("/deleteproduct/{productId}/{id}")
	public ModelAndView productDelete(@PathVariable("productId") Integer productId, @PathVariable("id") Integer id) {

		ModelAndView mav = new ModelAndView();

		// Retrieve the user
		User user = serv.findById(id);

		// Remove the association between the user and the product
		Product productToRemove = ser.findById(productId);
		if (productToRemove != null) {
			user.getProducts().remove(productToRemove);
			serv.save(user); // Assuming you have a method to save changes to the user
		} else if (productToRemove == null) {
			user.getProducts();
			serv.save(user);
		}

		// Retrieve the updated list of purchased products for the user
		List<Product> purchasedProducts = user.getProducts();

		// ... rest of your code ...

		mav.addObject("user", user);
		mav.addObject("cal", 0.0);
		mav.addObject("products", purchasedProducts);
		mav.addObject("dele", "order was canceled");
		mav.setViewName("OrderProducts");
		return mav;
	}

	@RequestMapping("/canceled/{productId}/{id}")
	public ModelAndView productDeleted(@PathVariable("productId") Integer productId, @PathVariable("id") Integer id) {

		ModelAndView mav = new ModelAndView();

		// Retrieve the user
		User user = serv.findById(id);
       Product product=ser.findById(productId);
		// Remove the association between the user and the product
		if(user!=null) {
		Product productToRemove = ser.findById(productId);
		if (productToRemove != null) {
			user.getProducts().remove(productToRemove);
			user.setTotalAmmount(user.getTotalAmmount()+product.getCost());
			serv.save(user); // Assuming you have a method to save changes to the user
		}
		// Retrieve the updated list of purchased products for the user
		List<Product> purchasedProducts = user.getProducts();
        
		// ... rest of your code ...

		mav.addObject("user", user);
		mav.addObject("cal", 0.0);
		mav.addObject("products", purchasedProducts);
		mav.addObject("dele", "order was canceled");
		mav.setViewName("canceledProduct");
		return mav;
	}else {
		mav.addObject("error", "User not found!!!");
		mav.setViewName("error");
		return mav;
	}
	}
	@RequestMapping("/back/{id}")
	public ModelAndView viewAccount(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		User user = serv.findById(id);
		List<Product> list = ser.findProducts();
		mav.addObject("user", user);
		mav.addObject("products", list);
		mav.addObject("cal", 0.0);
		mav.setViewName("purchaseProducts");
		return mav;
	}

	@RequestMapping("/returnView")
	public ModelAndView ViewAgainOrders(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		User user2 = serv.findById(id);
		List<Product> products = user2.getProducts();
		mav.addObject("user", user2);
		mav.addObject("products", products);
		mav.addObject("cal", 0.0);
		mav.setViewName("OrderProducts");
		return mav;
	}

	@RequestMapping("/purchasePage")
	public ModelAndView againPurchase(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		User user2 = serv.findById(id);
		if(user2!=null) {
		List<Product> products = ser.findProducts();
		mav.addObject("user", user2);
		mav.addObject("products", products);
		mav.addObject("cal", 0.0);
		mav.setViewName("purchaseProducts");
		return mav;}else {
			mav.addObject("error", "User not found!!!");
			mav.setViewName("error");
			return mav;
		}
	}

	@RequestMapping("/purchaseIt/{productId}/{id}")
	public ModelAndView purchaseAgian(@PathVariable("productId") Integer productId, @PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();

		User user = serv.findById(id);
		Product product = ser.findById(productId);

		try {
			if (user != null && product != null) {

				mav.addObject("product", product);
				mav.addObject("user", user);
				mav.setViewName("paymentValidation");
				return mav;
			} else {
				mav.addObject("view", "Invalid Product or User!!");
				mav.setViewName("error");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("error",
					"Theire is some issues from the technical team!! please try agin later or By refreshin");

			mav.setViewName("error");
			return mav;
		}
	}

	@RequestMapping("/findAllUsers")
	public ModelAndView findUsers(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		User user2 = serv.findById(id);
		List<User> users = serv.list();
		mav.addObject("users", users);
		mav.addObject("user2", user2);
		mav.setViewName("AllUsers");
		return mav;

	}

	@RequestMapping("/redirectTopay/{productId}/{id}")
	public ModelAndView returnTopay(@PathVariable("productId") Integer productId, @PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		User user = serv.findById(id);
		Product product = ser.findById(productId);

		if (user != null && product != null) {
			List<Product> userProducts = user.getProducts();

			if (userProducts == null) {
				userProducts = new ArrayList<Product>();
			}

			if (!isProductAlreadyInCart(userProducts, productId)) {

				mav.addObject("user", user);
				mav.addObject("product", product);

			
				mav.setViewName("paymentValidation");
				return mav;
			} else {
				mav.addObject("view",
						"You already have this product in your cart!!" + "do You Want to Buy This product again");
				mav.addObject("product", product);
				mav.addObject("user", user);
				mav.setViewName("agaianPurchase");
				return mav;
			}
		} else {
			mav.addObject("order", "Theire is some issue while fetching the details!!!!");
			mav.setViewName("insufficient");
			return mav;
		}
	}

	@RequestMapping("/accountLogin")
	public ModelAndView finalPay(@RequestParam("cost") Double cost, @RequestParam("id") Integer id,
			@RequestParam("productId") Integer productId, @RequestParam("password") String password,HttpSession session)	
	{
		ModelAndView mav = new ModelAndView();

		User user = serv.findById(id);
		Product product = ser.findById(productId);
		Double totalAmmount = user.getTotalAmmount();
		
		// =======3rd if
		if (user != null && product != null) {
			// ======================2nd if
			if (serv.login(id, password) == true) {

				// -------------------------------------1st if
				if (product.getCost() <= totalAmmount) {
					user.setTotalAmmount(user.getTotalAmmount() - product.getCost());
//=================
					List<Product> userProducts = user.getProducts();

					if (userProducts == null) {
						userProducts = new ArrayList<Product>();
					}

					product.setUser(user);
					Product savedProduct = ser.persisteProduct(product);
					userProducts.add(savedProduct);
					serv.save(user);
					session.setAttribute("user", user);
					mav.addObject("user", user);
					mav.addObject("order", "OrderConfirmed");
					mav.addObject("products", userProducts);
					mav.setViewName("finalpurchase");
					return mav;

				} else {
         			mav.addObject("order", "Insufficient Balance");
					mav.setViewName("insufficient");
					return mav;
				} // for 2nd if
					// ---------------------------------1st if
			} else {
				mav.addObject("log", "password is incorrect");

				mav.setViewName("logshow");
				return mav;

			}
			// =====================2nd if
		} // for 3rd
		else {
			mav.addObject("order", "user or Product doesn't Exist");

			mav.setViewName("insufficient");
			return mav;
		}
	}
	@RequestMapping("/cehck")
	public ModelAndView balanceCheck(@RequestParam("id") Integer id) {
		ModelAndView mav=new ModelAndView();
		User user=serv.findById(id);
		mav.addObject("user", user);
		mav.setViewName("checkBalanace");
		return mav;
	}
	@RequestMapping("/fetchBalance")
	public ModelAndView balance(@RequestParam("id") Integer id,@RequestParam("password") String password) {
		ModelAndView mav=new ModelAndView();
		User user=serv.findById(id);
		if(user!=null ) {
			if(serv.login(id, password)==true) {
		mav.addObject("user", user.getTotalAmmount());
		mav.addObject("user1", user.getName());
		mav.setViewName("fetched");
		return mav;
			}else {
				mav.addObject("error", "password is incorrect");
				mav.setViewName("error");
				return mav;
			}
			
		}else {
			mav.addObject("error", "user not found");
			mav.setViewName("error");
		return mav;
		}
	}
}
