package com.eval.coronakit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eval.coronakit.entity.KitDetail;
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
	
	Map<Integer, List<String>> globalMap = new HashMap<>();
	int globalTqy = 0;
	int globalTamnt = 0;
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}

	@RequestMapping("/show-kit")
	public String showKit(Model model) {
		model.addAttribute("map", globalMap);
		model.addAttribute("totalqty", globalTqy);
		model.addAttribute("tamnt", globalTamnt);
		return "show-cart";
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
			  lst1.add(String.valueOf(p.getCost()));
			  lst1.add(String.valueOf(amount));  
			  map.put(p.getId(), lst1);
		}
		model.addAttribute("map", map);
		model.addAttribute("totalqty", tqy);
		model.addAttribute("tamnt", tamnt);
		globalMap=map;
		globalTamnt=tamnt;
		globalTqy=tqy;
		//checkout(product, model, map);
		return "show-cart";
	}

	@RequestMapping("/checkout")
	public String checkout(@ModelAttribute("product") ProductMaster product,Model model) {
			KitDetail kit = new KitDetail();
			int randomKitId=(int)Math.random()*10000;
			kit.setCoronaKitId(randomKitId);
			kit.setAmount(globalTamnt);
			for (Integer key : globalMap.keySet()) {
			    System.out.println("Key = " + key);
			}

			// Iterating over values only
			for (Integer value : globalMap.values()) {
			    System.out.println("Value = " + value);
			}
		  
		  //kitDetailService.addKitItem(kitItem);
		 
		return "checkout-address";
	}

	@RequestMapping("/finalize")
	public String finalizeOrder(String address, Model model) {
		return "show-summary";
	}

	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("pid") int pid,@RequestParam("qty") int qty,ProductMaster product,Model model) {
			
			  ProductMaster p = productService.getProductById(pid); 
			  int amount=p.getCost()*qty;
			  globalTamnt=globalTamnt-amount;
			  globalTqy=globalTqy-qty;
			  globalMap.remove(pid); 			 
			  model.addAttribute("map", globalMap); 
			  model.addAttribute("totalqty", globalTqy); 
			  model.addAttribute("tamnt",globalTamnt);			 
			  return "show-cart";

	}
}
