package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techaplle.module.Customer;
import com.techpalle.dao.DataAccess;
import com.techpalle.util.SuccessPage;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path=request.getServletPath();
		switch(path)
		{
	
		case "/logCustomer":
			validateCustomer(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
		case "/reg":
			getRegistrationPage(request,response);
			break;
		case"/log":
			getLoginPage(request,response);
			break;
			default:
			getStartUpPage(request,response);
			break;
		}
	}

	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//read the email and password from login page and call the method
		boolean b=DataAccess.validateCustomer(request.getParameter("tbemaillog"), request.getParameter("tbpwlog"));
		//check the condition and redirect user to destination page
		if(b==true)
		{
			try
			{
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				//Store the SuccesPage class data inside Rd
				SuccessPage sp=new SuccessPage();
				request.setAttribute("successDetails", sp);
				
				rd.forward(request, response);
			} 
			catch (ServletException | IOException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			getLoginPage(request,response);
		}
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		//Read the data from jsp page
		String name=request.getParameter("tbname");
		String email=request.getParameter("tbemail");
		long mobile=Long.parseLong(request.getParameter("tbmobile"));
		String pw=request.getParameter("tbpw");
		String state=request.getParameter("ddlstates");
		
		//store data in customer object
		Customer c=new Customer(name, email, mobile, pw, state);
		
		//call insertCustomer method present in dao by passing above object
		DataAccess.insertCustomer(c);
		
		//redirect to login page along with email and password
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
            rd.forward(request, response);
		} 
		catch (ServletException | IOException e)
		{
			e.printStackTrace();
		}
	}

	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void getLoginPage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer_management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}

