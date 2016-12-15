package vo;

import java.sql.Timestamp;

public class ArticleVO {
	private int num;
	private Timestamp date;
	private int count;
	private String name;
	private String password;
	private String content;
	private String title;
	
	public ArticleVO() {	}

	
	
	public ArticleVO(int num, Timestamp date, int count, String name, String password, String content, String title) {
		super();
		this.num = num;
		this.date = date;
		this.count = count;
		this.name = name;
		this.password = password;
		this.content = content;
		this.title = title;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	@Override
	public String toString() {
		return "ArticleVO [num=" + num + ", date=" + date + ", count=" + count + ", name=" + name + ", password="
				+ password + ", content=" + content + "]";
	}
}
