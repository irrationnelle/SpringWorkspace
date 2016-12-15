package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.BoardMapper;
import vo.ArticleVO;

@Component
public class BoardDAO {
	@Autowired
	SqlSessionTemplate session;
	
	public BoardDAO(SqlSessionTemplate session) {
		this.session = session;
	}
	
	public int insert (ArticleVO article) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		result = mapper.insert(article);
		return result;
	}
	
	public int update (ArticleVO article) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		result = mapper.update(article);
		return result;
	}
	
	public int delete (int num) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		result = mapper.delete(num);
		return result;
	}
	
	public int selectCount() {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return result = mapper.selectCount();
	}
	
	public ArticleVO select (int num) {
		ArticleVO article = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return article = mapper.select(num);
	}
	
	public List<ArticleVO> selectList (int startRow, int endRow) {
		List<ArticleVO> list = null;
		Map<String, Integer> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		list = mapper.selectList(map);
		return list;
	}
}
