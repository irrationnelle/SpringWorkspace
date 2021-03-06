package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	public void setService(MemberService service) {
		this.service = service;
	}
///////////////////////////////////////////////////////
	@RequestMapping("/joinForm.do")
	public String joinForm(){
		return "join_form";
	}
	
	@RequestMapping
		(value="/join.do", method=RequestMethod.POST)
	public ModelAndView join(Member member){
		ModelAndView mv = new ModelAndView();
		if(service.join(member)){
			mv.setViewName("join_success");
			mv.addObject("joinMemberInfo", member);
		}else{
			mv.setViewName("join_error");
		}
		return mv;
	}
}




