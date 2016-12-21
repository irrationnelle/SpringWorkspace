package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BookDAO;
import vo.BookListVO;
import vo.BookVO;

@Component
public class BookService {
	@Autowired
	private BookDAO dao;

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}
	
	public BookListVO makeList(int currentPage) {
		final int COUNT_PER_PAGE = 5;
		final int EACH_PAGE = 5; 
		
		int totalPage = dao.selectCount()/COUNT_PER_PAGE;
		if(dao.selectCount()%COUNT_PER_PAGE != 0)
			totalPage++;
		
		int startPage = currentPage/EACH_PAGE*EACH_PAGE+1;
		int endPage = startPage + (EACH_PAGE-1);
		if(totalPage<=endPage) {
			endPage = totalPage;
		}
		
		int startRow = (currentPage-1)*COUNT_PER_PAGE;
		int endRow = startRow + COUNT_PER_PAGE;
		List<BookVO> list = dao.selectList(startRow, endRow);
		
		BookListVO bookList = new BookListVO(startPage, endPage, totalPage, currentPage, list);
		return bookList;
	}
	
	public int add (BookVO book) {
		int result = -1;
		result = dao.insert(book);
		return result;
	}
	
	public int edit (BookVO book) {
		int result = -1;
		result = dao.update(book);
		return result;
	}
	
	public int remove (int bookNum) {
		int result = -1;
		result = dao.delete(bookNum);
		return result;
	}
	
	public BookVO read (int bookNum) {
		BookVO book = new BookVO();
		book = dao.select(bookNum);
		return book;
	}
}
