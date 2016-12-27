package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import vo.Book;

@Controller
public class FileController {
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm() {
		return "upload_form";
	}
	
	// 매개변수로 받는 Book 객체는 upload_form.jsp에서
	// 동일한 이름의 파라미터로 보내는 값을 받아 자동으로 Book 객체의 프로퍼티에 저장한다.
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public void upload(Book book) {
	}
}
