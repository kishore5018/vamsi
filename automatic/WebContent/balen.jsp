<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection" %>
<%@page import="userbean.userbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your Account Balance is:</h1><br><br>
<%
try
{
	userbean user= new userbean();
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
	PreparedStatement p=conn.prepareStatement("select from atm where CardNo=? and PinNo=?");
	p.setInt(1, user.getCard());
	p.setInt(2,user.getPin());
	ResultSet rs=p.executeQuery();
	int Balance=rs.getInt("Balance");
	System.out.println(Balance);
	
}
catch(Exception e)
{
	System.out.println(e);
}

%>

</body>
</html>