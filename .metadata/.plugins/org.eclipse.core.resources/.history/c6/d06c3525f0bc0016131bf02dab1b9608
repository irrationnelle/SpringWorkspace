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
}