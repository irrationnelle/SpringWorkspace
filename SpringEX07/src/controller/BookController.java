package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.BookService;
import vo.BookListVO;
import vo.BookVO;

@Controller
public class BookController {
	@Autowired
	private BookService svc;
	
	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/bookAddForm.do")
	public String bookAddForm() {
		return "book_add_form";
	}
	
	@RequestMapping(value="/bookAdd.do", method=RequestMethod.POST)
	public ModelAndView bookAdd(BookVO book) {
		int result = -2;
		result = svc.add(book);
		ModelAndView mv = new ModelAndView();
		if(result == 1) {
			mv.setViewName("main.do");
		} else {
			mv.setViewName("add_fail");
		}
		return mv;
	}
	
	public ModelAndView bookList(int currentPage) {
		BookListVO list = svc.makeList(currentPage);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("book_list");
		mv.addObject("bookList", list);
		return mv;
	}
	
}
