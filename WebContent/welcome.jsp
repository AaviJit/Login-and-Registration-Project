<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="backendPackage.BasicStudentClass"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page !</title>
</head>
<body>

<% 


response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");

if(session.getAttribute("userName")==null && session.getAttribute("password")==null)
{
	request.getRequestDispatcher("login.jsp").forward(request, response);
}

else{
%>



<center>

	<% 
		BasicStudentClass basicobj= (BasicStudentClass) session.getAttribute("basicobj");
	%>

	<h1>Hello <%= basicobj.getFirstName()%> !! Welcome to your page !!</h1>
	
	
	Your full name is <%= basicobj.getFirstName()+" "+basicobj.getLastName()%> ! And your user name is <%= basicobj.getUserName()%> !
	<br />
	If you want to update your information click on <a href="update.jsp">Update</a>
	
	
	
	<form action="LoginRegister" method="post">
	<input type="submit" name="submit" value="Logout">
</form>
</center>
<% }%>


</body>
</html>