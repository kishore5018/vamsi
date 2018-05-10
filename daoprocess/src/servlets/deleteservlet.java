package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deletedao;
import dao.updatedao;
import userbean.userbean;

public class deleteservlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		System.out.println("hai");
		userbean user=new userbean();
		user.setUsername(request.getParameter("username"));
		deletedao.delete(user);
		response.sendRedirect("fetch.jsp");
		
		
		
	}
	

}
