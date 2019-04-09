package com.spring.packa;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormHandling {

	@InitBinder
	public void initBinder(WebDataBinder value)
	{
		value.setDisallowedFields(new String[]{"studMob"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
		value.registerCustomEditor(Date.class,"studDOB", new CustomDateEditor(dateFormat, false));
		value.registerCustomEditor(String.class,"name", new StudentBinder());
	}
	
	@RequestMapping(value = "/fill", method = RequestMethod.GET)
	public ModelAndView fillForm() {
//		map.addAttribute("student1", new Student());
//		ModelAndView andView = new ModelAndView("FillForm");
//		andView.addObject("headerMessage", "this is the header message");
		return new ModelAndView("FillForm", "student1", new Student());
//		return "FillForm";
	}
	
	@ModelAttribute
	public void modelHeader(Model value)
	{
		value.addAttribute("headerMessage", "this is the header message");
	}
	
	
	@RequestMapping(value = "/sbmit", method = RequestMethod.POST)
//	public ModelAndView submitForm(@RequestParam("name") String name, @RequestParam("city") String city) 
//	public ModelAndView submitForm(@RequestParam(value="name",defaultValue="MW") String name, @RequestParam(value="city",defaultValue="pune") String city)
//	public ModelAndView submitForm(@ModelAttribute Student student1)
	public ModelAndView submitForm(@Validated @ModelAttribute("student1") Student student1,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			ModelAndView andView = new ModelAndView("SubmitForm");
			return andView;
		}
		System.out.println(student1.getName());
		ModelAndView andView = new ModelAndView("SubmitForm");
//		andView.addObject("headerMessage", "this is the header message");
		return andView;
	}
	
	
	@RequestMapping(value = "/sbmit1", method = RequestMethod.POST)
//	public ModelAndView submitForm(@RequestParam("name") String name, @RequestParam("city") String city) 
//	public ModelAndView submitForm(@RequestParam(value="name",defaultValue="MW") String name, @RequestParam(value="city",defaultValue="pune") String city)
//	public ModelAndView submitForm(@ModelAttribute Student student1)
//	public ModelAndView submitForm1(@Valid @ModelAttribute("student13") Student student1,BindingResult bindingResult, HttpServletRequest httpServletRequest) throws IOException
	public String submitForm1(@Valid @ModelAttribute("student13") Student student1,BindingResult bindingResult, HttpServletRequest httpServletRequest) throws IOException
	{
		System.out.println(httpServletRequest.getCharacterEncoding());
		/*if(bindingResult.hasErrors())
		{
			ModelAndView andView = new ModelAndView("SubmitForm");
			return andView;
		}*/
		final Writer writer1 = new FileWriter("D:\\zz.txt");
		String name = student1.getName();
		System.out.println(name);
		writer1.write(name);
		writer1.close();
		SendMailSSL.send("wakeelmalik123@gmail.com","W213508213508@","wakeelmalik123@hotmail.com","Sending mail from SMTP server",student1.getName());
		System.out.println(student1.getName());
//		ModelAndView andView = new ModelAndView("SubmitForm");
//		ModelAndView andView = new ModelAndView("redirect:final");
//		andView.addObject("headerMessage", "this is the header message");
//		return andView;
//		return "redirect:/final";
		return "redirect:/pages/final.htm";
	}
	
	 @RequestMapping(value = "/final", method = RequestMethod.GET)
	   public String finalPage() {
	     
	      return "final";
	   }
	
	
/*	@RequestMapping(value = "/sbmit", method = RequestMethod.POST)
//	public ModelAndView submitForm(@RequestParam("name") String name, @RequestParam("city") String city) 
//	public ModelAndView submitForm(@RequestParam(value="name",defaultValue="MW") String name, @RequestParam(value="city",defaultValue="pune") String city)
	public ModelAndView submitForm(@RequestParam("name") String name,@RequestParam("hobby") String hobby)
	{
		Student student = new Student();
		student.setName(name);
		student.setHobby(hobby);
		
		ModelAndView andView = new ModelAndView("SubmitForm");
		andView.addObject("student", student);
		return andView;
	}*/

	
	
	
/*
	@RequestMapping(value = "/sbmit", method = RequestMethod.POST)
//	public ModelAndView submitForm(@RequestParam("name") String name, @RequestParam("city") String city) 
//	public ModelAndView submitForm(@RequestParam(value="name",defaultValue="MW") String name, @RequestParam(value="city",defaultValue="pune") String city)
	public ModelAndView submitForm(@RequestParam Map<String, String> mp)
	{
		    String name = mp.get("name");
		    String city = mp.get("city");
		    
		ModelAndView andView = new ModelAndView("SubmitForm");
		andView.addObject("msg", "Your Name is " + name + " and City is " + city);
		return andView;
	}
	
*/	
	
/*	
    @RequestMapping(value = "/sbmit", method = RequestMethod.POST)
//	public ModelAndView submitForm(@RequestParam("name") String name, @RequestParam("city") String city) 
//	public ModelAndView submitForm(@RequestParam(value="name",defaultValue="MW") String name, @RequestParam(value="city",defaultValue="pune") String city)
	public String submitForm(@RequestParam Map<String, String> mp, Model model )
	{
		    String name = mp.get("name");
		    String city = mp.get("city");
		    
		    model.addAttribute("name", name);
		    model.addAttribute("city", city);
//		ModelAndView andView = new ModelAndView("SubmitForm");
//		andView.addObject("msg", "Your Name is " + name + " and City is " + city);
		return "SubmitForm";
	}
*/

}
