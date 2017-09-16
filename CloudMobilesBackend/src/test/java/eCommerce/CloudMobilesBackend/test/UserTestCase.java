package eCommerce.CloudMobilesBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.CloudMobilesBackend.dao.UserDAO;
import eCommerce.CloudMobilesBackend.dto.Cart;
import eCommerce.CloudMobilesBackend.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce.CloudMobilesBackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

	/*@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setAddress("khalsa,juhu road,vileparle(W)");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1231231231");
		user.setRole("USER");
		user.setPassword("12345");

		if (user.getRole().equals("USER")) {
			// Create the cart for this user
			cart = new Cart();
			cart.setUser(user);

			//attach cart with user
			user.setCart(cart);

		}
		
		// add the user
		assertEquals("Failed to add User!", true, userDAO.addUser(user));

	}*/

	@Test
	public void testUpdateCart()
	{
		//fetch the user by its email
		user = userDAO.getByEmail("hr@gmail.com");
		
		//get the cart of the user
		cart = user.getCart();
		
		cart.setGrandTotal(8888);
		
		cart.setCartLines(5);
		
		// assertEquals("Failed to update cart!", true, userDAO.updateCart(cart));
	}
}
