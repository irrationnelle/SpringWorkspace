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
	
	// 기본 생성자 반드시 만들어 주어야 함
	public BookDao(){}
	
	// 외부에서 jdbcTemplate를 주입받기 위해 생성자나 setters를 만들어줘야 함.
	// 기본생성자가 아니기 때문에 applicationContext에서 따로 주입하기 위한 설정 필요
	public BookDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	// 커넥션을 만들지 않기 때문에 try-catch문이 필요없음
	// 또한 PreparedStatement를 사용하여 각각의 ? 들을 채우는 작업 또한 필요없음
	public int insert(BookVO book) {
		String sql = "insert into book(title, writer, publisher, price)" +
					 "values(?, ?, ?, ?)";
		
		// String인지 int인지 자료형을 맞춰줄 필요도 없고 단순히 ? 순서에 맞게 인자값들을 넣어주는 것만 지켜주면 된다
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
			
			// 위처럼 안 하고 DBMS의 컬럼명으로 인자를 전달해주는 것 또한 가능
			book.setBookNum(rs.getInt("book_num"));
			book.setPrice(rs.getInt("price"));
			book.setPublisher(rs.getString("publisher"));
			book.setTitle(rs.getString("title"));
			book.setWriter(rs.getString("writer"));
			return null;
		}
		
	}
}