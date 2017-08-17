<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
color:#000;
font-size: 14px;
margin: 20px auto;
}
#message{
 text-align:center
}
</style>
</head>
<body>
<div id="message">
登录失败  <br/>
错误提示：<%=request.getAttribute("msg")%>
您提交的信息为：<br/>
用户名 :<%=request.getParameter("userName") %> 
密码:<%=request.getParameter("password") %>
<a href="01/login.jsp">返回登录页面</a>
</div>
</body>
</html>