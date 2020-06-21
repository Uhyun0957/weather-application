package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	private static ConnectionManager instance;
	Properties properties;
	String driver;
	String url;
	String user;
	String password;
	
	// 생성자에서 오라클 연결 정보 문서 데이터 가져오기
	private ConnectionManager() {
		properties = new Properties();
		InputStream is = this.getClass().getResourceAsStream("oracleInfo.db");
		try {
			properties.load(is);
			driver = (String)properties.get("oracle_driver");
			url = (String)properties.get("oracle_url");
			user = (String)properties.get("oracle_user");
			password = (String)properties.get("oracle_password");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is!=null) try {is.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	// 커넥션 메니저 instance 반환 메서드
	public static ConnectionManager getInstance() {
		if(instance==null) instance = new ConnectionManager();
		return instance;
	}
	
	// Connection 반환 메서드
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	// --------------------------- closeDB() --------------------------- //
	public void closeDB(Connection con) {
		if(con!=null) {try {con.close();}catch(SQLException e) {e.printStackTrace();}}
	}
	public void closeDB(PreparedStatement pstmt) {
		if(pstmt!=null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
	}
	public void closeDB(Connection con, PreparedStatement pstmt) {
		if(pstmt!=null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		if(con!=null) {try {con.close();}catch(SQLException e) {e.printStackTrace();}}
	}
	public void closeDB(PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {try {rs.close();}catch(SQLException e) {e.printStackTrace();}}
		if(pstmt!=null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
	}
	public void closeDB(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null) {try {rs.close();}catch(SQLException e) {e.printStackTrace();}}
		if(pstmt!=null) {try {pstmt.close();}catch(SQLException e) {e.printStackTrace();}}
		if(con!=null) {try {con.close();}catch(SQLException e) {e.printStackTrace();}}
	}
	
	// --------------------------- closeStream() --------------------------- //
	public void closeStream(FileInputStream fis) {
		if(fis!=null) {try {fis.close();}catch(IOException e) {e.printStackTrace();}}
	}
	public void closeStream(FileOutputStream fos) {
		if(fos!=null) {try {fos.close();}catch(IOException e) {e.printStackTrace();}}
	}
}