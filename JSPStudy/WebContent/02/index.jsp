<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>

<a href="<%=request.getContextPath()%>/02/Hello.jsp">Hello.jsp</a><br/>
<%  String flag="";
    Object obj=session.getAttribute("flag");
    if(obj!=null){
    	flag=obj.toString();
    	System.out.print(request.getContextPath());
    }
    if(flag.equals("success_login")){%>
    <a href="<%=request.getContextPath()%>/LogoutServlet" >退出</a>	
    <%}else{%>
   <a href="<%=request.getContextPath()%>/02/login.jsp" >登录</a>	
<% } %>
</body>
</html>