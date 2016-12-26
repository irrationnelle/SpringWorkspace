package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.BoardDAO;
import vo.ArticlePageVO;
import vo.ArticleVO;

@Component
public class BoardService {
	@Autowired
	private BoardDAO boardDao;
	
	public ArticlePageVO makePage(int currentPage) {
		final int COUNT_PER_PAGE = 5;
		
		int totalPage = boardDao.selectCount()/COUNT_PER_PAGE;
		if(boardDao.selectCount()%COUNT_PER_PAGE != 0)
			totalPage++;
		
		int startPage = currentPage/COUNT_PER_PAGE*COUNT_PER_PAGE+1;
		int endPage = startPage + 4;
		if(endPage >= totalPage)
			endPage = totalPage;
		
		int startRow = (currentPage-1)*COUNT_PER_PAGE;
		int endRow = startRow + COUNT_PER_PAGE;
		
		List<ArticleVO> list = boardDao.selectList(startRow, endRow);
		
		ArticlePageVO articlePage = new ArticlePageVO(startPage, endPage, currentPage, totalPage, list);
		return articlePage;
	}
	
	public int write(ArticleVO article) {
		int result = -1;
		return result = boardDao.insert(article);
	}
	
	public int modify(ArticleVO article) {
		int result = -1;
		return result = boardDao.update(article);
	}
	
	public int delete(int articleNum) {
		int result = -1;
		return result = boardDao.delete(articleNum);
	}
	
	public ArticleVO read (int articleNum) {
		int result = -1;
		result = boardDao.update(articleNum);
		ArticleVO article = boardDao.select(articleNum);
		return article;
	}
}
