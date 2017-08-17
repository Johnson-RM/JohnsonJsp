package com.yongsheng.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

/**
 * Servlet Filter implementation class encodingFilter
 */
public class encodingFilter implements Filter {
    private String coding;
    /**
     * Default constructor. 
     */
    public encodingFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("=====构造方法======");
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 coding=fConfig.getInitParameter("encoding");
		 if(coding==null) 
			 throw new ServletException("默认编码格式为空");
		 System.out.println(coding+"cys");
		 
		 
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("1+cys");
		if(!coding.equals(request.getCharacterEncoding())) {//写错导致bug
			request.setCharacterEncoding(coding);
		}
		response.setCharacterEncoding(coding);
		chain.doFilter(request, response);
	}


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
