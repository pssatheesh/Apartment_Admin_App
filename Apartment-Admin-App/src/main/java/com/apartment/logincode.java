package com.apartment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class logincode {
	private Connection con;
	String url="jdbc:mysql://localhost:3306/travels";
	String user="root";
	String pass="";	
	Scanner sc=new Scanner(System.in);
	public logincode() {
		try {		con=DriverManager.getConnection(url,user,pass);	}
		catch(SQLException e) {	System.out.println("Error : "+e);	}		
	}
	 
	//login code
	public boolean adlog(String user, String pass) {
		boolean res=false;
		try {
			String q="select * from admin where username=? and password=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				res=true;
			}
		}
		catch(Exception e) {	System.out.println("Error : "+e);	}
		return res;
	}

}
