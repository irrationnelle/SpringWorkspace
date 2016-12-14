package repository;

import java.util.List;

import org.apache.ibatis.ognl.MapPropertyAccessor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BookMapper;
import vo.BookVO;

@Component
public class BookDAO {
	@Autowired
	SqlSessionTemplate session;

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int insert (BookVO book) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.insert(book);
	}
	
	public int update (BookVO book) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.update(book);
	}
	
	public int delete (int bookNum) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.delete(bookNum);
	}
	
	public BookVO select (int bookNum) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.select(bookNum);
	}
	
	public List<BookVO> selectList () {
		BookMapper mapper = session.getMapper(BookMapper.class);
		return mapper.selectList();
	}
}
