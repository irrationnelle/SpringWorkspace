package test01_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test01_spring.vo.BookVO;

public class Test {
	public static void main(String[] args) {
		// �̶� BookDao dao = new BookDao(); �� ��ü �����ϸ� �� �ȴ�!
		// 1. ���� �⺻ �����ڰ� �������� ����.
		// 2. BookDao �⺻ �����ڰ� �����Ѵ� �ϴ��� 
		// 	  JdbcTemplate�� ���Թ��� BookDao ��ü�� �ƴ�!
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test01_spring/applicationContext.xml");
		
		BookDao dao = context.getBean("bookDao", BookDao.class);
		
		BookVO book = new BookVO("Spring", "Yangyu", 35000, "sds");
		System.out.println(dao.insert(book));
	}
}