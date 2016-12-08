package ex02_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import ex02_spring.vo.BookVO;

@Component
public class BookDAO {
	@Autowired
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
