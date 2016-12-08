package ex02_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ex02_spring.vo.BookVO;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex02_spring/applicationContext.xml");
		
		BookDAO dao = context.getBean("bookDAO", BookDAO.class);
		
		BookVO book = new BookVO("node.js", "rase", 25000, "Hanbit");
		
		System.out.println(dao.insert(book));
	}
}
