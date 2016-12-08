package test02_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductDao {
	public static final String DB_NAME = "org.mariadb.jdbc.Driver";
	public static final String DB_URL = "jdbc:mariadb://localhost:3306/spring";
	public static final String DB_ID = "root";
	public static final String DB_PW = "sds902";
	
	private Connection con;
	
	private static ProductDao instance = new ProductDao();
	public static ProductDao getInstance() { return instance; }
	
	
	private ProductDao() {
		// TODO Auto-generated constructor stub
		try {
			// Driver jar 파일 로딩은 생성자에서 1번만 실행.
			Class.forName(DB_NAME);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Error!");
			e.printStackTrace();
		}
	}
	
	public void startTransaction() {
		try {
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);	// 커넥션 생성
			con.setAutoCommit(false);	// 트랜잭션 시작
		} catch (SQLException e) {
			System.out.println("Connection Creation Error!");
			e.printStackTrace();
		}
	}

	public void commitTransaction() {
		try {
			con.commit();
		} catch (SQLException e) {
			System.out.println("Transaction Commit Error!");
			e.printStackTrace();
		}
	}

	public void rollbackTransaction() {
		try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println("Rollback Error!");
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Connection Close Error!");
				e.printStackTrace();
			}
		}
	}

	public int updateProductQuantity(int productNum, int quantity) {
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			String sql = "update product set quantity=quantity-1 " + "where product_num=2";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, productNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateProductQuantity Error!");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int insertSaleRecord(int productNum, Date saleDate, String buyer, int saleCount) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "insert into sale" + "(product_num,sale_date,buyer,sale_count)" + "values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(saleDate);
			
			pstmt.setInt(1, productNum);
			pstmt.setString(2, currentTime);
			pstmt.setString(3, buyer);
			pstmt.setInt(4, saleCount);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertSaleRecord Error!");
			e.printStackTrace();
		}
		return result;
	}
}
