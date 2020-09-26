package com.eval.coronakit.controller;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eval.coronakit.dao.CoronaKitRepository;
import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.dao.RolesRepository;
import com.eval.coronakit.dao.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepo;
	@Autowired
	RolesRepository rolesRepo;
	@Autowired
	ProductMasterRepository productRepo;
	@Autowired
	KitDetailRepository kitRepo;
	@Autowired
	CoronaKitRepository coronaRepo;
	
	@RequestMapping("/")
	public String index() {
		return  "index";
	}
	
	@RequestMapping("/home")
	public String home() {
		return  "main-menu";
	}
	
	@RequestMapping("/header")
	public ModelAndView showHeader() {
		ModelAndView mv = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();
			mv.addObject("unm",auth.getName());
			mv.addObject("role",role);
		}
		return  mv;
	}
}
