package eCommerce.CloudMobilesBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import eCommerce.CloudMobilesBackend.dao.CategoryDAO;
import eCommerce.CloudMobilesBackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO 
{
	private static List<Category> categories = new ArrayList<>();
	
	static
	{
		Category category = new Category();
		
		//Adding first category
		category.setId(1);
		category.setName("Television");
		category.setDiscription("This is some discription for Televion");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		category = new Category();
		//Adding second category
		category.setId(2);
		category.setName("Mobile");
		category.setDiscription("This is some discription for Mobile");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		category = new Category();
		//Adding third category
		category.setId(3);
		category.setName("Laptop");
		category.setDiscription("This is some discription for Laptop");
		category.setImageURL("CAT_3.png");
		categories.add(category);
		
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
