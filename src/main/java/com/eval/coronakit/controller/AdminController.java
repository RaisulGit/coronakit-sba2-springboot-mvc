package com.eval.coronakit.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;

	@GetMapping("/home")
	public String home() {
		return "admin-home";
	}

	@GetMapping("/product-entry")
	public String productEntry(Model model) {
		model.addAttribute("product",new ProductMaster());
		model.addAttribute("isNew",true);
		return "add-new-item";
	}

	@PostMapping("/product-save")
	public String productSave(@ModelAttribute("product") @Valid ProductMaster product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			String view = "add-new-item";
			return view;
		}
		else {
			productService.addNewProduct(product);
			model.addAttribute("products",productService.getAllProducts());
			model.addAttribute("isNew",false);		
		}
		return "show-all-item-admin";
	}


	@GetMapping("/product-list")
	public String productList(Model model) {
		model.addAttribute("products",productService.getAllProducts());
		return "show-all-item-admin";
	}

	@GetMapping("/product-delete")
	public String productDelete(@RequestParam("pid") int id, @ModelAttribute("product") ProductMaster product,Model model) {
		productService.deleteProduct(id);
		model.addAttribute("products",productService.getAllProducts());
		return "show-all-item-admin";
	}

}
