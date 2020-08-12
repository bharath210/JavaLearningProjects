package com.day1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet
{
       LoginDao dao = new LoginDao();
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
 	{
		String user = request.getParameter("uname");
		String pass = request.getParameter("psword");
		if(dao.checkCredentials(user, pass))
		{
			HttpSession session = request.getSession();
			session.setAttribute("usr", user);
			response.sendRedirect("welcome.jsp");
		}else
		{
			response.sendRedirect("login.jsp");
		}
	}


}
