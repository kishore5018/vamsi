package servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deletedao;
import dao.updatedao;
import userbean.userbean;

public class deleteservlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		userbean user=new userbean();
		user.setId(Integer.parseInt(request.getParameter("id")));
		deletedao.delete(user);
		response.sendRedirect("fetch.jsp");
		
		
		
	}
	

}
