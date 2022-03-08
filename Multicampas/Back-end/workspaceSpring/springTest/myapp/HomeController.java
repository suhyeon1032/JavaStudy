package com.campus.myapp;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	//@RequestMapping(value = "/", method = RequestMethod.GET)
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		//Model�� ���������� ������ �����͸� ������ �� �ִ�.
		
		model.addAttribute("msg", "ó�� �����ϴ� ������" );
		return "home"; // �� ���ϸ�
	}
	
}
