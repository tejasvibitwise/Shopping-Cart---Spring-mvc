package com.bitwise.cart;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	CountProduct countProduct;
	
@Autowired

ProductList productList;

@Autowired
CartItems cartItems;


	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView save() {
		
		
		
		return new ModelAndView("success", "productList", productList);
		
		}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public ModelAndView addProduct(Model model,@RequestParam String id) {
	
		int c=countProduct.incrementCount();
		
		ProductDetails product=productList.findProduct(id);
		
		cartItems.additem(product);
		
		model.addAttribute("count", c);
		
		return new ModelAndView("success", "productList", productList);
	
		}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewProduct(Model model) {
	

		return new ModelAndView("viewcart", "cartItems", cartItems);
	
		}

	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public ModelAndView removeProduct(Model model,@RequestParam String id) {
	
		
		cartItems.removeProduct(id);
		
		return new ModelAndView("viewcart", "cartItems", cartItems);
	
		}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView displayProduct() {
	
		return new ModelAndView("success", "productList", productList);
	
		}
	
	@RequestMapping(value = "/placeorder", method = RequestMethod.GET)
	public ModelAndView placeOrder(Model model) {
	
		
		
		
		model.addAttribute("total",cartItems.placeOrder());
		
		return new ModelAndView("placeOrder", "cartItems", cartItems);
		}
	
	
	
	
	
	
	

}
