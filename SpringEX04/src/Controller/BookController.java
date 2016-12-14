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
		
		System.out.println("Book 데이터베이스");
		System.out.println("1.책추가  2.책목록보기  3.책검색  4.책내용수정  5.책삭제  0.종료");
		System.out.print("선택: ");
		int num = scan.nextInt();
		
		String title;
		String writer;
		int price;
		String publisher;
		
		switch(num) {
		case 1:
			BookVO book = new BookVO();
			
			title = scan.nextLine();
			System.out.print("책제목: ");
			title = scan.nextLine();
			System.out.print("책작가: ");
			writer = scan.next();
			System.out.print("책가격: ");
			price = scan.nextInt();
			System.out.print("책출판: ");
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
