<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<style>
  h1 {color:Black;}
  p {color:blue;}
</style>
<body >
<center>
<h1>FlyAway</h1>
</center>

<div align="right">
<a href="AdminPage.jsp">Admin Login</a>
</div>

<%
	@SuppressWarnings("unchecked")
	HashMap<String,String> user=(HashMap<String,String>)session.getAttribute("user");
	if(user!=null){
%>
<p>Welcome <%=user.get("name") %></p>
<a href="Logout">Logout</a>
<%
	}else{
%>
<a href=UserPage.jsp>User Login</a>
<%
	}
%>
<br><br>
<center>
<div style="border:3px solid Black;width:25%;border-radius:10px;padding:15px" align="center">
<form action=FlightList method=post>
	<h3>Search for Flights</h3> <br>
	<p><label for=Source>Source :-</label> <input type=text name=Source id=Source/><br><br>
	<label for=Dest>Dest :-</label> <input type=text name=Dest id=Dest/><br><br>
	<label for=departure>Departure :-</label> <input type=date name=departure id=departure/><br><br>
	<label for=travellers>Travellers :-</label> <input type=number name=travellers id=travellers/><br><br>
	<input type=submit value=Search /> <input type=reset /> </p>
</form>
</div>
</center>
</body>
</html>