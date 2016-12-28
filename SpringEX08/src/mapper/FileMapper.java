package mapper;

import java.util.List;

import vo.MyFile;

public interface FileMapper {
	public int insert(MyFile myFile);
	public int delete(int fileNum);
	public MyFile select(int fileNum);
	public List<MyFile> selectList();
}
