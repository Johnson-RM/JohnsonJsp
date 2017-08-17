package com.yongsheng.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import yongsheng.com.entity.UserEntity;

public class UserImpl implements UserDao{

	@Override
	public void onSave(Connection connection, UserEntity user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pStatement=(PreparedStatement) connection.
				prepareCall("insert into tbl_user(name,password,email) values(?,?,?)");
		pStatement.setString(1, user.getName());
		pStatement.setString(2, user.getPassword());
		pStatement.setString(3, user.getEmail());
		pStatement.execute();
		pStatement.close();
	}

	@Override
	public void update(Connection connection,int i, UserEntity user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pStatement=(PreparedStatement) connection.
				prepareCall("update tbl_user set name=?,password= ?,email=? where id=?");
		pStatement.setString(1, user.getName());
		pStatement.setString(2, user.getPassword());
		pStatement.setString(3, user.getEmail());
		pStatement.setInt(4, i);
		pStatement.execute();	
		pStatement.close();
	}

	@Override
	public void delete(Connection connection, UserEntity user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pStatement=(PreparedStatement) connection.
		prepareCall("delete from tbl_user where id= ?");
		pStatement.setInt(1, user.getId());
		pStatement.execute();
		pStatement.close();
	}

	@Override
	public ResultSet find(Connection connection, UserEntity user) throws SQLException {
		PreparedStatement pStatement=(PreparedStatement) connection.
				prepareCall("select* from tbl_user where name=? and password=?");
		pStatement.setString(1,user.getName());
		pStatement.setString(2,user.getPassword());
		return pStatement.executeQuery();
	}
    
	
		
	
  
}
