package com.bitwise.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitwise.login.LoginBean;
import com.bitwise.login.LoginValidator;

@Controller
// @RequestMapping("/helloworld")
public class LoginController {

	@Autowired
	LoginBean loginbean;

	@Autowired
	LoginValidator loginvalidator;

	// ProductDetails p1=new ProductDetails();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String init(Model model) {
		// model.addAttribute("message","Please enter following details");
		model.addAttribute("LoginBean", new LoginBean());
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model,@ModelAttribute("LoginBean") LoginBean loginBean,
			BindingResult result,HttpServletRequest request, HttpServletResponse response) {

		loginvalidator.validate(loginBean, result);

		if (result.hasErrors())
			return "login";
		else {
			model.addAttribute("message", "Online shopping");
			request.getSession().setAttribute("user","tejasvi");
			// model.addAttribute("ProductBean",new ProductBean());
			
			return "redirect:/success";
			
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("LoginBean", new LoginBean());
		return "login";
	
		}

	
}