package com.tst.javaresources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.controllers.Users;
import com.tst.persistance.HibernateUtil;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("********** sinup java *********** ");
		System.out.println(request.getParameter("email")+request.getParameter("userName")+request.getParameter("fullName"));
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		Users user=new Users();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setUserName(request.getParameter("userName"));
		user.setUserName(request.getParameter("fullName"));
		session.save(user);
		transaction.commit();
		/*doGet(request, response);*/
	}

}
