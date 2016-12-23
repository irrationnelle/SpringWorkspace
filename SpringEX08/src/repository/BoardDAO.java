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
	
	List<ArticleVO> selectList(int startRow, int endRow) {
		Map<String, Integer> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		List<ArticleVO> list = mapper.selectList(map);
		return list;
	}
}
