package test01_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	// �ܺο��� jdbcTemplate�� ���Թޱ� ���� �����ڳ� setters�� �������� ��.
	public BookDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}