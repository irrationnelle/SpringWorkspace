package Controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.BookService;
import vo.BookVO;

public class BookController {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService svc = context.getBean("bookService", BookService.class);
		
		System.out.println("Book �����ͺ��̽�");
		System.out.println("1.å�߰�  2.å��Ϻ���  3.å�˻�  4.å�������  5.å����  0.����");
		System.out.print("����: ");
		int num = scan.nextInt();
		
		String title;
		String writer;
		int price;
		String publisher;
		
		switch(num) {
		case 1:
			BookVO book = new BookVO();
			
			title = scan.nextLine();
			System.out.print("å����: ");
			title = scan.nextLine();
			System.out.print("å�۰�: ");
			writer = scan.next();
			System.out.print("å����: ");
			price = scan.nextInt();
			System.out.print("å����: ");
			publisher = scan.next();
			
			book.setTitle(title);
			book.setWriter(writer);
			book.setPrice(price);
			book.setPublisher(publisher);
			
			svc.add(book);
			book = svc.show(book.getBookNum());
			System.out.println(book);
			break;
		default:
			return;
		}
		
	}
}
