package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String path = request.getServletPath();
		
		switch(path)
		{
		case "/LogCustomer":
			validateCustomer(request, response);
			break;
			
		case "/regCustomer":
			insertCustomer(request, response);
			break;
			
		case "/reg":
			getRegistrationPage(request, response);
			break;
			
		case "/Log":
			getLoginPage(request, response);
		    break;
		    
		   default:
			   getStartUpPage(request, response);
			   break;
		}
	}
    private void validateCustomer(HttpServletRequest request, HttpServletResponse response)
    {
    	// Read the data from customer_login.jsp page
    	 String e  = request.getParameter("tbEmailLog");
    	 String p =	request.getParameter("tbPassLog");
    	 
    	
    	//call validateCustomer method present in dao by passing above method
    	
    	boolean res =  DataAccess.validateCustomer(e, p);
    	 
    	
    	// Condition and Redirect user to destination success page
    	 
    	if(res)
    	{
        	try 
        	{
        		//store the SuccesPage class data inside RD
        		SuccessPage sp = new SuccessPage();
        		request.setAttribute("successDetails", sp);
        		
        		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
        		rd.forward(request, response);
    		} 
        	catch (ServletException e1)
        	{
    			e1.printStackTrace();
    		} 
        	catch (IOException e1) 
        	{
    			e1.printStackTrace();
    		}
        	
    	}
    	else
    	{
    		getLoginPage(request, response);
    		
    	}
    }
    
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
		
    	//Read the data from jsp page
    	String n = request.getParameter("tbName");
    	String e = request.getParameter("tbEmail");
    	long m = Long.parseLong(request.getParameter("tbMob"));
    	String p = request.getParameter("tbPass");
    	String s = request.getParameter("ddlstates");

    	
    	//store the data in customer model 
    	Customer c = new Customer(n, e, m, p, s);
    	
    	//call insertCustomer method present in dao by passing above method 
    	
    	DataAccess.insertCustomer(c);
    	
    	//redirect user to login page
    	
    	try 
    	{
        	RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");

			rd.forward(request, response);
		} 
    	catch (ServletException e1)
    	{
			e1.printStackTrace();
		} 
    	catch (IOException e1) 
    	{
			e1.printStackTrace();
		}
    	
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
		try 
		   {
			   RequestDispatcher rd =  request.getRequestDispatcher("customer_registration.jsp");	
			   rd.forward(request, response);
		   } 
		   catch (ServletException e)
		   {
			 e.printStackTrace();
		   } 
		   catch (IOException e) 
		   {
			 e.printStackTrace();
		   }
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {
		
		   try 
		   {
			   RequestDispatcher rd =  request.getRequestDispatcher("customer_login.jsp");	
			   rd.forward(request, response);
		   } 
		   catch (ServletException e)
		   {
			 e.printStackTrace();
		   } 
		   catch (IOException e) 
		   {
			 e.printStackTrace();
		   }
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {
	   try 
	   {
		   RequestDispatcher rd =  request.getRequestDispatcher("customer_management.jsp");	
		   rd.forward(request, response);
	   } 
	   catch (ServletException e)
	   {
		 e.printStackTrace();
	   } 
	   catch (IOException e) 
	   {
		 e.printStackTrace();
	   }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
