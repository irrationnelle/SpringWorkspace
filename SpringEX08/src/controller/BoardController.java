package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;
import vo.ArticlePageVO;
import vo.ArticleVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService svc;
	
	@RequestMapping("/board.do")
	public ModelAndView board(@RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		ModelAndView mv = new ModelAndView();
		ArticlePageVO articlePage = svc.makePage(currentPage);
		mv.setViewName("board_list");
		mv.addObject("articlePage", articlePage);
		return mv;
	}
	
	@RequestMapping("/writeForm.do")
	public String writeForm() {
		return "write_form";
	}
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	@ResponseBody
	public void write(ArticleVO article, HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("board.do");
		svc.write(article);
		try {
			response.sendRedirect("board.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return mv;  
	}
	
	@RequestMapping("/modifyForm.do")
	public String modifyForm() {
		return "modify_form";
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public ModelAndView modify(ArticleVO article) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("modify");
		svc.modify(article);
		return mv;
	}
	
	@RequestMapping("/deleteForm.do")
	public String deleteForm() {
		return "delete_form";
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public ModelAndView delete(int articleNum) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete");
		svc.delete(articleNum);
		return mv;
	}
	
	@RequestMapping("/read.do")
	public ModelAndView read(int articleNum) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("read");
		mv.addObject("article", svc.read(articleNum));
		return mv;
	}
}
