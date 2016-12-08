package test01_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import test01_spring.vo.BookVO;

@Component
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BookDao(){}
	
	// �ܺο��� jdbcTemplate�� ���Թޱ� ���� �����ڳ� setters�� �������� ��.
	// �⺻�����ڰ� �ƴϱ� ������ applicationContext���� ���� �����ϱ� ���� ���� �ʿ�
	public BookDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	// Ŀ�ؼ��� ������ �ʱ� ������ try-catch���� �ʿ����
	// ���� PreparedStatement�� ����Ͽ� ������ ? ���� ä��� �۾� ���� �ʿ����
	public int insert(BookVO book) {
		String sql = "insert into book(title, writer, publisher, price)" +
					 "values(?, ?, ?, ?)";
		
		// String���� int���� �ڷ����� ������ �ʿ䵵 ���� �ܼ��� ? ������ �°� ���ڰ����� �־��ִ� �͸� �����ָ� �ȴ�
		return jdbcTemplate.update(sql, book.getTitle(), book.getWriter(), book.getPublisher(), book.getPrice());
	}
}