package com.bilgeadam.boost.plainsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.bilgeadam.boost.model.UserEntity;

public class PlainSqlTest {

	public static void main(String[] args) {
		
		 String url= "jdbc:postgresql://localhost:5432/hiber_db"; 
	        Properties props = new Properties();
	        props.setProperty("user", "postgres");
	        props.setProperty("password", "2211223");
	        ArrayList<UserEntity> users = new ArrayList<>();

	        try {
	            //Connection conn = DriverManager.getConnection(url,"postgres","2211223");    1
	            //Connection conn = DriverManager.getConnection(url);        2
	            Connection conn = DriverManager.getConnection(url,props);
	            System.out.println("Connected");

	            Statement stmt = conn.createStatement();
	            String sql = "SELECT*FROM users;";
	            ResultSet rs = stmt.executeQuery(sql);

	            UserEntity user;


	            while(rs.next()) {
	                @SuppressWarnings("unused")
					long id = rs.getLong(1);
	                String email = rs.getString(2);
	                String firstName=rs.getString(3);
	                String lastName=rs.getString(4);
	                user = new UserEntity(firstName,lastName);
	                user.setEmail(email);
	                users.add(user);
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		        for (UserEntity user : users) {
		            System.out.println(user);
		        }
	}
}
