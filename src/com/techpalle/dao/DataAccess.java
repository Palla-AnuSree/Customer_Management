package com.techpalle.dao;

import java.sql.*;

import com.techaplle.module.Customer;

public class DataAccess
{
	private static final String classname="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/Anuj2ee";
	private static final String username="root";
	private static final String pw="admin";
	
	private static Connection con=null;
	private static Statement stm=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	private static final String insertQry="insert into customer(Name,Email,Mobileno,password,State) values(?,?,?,?,?)";
	private static final String validateQry="select email,password from customer where email=? and password=?";
	
	public static void insertCustomer(Customer customer)
	{
		try
		{
			Class.forName(classname);
			con=DriverManager.getConnection(url, username, pw);
			ps=con.prepareStatement(insertQry);
			ps.setString(1,customer.getName());
			ps.setString(2,customer.getEmail());
			ps.setLong(3,customer.getMobileNo());
			ps.setString(4,customer.getPassword());
			ps.setString(5,customer.getState());
			ps.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( ps!=null)
				ps.close();
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static boolean validateCustomer(String email,String password)
	{
		boolean b=false;
		//boolean b;
		try
		{
			Class.forName(classname);
			con=DriverManager.getConnection(url, username, pw);
			ps=con.prepareStatement(validateQry);
			ps.setString(1,email);
			ps.setString(2, password);
		    rs=ps.executeQuery();
			b=rs.next();
			/*
			 *    rs.next();
			 *    String e=rs.getString("email");
				String p=rs.getString("password");
				
				if(e.equals(email)&&p.equals(password))
				{
					b=true;
				}
		
			*/
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();
				if( ps!=null)
				   ps.close();
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}
	
	
}
