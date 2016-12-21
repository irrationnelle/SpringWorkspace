package vo;

import java.util.List;

public class BookListVO {
	private int startPage;
	private int endPage;
	private int totalPage;
	private int currentPage;
	private List<BookVO> list;
	
	public BookListVO() {	}

	public BookListVO(int startPage, int endPage, int totalPage, int currentPage, List<BookVO> list) {
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<BookVO> getList() {
		return list;
	}

	public void setList(List<BookVO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BookListVO [startPage=" + startPage + ", endPage=" + endPage + ", totalPage=" + totalPage
				+ ", currentPage=" + currentPage + ", list=" + list + "]";
	}
}
