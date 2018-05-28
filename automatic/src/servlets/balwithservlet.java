package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userbean.userbean;
@WebServlet("/balwithservlet")
public class balwithservlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		userbean user= new userbean();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
			PreparedStatement p=conn.prepareStatement("select from atm where CardNo=? and PinNo=?");
			p.setInt(1, user.getCard());
			p.setInt(2, user.getPin());
			ResultSet rs=p.executeQuery();
			int Balance=rs.getInt("balance");
			
			user.setBal(Integer.parseInt(request.getParameter("bal")));
			int bal=user.getBal();
			if(Balance>=bal)
			{
				Balance=Balance-bal;
				response.sendRedirect("takecash.jsp");
				
			}
			else
			{
				response.sendRedirect("insuf.jsp");
			}
				
			} 
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
