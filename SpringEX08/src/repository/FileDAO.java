package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.FileMapper;
import vo.MyFile;

@Component
public class FileDAO {
	@Autowired
	private SqlSessionTemplate session;
	
	public int insert(MyFile myFile) {
		int result = 0;
		FileMapper mapper = session.getMapper(FileMapper.class);
		return result = mapper.insert(myFile);
	}
	
	public int delete(int fileNum) {
		int result = 0;
		FileMapper mapper = session.getMapper(FileMapper.class);
		return result = mapper.delete(fileNum);
	}
	
	public MyFile select(int fileNum) {
		MyFile myFile = null;
		FileMapper mapper = session.getMapper(FileMapper.class);
		return myFile = mapper.select(fileNum);
	}
	
	public List<MyFile> selectList() {
		List<MyFile> list = null;
		FileMapper mapper = session.getMapper(FileMapper.class);
		return list = mapper.selectList();
	}
}
