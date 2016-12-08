package test01_spring;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookDao {
	private JdbcTemplate jdbcTemplate;
	
	
	// 외부에서 jdbcTemplate를 주입받기 위해 생성자나 setters를 만들어줘야 함.
	public BookDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
