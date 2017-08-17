package com.yongsheng.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import yongsheng.com.entity.UserEntity;

public interface UserDao {
  public void onSave(Connection connection,UserEntity user) throws SQLException;
  public void update(Connection connection,int id,UserEntity user) throws SQLException;
  public void delete(Connection connection,UserEntity user) throws SQLException;
  public ResultSet find(Connection connection,UserEntity user) throws SQLException; 
}
