package ex01_spring;

import org.springframework.jdbc.core.JdbcTemplate;

import ex01_spring.vo.BookVO;

public class BookDAO {
	private JdbcTemplate jdbcTemplate;
	
	public BookDAO() {	}
	
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(BookVO book) {
		String sql = "INSERT INTO book (title, writer, price, publisher) VALUES(?, ?, ?, ?)";
		return jdbcTemplate.update(sql, book.getTitle(), book.getWriter(), book.getPrice(), book.getPublisher());
	}
}
