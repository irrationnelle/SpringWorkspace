package test01_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test01_spring.vo.BookVO;

public class Test {
	public static void main(String[] args) {
		// 이때 BookDao dao = new BookDao(); 로 객체 생성하면 안 된다!
		// 1. 먼저 기본 생성자가 존재하지 않음.
		// 2. BookDao 기본 생성자가 존재한다 하더라도 
		// 	  JdbcTemplate를 주입받은 BookDao 객체가 아님!
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test01_spring/applicationContext.xml");
		
		BookDao dao = context.getBean("bookDao", BookDao.class);
		
//		BookVO book = new BookVO("Spring", "Yangyu", 35000, "sds");
//		System.out.println(dao.insert(book));
		
		for(BookVO b: dao.selectAll()) {
			System.out.println(b);
		}
	}
}