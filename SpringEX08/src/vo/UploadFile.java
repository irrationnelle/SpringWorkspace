package vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	private List<MultipartFile> filelist;

	public List<MultipartFile> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<MultipartFile> filelist) {
		this.filelist = filelist;
	}
}
