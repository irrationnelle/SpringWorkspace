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
	
	
	// SQL������ ?���� ���� �Ϳ� ����ǥ�� �޾���.
	// i.e. VO ��ü�� '������Ƽ' �̸��� �����ش�. (setters�� getters�� ������ ����. ����ʵ���� �������)
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