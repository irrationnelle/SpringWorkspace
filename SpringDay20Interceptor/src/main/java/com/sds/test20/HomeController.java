package com.sds.test20;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// 로그 기록
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "login_form";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpSession session, String id, String pw) {
		if (id.equals(pw)) {
			session.setAttribute("loginId", id);
			return "login_success";
		} else {
			session.invalidate();
			return "login_fail";
		}
	}

	@RequestMapping("/boardList.do")
	public String boardList() {
		return "board_list";
	}

	@RequestMapping("/writeForm.do")
	public String writeForm() {
		return "write_form";
	}

	// @RequestMapping("/boardList.do")
	// public String boardList(HttpSession session, HttpServletResponse
	// response) {
	// if(session.getAttribute("loginId") != null) {
	// return "board_list";
	// } else {
	// return "login_form";
	// }
	// }
	//
	// @RequestMapping("/writeForm.do")
	// public String writeForm(HttpSession session, HttpServletResponse
	// response) throws IOException {
	// if(session.getAttribute("loginId") != null) {
	// return "write_form";
	// } else {
	// response.sendRedirect("loginForm.do");
	// return null;
	// }
	// }
}
