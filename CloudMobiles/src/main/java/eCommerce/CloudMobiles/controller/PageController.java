package eCommerce.CloudMobiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Login");
		mv.addObject("userClickLogin",true);
		return mv;
	}
	
	@RequestMapping(value = "/registration")
	public ModelAndView registration()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Registration");
		mv.addObject("userClickRegistration",true);
		return mv;
	}
}
