package com.spring.packa;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController  {

	@RequestMapping("/welcome/{countryName}/{myName}")
//	public ModelAndView hello (@PathVariable("myName") String myName , @PathVariable("countryName") String countryName)
	public ModelAndView hello(@PathVariable Map<String, String> mp)
	{
		String countryName = mp.get("countryName");
		String myName = mp.get("myName");
		
		ModelAndView andView = new ModelAndView("Display");
		andView.addObject("Name", myName+" "+countryName);
		return andView;
	}
	
	@RequestMapping("/send")
	public ModelAndView hello1(Model model){
		ModelAndView andView = new ModelAndView("Display");
		andView.addObject("Name2", "Malik2");
		return andView;
	}

}



/*public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView andView = new ModelAndView("Display");
		andView.addObject("Name", "Malik");
		return andView;
	}

}*/
