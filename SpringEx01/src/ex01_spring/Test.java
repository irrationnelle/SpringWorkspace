package ex01_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ex01_spring.vo.BookVO;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex01_spring/applicationContext.xml");
		
		BookDAO dao = context.getBean("dao", BookDAO.class);
		
		BookVO book = new BookVO("Angular2", "rase", 27000, "Wikibooks");
		System.out.println(dao.insert(book));
	}
}
