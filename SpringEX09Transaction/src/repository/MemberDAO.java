package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.MemberMapper;
import vo.Member;

@Component
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int insert(Member member) {
		int result = 0;
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return result = mapper.insert(member);
	}
}
