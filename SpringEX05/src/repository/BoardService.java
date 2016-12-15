package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vo.ArticlePageVO;
import vo.ArticleVO;

@Component
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public int write(ArticleVO article) {
		int result = -1;
		return result = dao.insert(article);
	}
	
	public int edit(ArticleVO article) {
		int result = -1;
		return result = dao.update(article);
	}
	
	public int delete(int num) {
		int result = -1;
		return result = dao.delete(num);
	}
	
	public ArticleVO read(int num) {
		ArticleVO article = dao.select(num);
		return article;
	}

	public ArticlePageVO makePage(int currentPage) {
		final int COUNT_PER_PAGE = 3;
		int totalPage = dao.selectCount()/COUNT_PER_PAGE;
		if(dao.selectCount()%COUNT_PER_PAGE != 0)
			totalPage++;
		
		int startPage = currentPage/3*3 + 1;
		int endPage = startPage + 2;
		if(endPage >= totalPage)
			endPage = totalPage;
		
		int startRow = (currentPage-1)*COUNT_PER_PAGE;
		int endRow = startRow + (COUNT_PER_PAGE);
		
		List<ArticleVO> list = dao.selectList(startRow, endRow);
		
		ArticlePageVO articlePage = new ArticlePageVO(startPage, endPage, currentPage, totalPage, list);
		return articlePage;
	}
}
