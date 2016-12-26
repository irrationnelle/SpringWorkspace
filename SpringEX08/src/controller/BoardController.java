package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;
import vo.ArticleVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/board.do")
	public String board() {
		return "board_list";
	}
	
	@RequestMapping("/writeForm.do")
	public String writeForm() {
		return "write_form";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public ModelAndView write(ArticleVO article) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("write");
		mv.addObject("article", article);
		return mv;
	}
	
	@RequestMapping("/modifyForm.do")
	public String modifyForm() {
		return "modify_form";
	}
	
	public ModelAndView modify(ArticleVO article) {
		
	}
}
