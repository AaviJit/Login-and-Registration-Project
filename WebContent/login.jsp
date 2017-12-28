<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<% 

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");

%>


<center>
	<form action="LoginRegister" method="post" style="padding-top:50px">

		<table style="background-color:green;padding:20px">
		
			<tr>
				<td><h3> ${ErrorMessage}</h3> 
				<h3> ${successMessage}</h3>
				<h3> ${updateMessage}</h3>
				
				 </td>
			</tr>
			<tr><td><h3>Login Here</h3></td></tr>
			<tr>
				<td>User Name </td>
				<td><input type="text" name="login_username"></td>
			</tr>
			
			<tr>
				<td>Password </td>
				<td><input type="password" name="login_password" ></td>
			</tr>
			
			<tr><td></td><td><input type="submit" name="submit" value="Login"></td><td><a href="registration.jsp">Registration Here</a></td></tr>
		</table>
	</form>
</center>
</body>
</html>