package com.start;

import java.util.Scanner;

import com.student.Student;
import com.student.StudentDao;

public class Start 
{
	public static void main(String[] args) {
		
		System.out.println("Welcome to Student App");
		
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("PRESS 1 TO ADD");
			System.out.println("PRESS 2 TO UPDATE");
			System.out.println("PRESS 3 TO DELETE");
			System.out.println("PRESS 4 TO DISPLAY");
			System.out.println("PRESS 5 TO EXIT APP");

            int c=sc.nextInt();
            
            if(c==1)
            {
            	//add student..
            	System.out.println("Enter User Name : ");
            	String name=sc.next();
            	
            	System.out.println("Enter User Phone : ");
            	String phone=sc.next();
            	
            	System.out.println("Enter User City : ");
            	String city=sc.next();
            	
            	//create student object to store student
            	Student st=new Student(name,phone,city);
            	boolean answer=StudentDao.insertStudent(st);
            	
            	if(answer)
            	{
            		System.out.println("Student is Added Succeffully ...");
            	}
            	else
            	{
            		System.out.println("Something went wrong..");
            	}
            }
            else if(c==2)
            {
            	//update student..
            	//add student..
            	System.out.println("Enter New User Name : ");
            	String name=sc.next();
            	
            	System.out.println("Enter New User Phone : ");
            	String phone=sc.next();
            	
            	System.out.println("Enter New User City : ");
            	String city=sc.next();
            	
            	System.out.println("Enter User id to update : ");
            	int id=Integer.parseInt(sc.next());
            	
            	
            	//create student object to store student
            	Student st=new Student(id,name,phone,city);
            	boolean answer=StudentDao.updateStudent(st);
            	
            	if(answer)
            	{
            		System.out.println("Student is Updated Succeffully ...");
            	}
            	else
            	{
            		System.out.println("Something went wrong..");
            	}
            	
            }
            else if(c==3)
            {
            	//delete student..
            	System.out.println("Enter student id to Delete : ");
            	int userId=Integer.parseInt(sc.next());
            	boolean f=StudentDao.deleteStudent(userId);
            	
            	if(f)
            	{
            		System.out.println("Deleted : ");
            	}
            	else
            	{
            		System.out.println("Something went wrong...");
            	}
            	
            }
            else if(c==4)
            {
            	//display student..
            	StudentDao.listOfStudent();
            	
            } 
            else if(c>=5)
            {
            	System.out.println("choose correct number..");
               	break;
            }
                        
		}
		System.out.println("...thank you...");
				
	}

}
