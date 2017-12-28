<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Form !</title>
</head>
<body>

<% 

if(session.getAttribute("userName")==null && session.getAttribute("password")==null)
{
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>



Your update form here ! You cannot update User Name ! But you can change other information !

<center>
			<form action="LoginRegister" method="post" style="padding-top:50px">
				<table style="padding:40px;background-color:#B2BEB5">

					<tr>
						<td>First Name :</td>   
						<td><input type="text" name="update_firstname"></td>
					</tr>
					<tr>
						<td>Last Name :</td>   
						<td><input type="text" name="update_lastname"></td>
					</tr>
					<tr>
						<td>Password :</td>   
						<td><input type="password" name="update_password" ></td>
					</tr>
					<tr>
						<td></td>   
						<td><input type="submit" name="submit" value="Update" ></td>
					</tr>
				</table>
			</form>
</center>

</body>
</html>