package repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import mapper.MemberMapper;
import vo.MemberVO;

@Component
public class MemberDAO {
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int insert(MemberVO member) {
		int result = 0;
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return result = mapper.insert(member);
	}
	
	public int update(MemberVO member) {
		int result = 0;
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		return result = mapper.update(member);
	}
	
	
	
}
