package com.zsc.jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class jdbcService implements jdbcServiceInterface {

  //mysql驱动包名
  private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
  //数据库连接地址
  private static final String URL = "jdbc:mysql://localhost:3306/study";
  //用户名
  private static final String USER_NAME = "root";
  //密码
  private static final String PASSWORD = "root";

  private Connection connection = null;

  jdbcService() {
    try {
      Class.forName(DRIVER_NAME);
      connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }


  public int insert(Student student) {

    try {
      String sql = "INSERT INTO student VALUES ('"
          + student.getId()
          + "','"
          + student.getName()
          + "','"
          + student.getSex()
          + "','"
          + student.getAge()
          + "')";
      PreparedStatement prst = connection.prepareStatement(sql);
      int rs = prst.executeUpdate();
      prst.close();
      return rs;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return 0;
  }

  public String select(String name) {
    try {
      String sql = "SELECT * from student where name = '" + name + "'";
      //mysql查询语句
      PreparedStatement prst = connection.prepareStatement(sql);
      //结果集
      ResultSet rs = prst.executeQuery();
      rs.next();
      String resultName = rs.getString("name");
      prst.close();
      return resultName;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
}
