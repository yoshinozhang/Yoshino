package com.zsc.jdb;

import java.sql.*;

public class test {

    public static void main(String[] args) throws SQLException {
        jdbcServiceInterface jdbc = new jdbcService();
        Student student = new Student();
        //HttpServlet
        jdbc.insert(student);
    }

}
