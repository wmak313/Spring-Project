package com.benjamin.spring.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.benjamin.spring.web.dao.Offer;
import com.benjamin.spring.web.dao.User;
import com.benjamin.spring.web.service.UsersService;

@Controller
public class LoginController {
	
	private UsersService usersService;
	
	@Autowired
	public void setUserService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model){
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	
	@RequestMapping(value="/createaccount", method = RequestMethod.POST)
	public String createAccount(Model model, @Valid User user, BindingResult result) {
		 
		if(result.hasErrors()){
			
			return "newaccount";
		}
		
		user.setAuthority("user");
		user.setEnabled(1);
		usersService.create(user);
		
		return "accountcreated";
	}
}
