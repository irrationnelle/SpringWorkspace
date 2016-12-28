package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.FileDAO;
import vo.MyFile;

@Component
public class FileService {
	@Autowired
	private FileDAO fileDao;

	public void setFileDao(FileDAO fileDao) {
		this.fileDao = fileDao;
	}
	
	public int add(MyFile myFile) {
		int result = -1;
		return result = fileDao.insert(myFile);
	}
	
	public int delete(int fileNum){
		int result = -1;
		return result = fileDao.delete(fileNum);
	}
	
	public MyFile download(int fileNum) {
		MyFile myFile = fileDao.select(fileNum);
		return myFile;
	}
	
	public List<MyFile> showFileList() {
		List<MyFile> fileList = fileDao.selectList();
		return fileList;
	}
	
}
