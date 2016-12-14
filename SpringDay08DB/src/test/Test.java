package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import repository.BookDAO;
import vo.Book;

public class Test {
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		BookDAO dao = context.getBean("bookDAO", BookDAO.class);
		
		Book book = new Book("MyBatis", "Rase", "Rase", 20000);
		
		for(Book b : dao.selectAllList()) {
			System.out.println(b);
		}
	}
}
