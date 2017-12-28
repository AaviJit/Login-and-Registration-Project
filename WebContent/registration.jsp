<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form !</title>
</head>
<body>
	<center>
			<form  action="LoginRegister" method="post" style="padding-top:50px">
			<h3>${emptyMessage}</h3>
				<table style="padding:40px;background-color:#B2BEB5">

					<tr>
						<td>User Name :</td>   
						<td><input type="text" name="register_username"></td>
					</tr>
					<tr>
						<td>First Name :</td>   
						<td><input type="text" name="register_firstname"></td>
					</tr>
					<tr>
						<td>Last Name :</td>   
						<td><input type="text" name="register_lastname"></td>
					</tr>
					<tr>
						<td>Password</td>   
						<td><input type="password" name="register_password" ></td>
					</tr>
					<tr>
						<td></td>   
						<td><input type="submit" name="submit" value="Register" ></td>
					</tr>
				</table>
			</form>
	</center>
</body>
</html>