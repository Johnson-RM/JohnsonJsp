package com.yongsheng.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yongsheng.service.Check;

import yongsheng.com.entity.UserEntity;

public class CheckSevlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3537145668700055787L;
    private UserEntity user=new UserEntity();
    private Check check=new Check();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String userName=req.getParameter("userName");
	String password=req.getParameter("password");
	user.setName(userName);
	user.setPassword(password);
    Boolean boolean1=check.check_login(user);
    if(boolean1) {
    	String forward="/01/success_login.jsp";
    	RequestDispatcher rDispatcher=req.getRequestDispatcher(forward);
    	rDispatcher.forward(req, resp);
    	}
    else {
    	String msg="密码或用户账号错误！请重新登录";
    	req.setAttribute("msg",msg );
    	String forward="/01/error_login.jsp";
    	RequestDispatcher rDispatcher=req.getRequestDispatcher(forward);
    	rDispatcher.forward(req, resp);
    }
	}

}
