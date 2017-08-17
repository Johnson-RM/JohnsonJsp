package yongsheng.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

public class JDBCTest {
	public static void main(String[] args) {
	Connection connection=connect();
	try {
		connection.setAutoCommit(false);
		insert_user(connection);
		insert_address(connection);
		connection.commit();
		System.out.println("==========提交成功==========");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("==========提交失败===========");
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
    public static void insert_user(Connection connection) throws SQLException {
    	String sql="insert into tbl_user values (4,'Jim','123456','Jim@gmail.com')";
    	Statement statement=null;
    	int resultSet=0;
    	statement=connection.createStatement();
		resultSet=statement.executeUpdate(sql);
		System.out.println("insert "+resultSet+" row into tbl_user");
		statement.close();
     }
    public static void insert_address(Connection connection) throws SQLException {
    	String sql="insert into tbl_address values (4,'shantou','china',3)";
    	Statement statement=null;
    	int resultSet=0;
    	statement=connection.createStatement();
		resultSet=statement.executeUpdate(sql);
		System.out.println("insert "+resultSet+" row into tbl_address");
    	statement.close();
    }
	public static Connection connect() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","12345");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		}
	

}
