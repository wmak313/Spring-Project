package com.benjamin.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllor {

	@RequestMapping("/")
	public String showHome(Model model) {

		return "home";
	}

}
