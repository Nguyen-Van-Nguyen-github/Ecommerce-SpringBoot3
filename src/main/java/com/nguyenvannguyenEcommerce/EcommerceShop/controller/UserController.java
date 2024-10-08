package com.nguyenvannguyenEcommerce.EcommerceShop.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvannguyenEcommerce.EcommerceShop.model.Category;
import com.nguyenvannguyenEcommerce.EcommerceShop.model.UserDtls;
import com.nguyenvannguyenEcommerce.EcommerceShop.service.CategoryService;
import com.nguyenvannguyenEcommerce.EcommerceShop.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public String home() {
		
		return "user/home";
	}
	
	@ModelAttribute
	public void getUserDetails(Principal p, Model m) {
		if(p!=null) {
			String email = p.getName();
			UserDtls userDtls = userService.getUserByEmail(email);
			m.addAttribute("user", userDtls);
		}
		List<Category> allActiveCategory = categoryService.getAllActiveCategory();
		m.addAttribute("categorys", allActiveCategory);
	}
	
}
