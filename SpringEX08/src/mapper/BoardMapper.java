package mapper;

import java.util.List;
import java.util.Map;

import vo.ArticleVO;

public interface BoardMapper {
	public int insert(ArticleVO article);
	public int update(ArticleVO article);
	public int delete(int articleNum);
	public ArticleVO select(int articleNum);
	public List<ArticleVO> selectList(Map<String, Integer> map);
	public int selectCount();
	
}
