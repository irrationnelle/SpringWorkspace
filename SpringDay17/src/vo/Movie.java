package vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Movie {
	private String title;
	// �������� ������ �ޱ� ���� ����Ʈ
	private List<MultipartFile> myFile;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<MultipartFile> getMyFile() {
		return myFile;
	}
	public void setMyFile(List<MultipartFile> myFile) {
		this.myFile = myFile;
	}
}
