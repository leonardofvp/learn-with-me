package com.learn_with_me.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControler {
	
	@GetMapping({"/", "home"})
	private String home() {
		return "Estas en la home de learn with me";
	}

}
