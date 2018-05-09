<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Details of Employee</h1><br><br>
<%
try
{
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
	
	PreparedStatement pstmt=conn.prepareStatement("select * from empdata ");
	
    ResultSet rs=pstmt.executeQuery();
    while(rs.next())
    {
    	%>
    	
    UserName:<%= rs.getString("username") %><br><br>
    Password:<%= rs.getString("password") %><br><br> 	
    Email::::<%= rs.getString( "Email"  ) %><br><br>	
    Id:::::::<%= rs.getString(   "id"   ) %><br><br>	
    	
    	
    	
    	<%
    }
}
catch(Exception e)
{
	System.out.println(e);
}




%>









</body>
</html>