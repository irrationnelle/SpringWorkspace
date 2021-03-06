package mybatis_xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.Book;

public class BookDAO {
	private SqlSessionFactory factory;
	
	public BookDAO() {
		String resource = "mybatis_xml/conf.xml";;
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException ex) {
			System.out.println("MyBatis conf error!");
			ex.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int insert(Book book) {
		SqlSession session = factory.openSession(true);
		return session.insert("rase.insertBook", book);
	}
	
	public Book select(int book_num) {
		SqlSession session = factory.openSession();
		return session.selectOne("rase.selectBook", book_num);
	}
	
	public List<Book> selectList() {
		SqlSession session = factory.openSession();
		return session.selectList("rase.selectBookList");
	}
}
