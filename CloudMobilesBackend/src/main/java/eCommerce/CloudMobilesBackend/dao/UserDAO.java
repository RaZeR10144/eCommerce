package eCommerce.CloudMobilesBackend.dao;

import eCommerce.CloudMobilesBackend.dto.Cart;
import eCommerce.CloudMobilesBackend.dto.User;

public interface UserDAO 
{
	// add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	//add a cart
	//boolean updateCart(Cart cart);
}
