package com.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Guest {
	private Connection con;
	String url="jdbc:mysql://localhost:3306/travels";
	String user="root";
	String pass="";	
	Scanner sc=new Scanner(System.in);
	
	//Connection Establishment
	public Guest() {
		try {		con=DriverManager.getConnection(url,user,pass);	}
		catch(SQLException e) {	System.out.println("Error : "+e);	}		
	}
	//Insertion
	public int insert(String num,String name,String block,int room,String time,String date) {
		int n=0;
		try {
			String q="insert into guestdetails (Car_number,Guest_Name,Block,Room_No,In_time,In_Date) values(?,?,?,?,?,?)";
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
	
	//Updation code
	public int update(String Cnum,String otime, String odate) {
		int n=0;
		try {
			String q="update guestdetails set Out_time=?, Out_Date=? where Car_Number=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(3, Cnum);
			pst.setString(1, otime);
			pst.setString(2, odate);
			n=pst.executeUpdate();
			
		}
		catch(Exception e) {	System.out.println("Error : "+e);	}
		return n;
		
	}
	//Selection code
	
	public void select() {
	try {
		String q="select * from guestdetails";
		PreparedStatement pst=con.prepareStatement(q);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getInt("Entry_No")+"\t"+rs.getString("Car_Number")+"\t");
			System.out.print(rs.getString("Guest_name")+"\t"+rs.getString("Block")+"\t");
			System.out.print(rs.getInt("Room_No")+"\t"+rs.getString("In_time")+"\t");
			System.out.print(rs.getDate("In_Date")+"\t"+rs.getString("Out_time")+"\t");
			System.out.println(rs.getDate("Out_Date"));
			}
		}catch(Exception e) {	System.out.println("Error : "+e);	}
	}
	
	//View Entry Number
	public void entryno(String num) {
		try {
			String q="select Entry_No from guestdetails where Car_Number=?";
			PreparedStatement pst=con.prepareStatement(q);
			pst.setString(1, num);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("Entry_No");
				System.out.println("Your Entry_No is "+id+"\n");
			}
			
		}catch(Exception e) {	System.out.println("Error : "+e);	}
		
	}
		
	}

