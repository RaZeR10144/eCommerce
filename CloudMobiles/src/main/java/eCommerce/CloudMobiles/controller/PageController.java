package eCommerce.CloudMobiles.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import eCommerce.CloudMobiles.exception.ProductNotFoundException;
import eCommerce.CloudMobilesBackend.dao.CategoryDAO;
import eCommerce.CloudMobilesBackend.dao.ProductDAO;
import eCommerce.CloudMobilesBackend.dao.UserDAO;
import eCommerce.CloudMobilesBackend.dto.Cart;
import eCommerce.CloudMobilesBackend.dto.Category;
import eCommerce.CloudMobilesBackend.dto.Product;
import eCommerce.CloudMobilesBackend.dto.User;

@Controller
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUGn ");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Registration");
		mv.addObject("userClickRegistration", true);
		return mv;
	}

	// save register
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView SaveRegistration(@Valid @ModelAttribute("user") User user, BindingResult results) 
	{
		
		ModelAndView mv = new ModelAndView();
		if (results.hasErrors()) {
			mv.setViewName("registration");
			return mv;

		} 
		else 
		{	
			//userDAO.addUser(user);
			//User user1 = user;
			Cart cart = null;
			// Create the cart for this user
			cart = new Cart();
			cart.setUser(user);
			//attach cart with user
			user.setCart(cart);
			
			/*if (user.getRole() == "USER") {
				// Create the cart for this user
				cart = new Cart();
				cart.setUser(user);

				//attach cart with user
				user.setCart(cart);
			}*/
			
			userDAO.addUser(user);
			
			mv.setViewName("redirect:/login");
			return mv;
		}

	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoeyDOA to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		// passing the single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	/*
	 * viewing single product
	 */

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");

		Product product = productDAO.get(id);

		if (product == null)
			throw new ProductNotFoundException();

		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		// ---------------------

		mv.addObject("title", product.getName());
		mv.addObject("product", product);

		mv.addObject("userClickShowProduct", true);

		return mv;
	}
	
	/*LOGIN*/
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) 
	{
		ModelAndView mv = new ModelAndView("login");
		
		if(error!=null)
		{
			mv.addObject("message", "Invalid Username and Password!");
		}
		if(logout!=null)
		{
			mv.addObject("logout", "You have successfully logged out!");
		}
		
		mv.addObject("title", "Login");
		return mv;
	}
	
	/* access denied page */
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		return mv;
	}
	
	/*Logout*/
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{
		//first we are going to fetch the authentication
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}

}
