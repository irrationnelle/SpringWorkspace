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
	private SqlSessionTemplate session;
	
	public int insert(ArticleVO article) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return result = mapper.insert(article);
	}
	
	public int update(ArticleVO article) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return result = mapper.update(article);
	}
	
	public int update(int articleNum) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return result = mapper.updateCount(articleNum);
	}
	
	public int delete(int articleNum) {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return result = mapper.delete(articleNum);
	}
	
	public ArticleVO select(int articleNum) {
		ArticleVO article = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return article = mapper.select(articleNum);
	}
	
	public List<ArticleVO> selectList(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		List<ArticleVO> list = mapper.selectList(map);
		return list;
	}
	
	public int selectCount() {
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		return result = mapper.selectCount();
	}
}
