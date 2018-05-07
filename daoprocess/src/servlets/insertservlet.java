package servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.insertdao;
import userbean.userbean;

@WebServlet("/insertservlet")
public class insertservlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("hai");
		userbean user=new userbean();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setId(Integer.parseInt(request.getParameter("id")));
		insertdao.insert(user);
		response.sendRedirect("insertsuccess.jsp");
		
		
		
	}
	

}
