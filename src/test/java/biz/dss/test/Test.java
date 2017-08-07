package biz.dss.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import biz.dss.dao.Product;
import biz.dss.dao.ProductDao;

public class Test {

	@org.junit.Test
	public void test() {
		/*
		 * ApplicationContext cont =new
		 * ClassPathXmlApplicationContext("spring-conf.xml"); SpringEditor
		 * se=(SpringEditor) cont.getBean("springEditor");
		 * se.loadDocument("sample.doc");
		 */

		/*
		 * ApplicationContext cont =new
		 * ClassPathXmlApplicationContext("spring-conf.xml");
		 * SpringEditorAnnotated se=(SpringEditorAnnotated)
		 * cont.getBean("springEditor"); se.loadDocument("sample.doc");
		 */

		@SuppressWarnings("resource")
		ApplicationContext cont = new ClassPathXmlApplicationContext("spring-conf.xml");
		ProductDao pd = (ProductDao) cont.getBean("productDao");

		
		 Product product=new Product();
		 product.setId(6);
		 product.setName("Oppo");
		 product.setPrice(25000);
		 
		 pd.add(product);
		 

		List<Product> list = pd.getAllProduct();
		for (Product p : list) {
			System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
		}

	}

}