package ex01_account;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import ex01_account.vo.AccountVO;

public class AccountDAO {
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int insert(AccountVO account) {
		String sql = "INSERT INTO account (name, amount, password) VALUES (:name, :amount, :password)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(account);
		return jdbcTemplate.update(sql, param);
	}
	
	public int update(AccountVO account) {
		String sql = "UPDATE account SET amount= amount+? WHERE account_num=?";
		
	}
}
