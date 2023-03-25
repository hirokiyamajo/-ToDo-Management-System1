package com.dmm.task1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/loginForm")
	String loginForm() {
		return "login";
	}

}
