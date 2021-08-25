package com.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao 
{
	public static boolean insertStudent(Student st)
	{
		boolean f=false;
		try
		{
			Connection con=ConnectionProvider.createC();
			String q="insert into student (sName,sPhone,sCity) values(?,?,?)";
			
			//prepared Statement
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the values o parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f=true;
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return f;
	}

	public static boolean deleteStudent(int userId) 
	{
		boolean f=false;
		try
		{
			Connection con=ConnectionProvider.createC();
			String q="delete from student where sId=?";
			
			//prepared Statement
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the values o parameter
			pstmt.setInt(1, userId);
						
			//execute
			pstmt.executeUpdate();
			f=true;
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return f;
		
	}

	public static void listOfStudent() {
		
		
		try
		{
			Connection con=ConnectionProvider.createC();
			String q="select * from student";
			
			//prepared Statement
            Statement stmt=	con.createStatement();	
                       
			//execute
			ResultSet rst=stmt.executeQuery(q);
			
			while(rst.next())
			{
				int id=rst.getInt(1);
				String name=rst.getString(2);
				String phone=rst.getString(3);
				String city=rst.getString(4);
				
				System.out.println("Student Id : " +id);
				System.out.println("Student Name : " +name);
				System.out.println("Student Phone : " +phone);
				System.out.println("Student City : " +city);
				
				System.out.println("----------------------------------");
			}
			
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
	}

	public static boolean updateStudent(Student st) 
	{
		boolean f=false;
		try
		{
			Connection con=ConnectionProvider.createC();
			String q="update student set sName=? ,sPhone=? ,sCity=? where sId=?";
			
			//prepared Statement
			PreparedStatement pstmt=con.prepareStatement(q);
			
			//set the values o parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, st.getStudentId());
			
			//execute
			pstmt.executeUpdate();
			f=true;
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return f;
	}

}
