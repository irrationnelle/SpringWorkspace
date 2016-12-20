package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vo.Member;

@Controller
public class MemberController {
	
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "join_form";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView join(Member member) {
		System.out.println("∞°¿‘: "+member);
		ModelAndView mv = new ModelAndView("join_result");
		mv.addObject("joinMember", member);
		return mv;
	}
}
