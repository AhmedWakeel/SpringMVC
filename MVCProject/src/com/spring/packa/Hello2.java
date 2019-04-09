package com.spring.packa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello2  {

	@RequestMapping("/welcome12")
	public ModelAndView hello(){
		ModelAndView andView = new ModelAndView("Display");
		andView.addObject("Name1", "Sam");
		return andView;
	}

}

