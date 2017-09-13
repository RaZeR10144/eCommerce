package eCommerce.CloudMobilesBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.CloudMobilesBackend.dao.CartLineDAO;
import eCommerce.CloudMobilesBackend.dao.ProductDAO;
import eCommerce.CloudMobilesBackend.dao.UserDAO;
import eCommerce.CloudMobilesBackend.dto.Cart;
import eCommerce.CloudMobilesBackend.dto.CartLine;
import eCommerce.CloudMobilesBackend.dto.Product;
import eCommerce.CloudMobilesBackend.dto.User;

public class CartLineTestCase 
{
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce.CloudMobilesBackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
				
	}
	
	@Test
	public void testAddNewCartLine()
	{
		// 1. get the user
		user = userDAO.getByEmail("hr@gmail.com");
		
		// 2. fetch the cart
		cart = user.getCart();
		
		// 3. get the product
		product = productDAO.get(1);
		
		// 4. create a new cartline
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartline", true, cartLineDAO.add(cartLine));
		
		// update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
		
	}
		
}
