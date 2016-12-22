package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "login_form";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	// HttpSession 객체가 사용하고 싶다면 매개 변수에 설정하는 것으로 HttpSession 객체를 준다.
	public String login(HttpSession session, String id, String pw) {
		if(memberService.loginCheck(id, pw)) {
			session.setAttribute("loginID", id);
			return "login_success";
		} else {
			return "login_error";
		}
	}
	
	@RequestMapping ("/loginStatus.do")
	public String loginStatus() {
		return "login_status";
	}
	
	@RequestMapping ("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}
