package eCommerce.CloudMobilesBackend.dao;

import java.util.List;

import eCommerce.CloudMobilesBackend.dto.Cart;
import eCommerce.CloudMobilesBackend.dto.CartLine;

public interface CartLineDAO 
{
	// the common methods for previously coded one
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// other business methods related to cart lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//add a cart
	boolean updateCart(Cart cart);
}
