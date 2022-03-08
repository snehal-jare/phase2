<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body >
<br><center>
<a href=HomePage.jsp style="color:black;text-decoration:none ;font-size:35px;font-weight:bold;">FlyAway</a>
</center>
<br><br>
<center>
<h1>Insert New Flight Details</h1>

<div style="border:5px solid blrown;width:25%;border-radius:10px;padding:20px" align="center">
<form action=InsertFlight method=post>
	<label for=name>Name :-</label> <input type="text" name=name id=name /><br><br>
	<label for=Source>Source :-</label> <input type="text" name=Source id=Source /><br><br>
	<label for=Dest>Dest :-</label> <input type="text" name=Dest id=Dest /><br><br>
	<label for=departure>Departure :-</label> <input type="date" name=departure id=departure /><br><br>
	<label for=time>Time :-</label> <input type="time" name=time id=time /><br><br>
	<label for=price>Price :-</label> <input type="text" name=price id=price /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>
</div>
</center>
<center>
<%
	String message=(String)session.getAttribute("message");
	if(message!=null){
%>
<p style="color:Green;"><%=message %></p>
<%
		session.setAttribute("message", null);
	}
%>
</center>
</body>
</html>