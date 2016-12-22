package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.MemberMapper;
import vo.MemberVO;

@Component
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public MemberVO select(String id) {
		MemberVO member = null;
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return member=mapper.select(id);
	}
}	
