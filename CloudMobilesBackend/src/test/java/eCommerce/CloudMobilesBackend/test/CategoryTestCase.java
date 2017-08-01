package eCommerce.CloudMobilesBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eCommerce.CloudMobilesBackend.dao.CategoryDAO;
import eCommerce.CloudMobilesBackend.dto.Category;

public class CategoryTestCase 
{
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass	
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("eCommerce.CloudMobilesBackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory()
	{
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some discription for Televion");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added category inside the table!",true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory()
	{
		category = categoryDAO.get(3);
		
		assertEquals("Successfully fetched category from the table!","Television",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory()
	{
		category = categoryDAO.get(3);
		category.setName("TV");
		assertEquals("Successfully updated category in the table!",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory()
	{
		category = categoryDAO.get(3);
		
		assertEquals("Successfully deleted category in the table!",true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory()
	{
		category = categoryDAO.get(3);
		
		assertEquals("Successfully fetched the list of categories from the table!",2,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory()
	{
		// add opration
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some discription for Televion");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added category inside the table!",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some discription for laptop");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added category inside the table!",true,categoryDAO.add(category));
		
		// fetching and updating the category
		category = categoryDAO.get(2);
		category.setName("LAPPY");
		assertEquals("Successfully updated category in the table!",true,categoryDAO.update(category));
		
		// delete the category
		assertEquals("Successfully deleted category in the table!",true,categoryDAO.delete(category));
		
		// fetching the category
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());
		
	}
	
}
