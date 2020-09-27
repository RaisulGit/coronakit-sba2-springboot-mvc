package com.eval.coronakit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		model.addAttribute("products", productService.getAllProducts());
		return "show-all-item-user";
	}

	@PostMapping("/add-to-cart")
	public String showKit(@RequestParam("quantity") String quantity, @ModelAttribute("product") ProductMaster product,
			Model model) {
		Map<Integer, List<String>> map = new HashMap<>();
		List<String> lst = new ArrayList<>();
		String[] arr = quantity.split(",");
		for (String i : arr) {
			if (i.charAt(1) != '0') {
				lst.add(i);
			}

		}	
		int tqy = 0;
		int tamnt = 0;
		for (int i = 0; i < lst.size(); i++) {
			tqy=tqy+Character.getNumericValue((lst.get(i).charAt(1)));
			ProductMaster p = productService.getProductById(Character.getNumericValue((lst.get(i).charAt(0))));
			List<String> lst1 = new ArrayList<>();
			int amount = Character.getNumericValue((lst.get(i).charAt(1)))*p.getCost();
			tamnt=tamnt+amount;
			  lst1.add(p.getProductName());
			  lst1.add(String.valueOf(lst.get(i).charAt(1)));
			  lst1.add(String.valueOf(amount));  
			  map.put(p.getId(), lst1);
		}
		System.out.println("LLLLLLLLLLLLLLL"+tqy);
		model.addAttribute("map", map);
		model.addAttribute("totalqty", tqy);
		model.addAttribute("tamnt", tamnt);
		return "show-cart";
	}

	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return null;
	}

	@RequestMapping("/finalize")
	public String finalizeOrder(String address, Model model) {
		return null;
	}

	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId) {
		return null;
	}
}
