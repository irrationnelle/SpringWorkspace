package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.MemberDAO;
import vo.MemberVO;

@Component
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public boolean loginCheck(String id, String password) {
		MemberVO member = memberDAO.select(id);
		
		if(member == null || !member.getPassword().equals(password)) {
			return false;
		} else {
			return true;
		}
	}
	
}
