package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vo.Book;
import vo.Movie;

@Controller
public class FileController {
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm() {
		return "upload_form";
	}
	
	// 매개변수로 받는 Book 객체는 upload_form.jsp에서
	// 동일한 이름의 파라미터로 보내는 값을 받아 자동으로 Book 객체의 프로퍼티에 저장한다.
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(Book book) {
		// 사용자가 결과 화면을 보기 위한 ModelAndView 객체(파일 업로드와 큰 연관성이 있는 것은 아님!)
		ModelAndView mv = new ModelAndView("upload_result");
		
		// osX에서는 파일 경로 입력 방식이 다름
		// 참조 사이트: http://stackoverflow.com/questions/5972026/path-to-file-on-a-mac-filenotfoundexception 
		String savePath = "c:/upload/";
		
		// java.io를 import 해올 것
		File dir = new File(savePath);
		
		if(dir.exists() == false) {
			// 만약 폴더가 없으면 만들라는 문장
			dir.mkdir();
		}
		
		// 때에 따라서는 사용자가 업로드한 원래 파일 이름과
		// 서버에 저장되는 파일 이름이 달라질 수 있음(각기 다른 사용자가 같은 이름의 파일을 올릴 수 있으니까) 
		String savedName = savePath + "/" + book.getMyFile().getOriginalFilename() + new Random().nextInt(1000000);
		
		// 비어있는 파일인 savedFile (아직 내용물이 채워지지 않음)
		File savedFile = new File(savedName);
		
		try {
			// 사용자의 파일을 통해 바로 위에서 만든 비어있는 savedFile에 내용물을 채움
			book.getMyFile().transferTo(savedFile);
			mv.addObject("originalName", book.getMyFile().getOriginalFilename());
			mv.addObject("savedPath", savedName);
			mv.addObject("title", book.getTitle());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response) {
		response.setContentType("application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\"octocattt.jpg\"");
		
		try {
			// 다운로드 해줄 파일 읽어들이는 Stream
			// 마찬가지로 osX에서는 경로가 다름.
			// 파일 이름은 각자 다 다르게 저장되어 있으므로 직접 경로에 들어가서 파일 이름을 찾아 입력할 것!!!!
			FileInputStream is = new FileInputStream("c:/upload/octocat.jpg842875");

			// 읽어들인 파일을 보낼 response의 stream
			ServletOutputStream os = response.getOutputStream();
			
			byte[] buf = new byte[1024];
			int size=0;
			
			while((size = is.read(buf)) != 0) {
				os.write(buf, 0, size);
			}
			
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/uploadFormMovie.do")
	public String uploadFormMovie() {
		return "upload_form_movie";
	}
	
	@RequestMapping(value="/uploadMovie.do", method=RequestMethod.POST)
	public ModelAndView uploadMovie(Movie movie) {
		ModelAndView mv = new ModelAndView("upload_movie_result");

		String savePath = "c:/upload_movie/";

		File dir = new File(savePath);

		if (dir.exists() == false) {
			dir.mkdir();
		}

		// 여러개의 파일을 받기 위한 for문!
		// movie.getMyFile()은 리스트
		for(MultipartFile f: movie.getMyFile()) {
			// 반복문 내부에서 새로운 파일 이름을 생성하여 계속 저장하고 transfer로 보내준다.
			String savedName = savePath + "/" + f.getOriginalFilename() + new Random().nextInt(1000000);
			File savedFile = new File(savedName);
			
			try {
				f.transferTo(savedFile);
				// 사용자가 파일 업로드 결과 확인하기 위한 콘솔 메세지
				// 여러개의 파일이 업로드 되기 때문에 ModelAndView로 파일 업로드 결과를 출력하기가 어려움
				System.out.println("원래 이름: "+f.getOriginalFilename());
				System.out.println("저장된 이름: " + savedName);
				System.out.println("-----------------------");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		mv.addObject("uploadedFileNames", movie.getMyFile());

		return mv;
	}
	
	
	// 업로드된 파일을 현재 프로젝트 내부 폴더에
	// 저장하고 싶으면 파일 저장경로를 아래와 같이 하면 된다.
	/*
	public ModelAndView uploadMovie(HttpServletRequest request, Movie movie) {
		// 예시에서 "img"라고 들어가 있는 매개변수 위치에는 자신이 지은 폴더이름을 넣으면 된다.
		String savePath = request.getServletContext().getRealPath("img");
	}
	*/
}
