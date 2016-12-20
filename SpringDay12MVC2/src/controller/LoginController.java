package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/loginForm.do")
	public String loginForm(){
		// ��Ʈ�ѷ� �޼ҵ��� ��ȯ���� String�� ��쿡��
		// ��ȯ���� view�� �̸��� ��.
		// ������ login_form.jsp ������ ���õ� ����.
		return "login_form";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	// JSP ���������� ������ parameter�� �Ű������� �̸��� �������� ���� ���
	// @RequestParam(value="userId") ��� �ش� �Ű����� �տ� ������̼��� ������ �� �ִ�.
	// @RequestParam(value="userId", defaultValue="noname") 
	// JSP�κ��� ���� �޾ƿ��� ���� �� null�� ��� noname�� ����.
	// ���� JSP���� getParameter�� ���� �޾ƿ��� ���� �׻� String���� �޾ұ⿡ Integer������ �Ľ����־�� ������
	// Spring������ �Ű��������� int ������ ������ int������ �ڵ����� ����ȯ�Ǽ� ���´�.
	public ModelAndView login
					(String userId, String userPw){
		ModelAndView mv = new ModelAndView();
		
		if(userId.equals(userPw)){
			mv.setViewName("login_success");
			
			mv.addObject("msg","�α��� �����Դϴ�!!");
			mv.addObject("loginId", userId);
		}else{
			mv.setViewName("login_error");
		}
		return mv;		
	}
}






