package com.yongsheng.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3189710993900164314L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   String userName=req.getParameter("userName");
	   String password=req.getParameter("password");
	   String forward=null;
	   if(userName.equals("chen")&&password.equals("12345")) {
		   req.getSession().setAttribute("flag", "success_login");
		   forward="/02/index.jsp";
	       RequestDispatcher rd=req.getRequestDispatcher(forward);
	       rd.forward(req, resp);
	   }else {
		   System.out.println(req.getContextPath()+"cys");
		   forward="/02/login.jsp";
	       RequestDispatcher rd=req.getRequestDispatcher(forward);
	       rd.forward(req, resp);
	   }
	   
	}
	

}
