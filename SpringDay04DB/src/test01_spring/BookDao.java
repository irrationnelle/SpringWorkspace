package test01_spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import test01_spring.vo.BookVO;

@Component
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// �⺻ ������ �ݵ�� ����� �־�� ��
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
	
	
	class BookMapper implements RowMapper<BookVO> {
		
		@Override
		public BookVO mapRow(ResultSet rs, int arg1) throws SQLException {
			BookVO book = new BookVO();
//			book.setBookNum(rs.getInt(1));
//			book.setTitle(rs.getString(2));
//			book.setWriter(rs.getString(3));
//			book.setPrice(rs.getInt(4));
//			book.setPublisher(rs.getString(5));
			
			// ��ó�� �� �ϰ� DBMS�� �÷������� ���ڸ� �������ִ� �� ���� ����
			book.setBookNum(rs.getInt("book_num"));
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setTitle(rs.getString("title"));
			book.setWriter(rs.getString("writer"));
			return null;
		}
		
	}
}