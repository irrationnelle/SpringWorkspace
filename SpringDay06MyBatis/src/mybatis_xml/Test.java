package mybatis_xml;

import vo.Book;

public class Test {
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		
//		for(BookVO book : dao.selectList()) {
//			System.out.println(book);
//		}
		
		Book b = new Book();
		b.setTitle("MyBatis");
		b.setPublisher("rase");
		b.setWriter("rase");
		b.setPrice(5000);
		
		System.out.println("insert ���: "+dao.insert(b));
	}
}
