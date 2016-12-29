package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDAO;
import vo.Member;

@Component
public class MemberService {
	@Autowired
	private MemberDAO dao;
	
	public void memberFunc() throws Exception {
		Member member1 = new Member("rase", "1234", "isenfenriz@naver.com", "01012345678");
		Member member2 = new Member("verenis", "4321", "isenfenriz@naver.com", "01087654321");
		
		dao.insert(member1);
		
		if(true) {
			throw new Exception("의도적 예외");
		}
		
		dao.insert(member2);
	}
}
