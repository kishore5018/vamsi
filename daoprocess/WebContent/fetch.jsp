<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
<table border="2">
<tr>
<th>UserName</th>
<th>Password</th>
<th>Email</th>
<th>To Do's</th>
</tr>
<%
try
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
	PreparedStatement pstmt=conn.prepareStatement("select * from empdata");
	ResultSet rs=pstmt.executeQuery();
	while(rs.next())
	{
		%>
		<tr>
		<td><%=rs.getString("username") %></td>
		<td><%=rs.getString("password") %></td>
		<td><%=rs.getString("email") %></td>
		<td>  <a href="edit.jsp?user=<%=rs.getString("username")%>">EDIT</a>  <a href="delete.jsp">DELETE</a> </td>
		</tr>	
		<% 
	}
}
catch(Exception e)
{
	System.out.println(e);
}
%>
</table>
<a href="index.jsp">HOME</a>
<th>PassWord</th>
<th>Email</th>
<th>To Do's</th>
</tr>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
	PreparedStatement pstmt=conn.prepareStatement("select * from empdata");
	ResultSet rs=pstmt.executeQuery();
    while(rs.next()){
    	%>
    	<tr>
    	<td><%=rs.getString("username") %></td>
    	<td><%=rs.getString("password") %></td>
    	<td><%=rs.getString("email") %></td>
    	<td><a href="edit.jsp">EDIT</a> <a href="delete.jsp">DELETE</a></td>
    	
    	</tr>
    	<% 	
    }
}catch(Exception e)
{
	System.out.println(e);
}
%>
</table>
<a href="index.jsp">HOME</a>
</body>
</html>