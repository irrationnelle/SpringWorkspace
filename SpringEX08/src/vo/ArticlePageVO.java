package vo;

import java.util.List;

public class ArticlePageVO {
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	private List<ArticleVO> list;
	
	public ArticlePageVO() {	}

	public ArticlePageVO(int startPage, int endPage, int currentPage, int totalPage, List<ArticleVO> list) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.list = list;
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

	public List<ArticleVO> getList() {
		return list;
	}

	public void setList(List<ArticleVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ArticlePageVO [startPage=" + startPage + ", endPage=" + endPage + ", currentPage=" + currentPage
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
}
