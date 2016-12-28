package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import repository.FileDao;

@Controller
public class FileController {
	@Autowired
	private FileDao fileDao;

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	@RequestMapping("/fileList.do")
	 public ModelAndView fileList() {
		ModelAndView mv = new ModelAndView("file_list");
		mv.addObject("fileList", fileDao.selectAllFile());
		return mv;
	}
}
