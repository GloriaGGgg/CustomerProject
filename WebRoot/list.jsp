<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>This is the list for all the customers.</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<h3 align="center">Customer List</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>Customer Name</th>
			<th>Customer Gender</th>
			<th>Birthday</th>
			<th>Cell Phone</th>
			<th>Email Address</th>
			<th>Description</th>
			<th>Operations</th>
		</tr>
		<c:forEach items="${requestScope.cstmList}" var="cstm">
		<tr>
			<th>${cstm.cname }</th>
			<th>${cstm.gender }</th>
			<th>${cstm.birthday }</th>
			<th>${cstm.cellphone }</th>
			<th>${cstm.email }</th>
			<th>${cstm.description }</th>
			<th>
				<a href="<c:url value='/CustomerServlet?method=preEdit&cid=${cstm.cid }' />">Edit</a>
				<a href="<c:url value='/CustomerServlet?method=delete&cid=${cstm.cid }' />">Delete</a>
			</th>
		</tr>
		</c:forEach>
		
	</table>
<br/>
  </body>
</html>
