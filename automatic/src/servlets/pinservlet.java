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
@WebServlet("/pinservlet")
public class pinservlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		userbean user= new userbean();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
			PreparedStatement p=conn.prepareStatement("select from atm where CardNo=?");
			p.setInt(1, user.getCard());
			ResultSet rs=p.executeQuery();
			int PinNo=rs.getInt("PinNo");
			
			user.setPin(Integer.parseInt(request.getParameter("pin")));
			int pin=user.getPin();
			if(PinNo==pin)
			{
				response.sendRedirect("operations.jsp");
			}
			else
			{
				System.out.println("Invalid PinNo");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
