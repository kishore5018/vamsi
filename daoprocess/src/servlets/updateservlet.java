package servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.insertdao;
import dao.updatedao;
import userbean.userbean;

@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		userbean user=new userbean();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));
		user.setId(Integer.parseInt(request.getParameter("id")));
		updatedao.update(user);
		response.sendRedirect("fetch.jsp");
		
		
		
	}
	

}
