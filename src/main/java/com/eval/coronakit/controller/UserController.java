package com.eval.coronakit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	//Map<Integer,List<String>> map = new HashMap<>();
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}
	
	@RequestMapping("/show-kit")
	public String showKit(Model model) {
		return null;
	}

	@RequestMapping("/show-list")
	public String showList(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		return "show-all-item-user";
	}
	
	@RequestMapping("/add-to-cart")
	public String showKit(@RequestParam("pid") int id, @RequestParam("quantity") int quantity, @ModelAttribute("product") ProductMaster product,Model model) {
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!"+id);
		//System.out.println(map);	
		return "show-all-item-user";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return null;
	}
	
	@RequestMapping("/finalize")
	public String finalizeOrder(String address,Model model) {
		return null;
	}
	
	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId) {
		return null;
	}
}
