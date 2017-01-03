package mapper;

import vo.MemberVO;

public interface MemberMapper {
	public int insert(MemberVO member);
	public int update(MemberVO member);
	public int delete(int memberNum);
	public int select(int memberNum);
}
