package com.apartment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Tenant {
	private Connection con;
	String url="jdbc:mysql://localhost:3306/travels";
	String user="root";
	String pass="";	
	Scanner sc=new Scanner(System.in);
	
	public Tenant() {
		try {		con=DriverManager.getConnection(url,user,pass);	}
		catch(SQLException e) {	System.out.println("Error : "+e);	}
	}
	public int insert(String num,String name,String block,int room,String time,String date) {
		int n=0;
		try {
			String q="insert into tenant (Car_number,Tenant_Name,Block,Room_No,In_time,In_Date) values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, num);
			pst.setString(2, name);
			pst.setString(3, block);
			pst.setInt(4, room);
			pst.setString(5, time);
			pst.setString(6, date);
			n=pst.executeUpdate();
		}
		catch(Exception e) {	System.out.println("Error : "+e);	}
		return n;
	}
	
	//View Entry Number
	public void entryno(String num) {
		try {
			String q="select Entry_No from tenant where Car_Number=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, num);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("Entry_No");
				System.out.println("Your Entry_No is "+id+"\n");
			}
			
		}catch(Exception e) {	System.out.println("Error : "+e);	}
		
	}
	//Update out time code
		public int updateout(int id,String otime, String odate) {
			int n=0;
			try {
				String q="update regular set Out_time=?, Out_Date=? where Entry_No=?";
				PreparedStatement pst=con.prepareStatement(q);
				pst.setString(1, otime);
				pst.setString(2, odate);
				pst.setInt(3, id);
				n=pst.executeUpdate();
				
			}
			catch(Exception e) {	System.out.println("Error : "+e);	}
			return n;
			
		}
		
		//Update in time code
				public int updatein(int id,String itime, String idate) {
					int n=0;
					try {
						String q="update regular set In_time=?, In_Date=? where Entry_No=?";
						PreparedStatement pst=con.prepareStatement(q);
						pst.setInt(3, id);
						pst.setString(1, itime);
						pst.setString(2, idate);
						n=pst.executeUpdate();
						
					}
					catch(Exception e) {	System.out.println("Error : "+e);	}
					return n;
					
				}

}
