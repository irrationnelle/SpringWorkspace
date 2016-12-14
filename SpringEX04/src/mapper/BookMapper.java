package mapper;

import java.util.List;

import vo.BookVO;

public interface BookMapper {
	public int insert (BookVO book);
	public int update (BookVO book);
	public int delete (int bookNum);
	public BookVO select (int bookNum);
	public List<BookVO> selectList ();
}
