package yongsheng.com;

import java.sql.Connection;
import java.sql.SQLException;

import com.yongsheng.dao.UserImpl;

import yongsheng.com.entity.UserEntity;
import yongsheng.com.util.ConnectionFactory;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	UserImpl userImpl=new UserImpl();
	Connection connection=null;
	connection=ConnectionFactory.getInstance().getConnection();
	try {
    connection.setAutoCommit(false);
	UserEntity userEntity=new UserEntity();
    userEntity.setName("Johnson");
    userEntity.setPassword("12345");
    userEntity.setEmail("Johnson@qq.com");
    userImpl.onSave(connection, userEntity);
    //userImpl.update(connection, 2, userEntity);
    //userImpl.delete(connection,userEntity);
    connection.commit();
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Ìá½»Ê§°Ü£¬»Ø¹ö");
		try {
			connection.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    finally{
    	try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	}

}
