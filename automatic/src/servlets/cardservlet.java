package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import userbean.userbean;
@WebServlet("/cardservlet")
public class cardservlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","cubic","cubic");
			PreparedStatement p=conn.prepareStatement("select*from atm");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
			int CardNo= rs.getInt("CardNo");
			userbean user= new userbean();
			user.setCard(Integer.parseInt(request.getParameter("card")));
			int Card= user.getCard();
			if(CardNo==Card)
			{
			response.sendRedirect("pinno.jsp");	
			}
			else
			{
				System.out.println("Card no is not valid");
			}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}


