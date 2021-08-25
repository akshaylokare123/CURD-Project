package com.student;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider
{
	static Connection con;
		
	public static Connection createC()
	{
		try 
		{
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection..
			String url="jdbc:mysql://localhost:3306/curd";
			String user="root";
			String password="Akshay@123";
			con=DriverManager.getConnection(url,user,password);
			
			
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}


}
