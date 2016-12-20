package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		// 컨트롤러 메소드의 반환형이 String인 경우에는
		// 반환값이 view의 이름이 됨.
		// 지금은 login_form.jsp 파일이 선택될 것임.
		return "login_form";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	// JSP 페이지에서 보내는 parameter와 매개변수의 이름이 동일하지 않은 경우
	// @RequestParam(value="userId") 라고 해당 매개변수 앞에 어노테이션을 삽입할 수 있다.
	// @RequestParam(value="userId", defaultValue="noname") 
	// JSP로부터 값을 받아오지 못할 때 null값 대신 noname이 들어간다.
	// 기존 JSP에서 getParameter로 값을 받아오던 것은 항상 String으로 받았기에 Integer형으로 파싱해주어야 했지만
	// Spring에서는 매개변수에서 int 값으로 받으면 int형으로 자동으로 형변환되서 들어온다.
	public ModelAndView login
					(String userId, String userPw){
		ModelAndView mv = new ModelAndView();
		
		if(userId.equals(userPw)){
			mv.setViewName("login_success");
			
			mv.addObject("msg","로그인 성공입니다!!");
			mv.addObject("loginId", userId);
		}else{
			mv.setViewName("login_error");
		}
		return mv;		
	}
}






