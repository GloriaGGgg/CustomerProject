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
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- jquery是js的框架，它封装很多功能，用起来比js方便很多 -->
	

  </head>
  
  <body>
<h3 align="center">Add Customer</h3>
	<form action="<c:url value='/CustomerServlet' />" method="post">
	<input type="hidden" name="method" value="add">
		<table border="0" align="center" width="800px;" style="padding-left:250px">
			<tr>
				<td width="100px">Customer Name</td>
				<td width="40%">
					<input type="text" name="cname" />
				</td>
				<td align="left" style="color:red;">
					<label id="cnameError" class="error">&nbsp;</label>
				</td>
			</tr>
			<tr>
				<td>Customer Gender</td>
				<td>
					<input type="radio" name="gender" value="male" id="male" />
					<label for="male">Male</label>
					<input type="radio" name="gender" value="female" id="female" />
					<label for="female">Female</label>
				</td>
				<td align="left" style="color:red;">
					<label id="genderError" class="error">&nbsp;</label>
				</td>
			</tr>
			
			<tr>
				<td>Birthday</td>
				<td>
					<input type="text" name="birthday" />
				</td>
				<td>
					<label id="birthdayError" class="error">&nbsp;</label>
				</td>
			</tr>
			
			<tr>
				<td>Cell Phone</td>
				<td>
					<input type="text" name="cellphone" />
				</td>
				<td>
					<label id="cellphoneError" class="error">&nbsp;</label>
				</td>
			</tr>
			
			<tr>
				<td>Email Address</td>
				<td>
					<input type="text" name="email" />
				</td>
				<td>
					<label id="emailError" class="error">&nbsp;</label>
				</td>
			</tr>
			
			<tr>
				<td>Description</td>
				<td>
					<textarea rows="5" cols="27" name="description"></textarea>
				</td>
				<td>
					<label id="descriptionError" class="error">&nbsp;</label>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td colspan="2">
					<input type="submit" value="Add Customer" />
					<input type="reset" value="Reset" />
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>
