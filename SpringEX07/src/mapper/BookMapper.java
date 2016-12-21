package mapper;

import java.util.List;
import java.util.Map;

import vo.BookVO;

public interface BookMapper {
	public int insert (BookVO book);
	public int update (BookVO book);
	public int delete (int bookNum);
	public BookVO select (int bookNum);
	public List<BookVO> selectList (Map<String, Integer> map);
	public int selectCount();
}
