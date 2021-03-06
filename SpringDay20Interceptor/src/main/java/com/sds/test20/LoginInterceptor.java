package com.sds.test20;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	// preHandle은 controller에 들어가기 전에 뺏어오는 것
	// postHandle은 controller에 들어가서 나올 때 뺏어오는 것
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// controller로 요청이 들어가기 전에 수행하고자 하는 작업
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId != null) {
			return true;
		} else {
			response.sendRedirect("loginForm.do");
			return false;
		}
	}
}
