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
	
	// �Ű������� �޴� Book ��ü�� upload_form.jsp����
	// ������ �̸��� �Ķ���ͷ� ������ ���� �޾� �ڵ����� Book ��ü�� ������Ƽ�� �����Ѵ�.
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(Book book) {
		// ����ڰ� ��� ȭ���� ���� ���� ModelAndView ��ü(���� ���ε�� ū �������� �ִ� ���� �ƴ�!)
		ModelAndView mv = new ModelAndView("upload_result");
		
		// osX������ ���� ��� �Է� ����� �ٸ�
		// ���� ����Ʈ: http://stackoverflow.com/questions/5972026/path-to-file-on-a-mac-filenotfoundexception 
		String savePath = "c:/upload/";
		
		// java.io�� import �ؿ� ��
		File dir = new File(savePath);
		
		if(dir.exists() == false) {
			// ���� ������ ������ ������ ����
			dir.mkdir();
		}
		
		// ���� ���󼭴� ����ڰ� ���ε��� ���� ���� �̸���
		// ������ ����Ǵ� ���� �̸��� �޶��� �� ����(���� �ٸ� ����ڰ� ���� �̸��� ������ �ø� �� �����ϱ�) 
		String savedName = savePath + "/" + book.getMyFile().getOriginalFilename() + new Random().nextInt(1000000);
		
		// ����ִ� ������ savedFile (���� ���빰�� ä������ ����)
		File savedFile = new File(savedName);
		
		try {
			// ������� ������ ���� �ٷ� ������ ���� ����ִ� savedFile�� ���빰�� ä��
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
			// �ٿ�ε� ���� ���� �о���̴� Stream
			// ���������� osX������ ��ΰ� �ٸ�.
			// ���� �̸��� ���� �� �ٸ��� ����Ǿ� �����Ƿ� ���� ��ο� ���� ���� �̸��� ã�� �Է��� ��!!!!
			FileInputStream is = new FileInputStream("c:/upload/octocat.jpg842875");

			// �о���� ������ ���� response�� stream
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

		// �������� ������ �ޱ� ���� for��!
		// movie.getMyFile()�� ����Ʈ
		for(MultipartFile f: movie.getMyFile()) {
			// �ݺ��� ���ο��� ���ο� ���� �̸��� �����Ͽ� ��� �����ϰ� transfer�� �����ش�.
			String savedName = savePath + "/" + f.getOriginalFilename() + new Random().nextInt(1000000);
			File savedFile = new File(savedName);
			
			try {
				f.transferTo(savedFile);
				// ����ڰ� ���� ���ε� ��� Ȯ���ϱ� ���� �ܼ� �޼���
				// �������� ������ ���ε� �Ǳ� ������ ModelAndView�� ���� ���ε� ����� ����ϱⰡ �����
				System.out.println("���� �̸�: "+f.getOriginalFilename());
				System.out.println("����� �̸�: " + savedName);
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
	
	
	// ���ε�� ������ ���� ������Ʈ ���� ������
	// �����ϰ� ������ ���� �����θ� �Ʒ��� ���� �ϸ� �ȴ�.
	/*
	public ModelAndView uploadMovie(HttpServletRequest request, Movie movie) {
		// ���ÿ��� "img"��� �� �ִ� �Ű����� ��ġ���� �ڽ��� ���� �����̸��� ������ �ȴ�.
		String savePath = request.getServletContext().getRealPath("img");
	}
	*/
}
