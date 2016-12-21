package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BookMapper;
import vo.BookVO;

@Component
public class BookDAO {
	@Autowired
	private SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	public int insert (BookVO book) {
		int result = 0;
		BookMapper mapper = session.getMapper(BookMapper.class);
		return result = mapper.insert(book);
	}
	
	public int update (BookVO book) {
		int result = 0;
		BookMapper mapper = session.getMapper(BookMapper.class);
		return result = mapper.update(book);
	}
	
	public int delete (int bookNum) {
		int result = 0;
		BookMapper mapper = session.getMapper(BookMapper.class);
		return result = mapper.delete(bookNum);
	}
	
	public BookVO select (int bookNum) {
		BookVO book = null;
		BookMapper mapper = session.getMapper(BookMapper.class);
		return book = mapper.select(bookNum);
	}
	
	public List<BookVO> selectList (int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		List<BookVO> list = null;
		BookMapper mapper = session.getMapper(BookMapper.class);
		return list = mapper.selectList(map);
	}
	
	public int selectCount () {
		int result = 0;
		BookMapper mapper = session.getMapper(BookMapper.class);
		return result = mapper.selectCount();
	}
	
}
