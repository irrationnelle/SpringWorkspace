package vo;

public class Book {
	// 일부러 테이블 컬럼명과 동일한 프로퍼티 이름을 설정.
	private int book_num;
	private String title;
	private String publisher;
	private String writer;
	private int price;
	
	public Book() {	}

	public Book(int book_num, String title, String publisher, String writer, int price) {
		this.book_num = book_num;
		this.title = title;
		this.publisher = publisher;
		this.writer = writer;
		this.price = price;
	}

	public int getBook_num() {
		return book_num;
	}

	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [book_num=" + book_num + ", title=" + title + ", publisher=" + publisher + ", writer=" + writer
				+ ", price=" + price + "]";
	}
}
