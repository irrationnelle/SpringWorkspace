package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileController {
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm() {
		return "upload_form";
	}
}
