package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BookDAO;
import vo.BookVO;

@Component
public class BookService {
	@Autowired
	private BookDAO dao;
	
	public int add (BookVO book) {
		int result = -1;
		return result = dao.insert(book);
	}
	
	public int edit (BookVO book) {
		int result = -1;
		return result = dao.update(book);
	}
	
	public int delete(int bookNum) {
		int result = -1;
		return result = dao.delete(bookNum);
	}
	
	public BookVO show(int bookNum) {
		BookVO book = dao.select(bookNum);
		return book;
	}
	
	public List<BookVO> showList() {
		List<BookVO> list = dao.selectList();
		return list;
	}
}
