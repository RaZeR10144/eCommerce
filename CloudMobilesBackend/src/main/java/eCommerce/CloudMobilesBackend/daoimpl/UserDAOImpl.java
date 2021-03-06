package eCommerce.CloudMobilesBackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eCommerce.CloudMobilesBackend.dao.UserDAO;
import eCommerce.CloudMobilesBackend.dto.Cart;
import eCommerce.CloudMobilesBackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public boolean addUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	// related to cart
		/*@Override
		public boolean updateCart(Cart cart) {
			try {
				sessionFactory.getCurrentSession().update(cart);
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}

		}*/
		
	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email= :email";
		try
		{
			return sessionFactory.getCurrentSession()
			.createQuery(selectQuery, User.class)
			.setParameter("email", email).getSingleResult();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}

}
