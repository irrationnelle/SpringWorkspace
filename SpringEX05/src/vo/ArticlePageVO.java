package vo;

import java.util.List;

public class ArticlePageVO {
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	private List<ArticleVO> articleList;
	
	public ArticlePageVO() {	}

	public ArticlePageVO(int startPage, int endPage, int currentPage, int totalPage, List<ArticleVO> articleList) {
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.articleList = articleList;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<ArticleVO> getArticleList() {
		return articleList;
	}

	public void setArticleList(List<ArticleVO> articleList) {
		this.articleList = articleList;
	}

	@Override
	public String toString() {
		return "ArticlePageVO [startPage=" + startPage + ", endPage=" + endPage + ", currentPage=" + currentPage
				+ ", totalPage=" + totalPage + ", articleList=" + articleList + "]";
	}
}
