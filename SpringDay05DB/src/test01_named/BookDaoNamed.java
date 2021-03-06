package test01_named;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import test01_named.vo.BookVO;

public class BookDaoNamed {
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	// SQL문에서 ?값에 들어가는 것에 꼬리표를 달아줌.
	// i.e. VO 객체의 '프로퍼티' 이름을 적어준다. (setters와 getters에 영향을 받음. 멤버필드명은 상관없음)
	public int insert(BookVO book) {
		String sql = "INSERT INTO book (book_num, title, price, publisher, writer) VALUES(:bookNum, :title, :price, :publisher, :writer)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(book);
		
		return jdbcTemplate.update(sql, param);
	}
	
	public int delete(int bookNum) {
		String sql = "delete from book where book_num=:bn";
		Map<String, Integer> paramMap = new HashMap<>();
		paramMap.put("bn", bookNum);
		return jdbcTemplate.update(sql, paramMap);
	}
	
}
