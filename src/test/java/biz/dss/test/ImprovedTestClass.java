package biz.dss.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import biz.dss.dao.Product;
import biz.dss.dao.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-conf.xml")

public class ImprovedTestClass 
{
	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testAdd()
	{
		

		
		 Product product=new Product();
		 product.setId(8);
		 product.setName("Oppo");
		 product.setPrice(25000);
		 
		 productDao.add(product);
	}
	
	@Test
	public void testShow()
	{
		List<Product> list = productDao.getAllProduct();
		for (Product p : list) {
			System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
		}

	}
	
}
