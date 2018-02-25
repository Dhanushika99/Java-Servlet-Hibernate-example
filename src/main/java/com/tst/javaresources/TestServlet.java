package com.tst.javaresources;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.google.gson.Gson;
import com.test.controllers.Users;
import com.tst.mapping.UserDetails;
import com.tst.persistance.HibernateUtil;

//import com.test.databaseConfig.HibernateUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HibernateUtil.getSessionFactory();
		Users user=null;
		response.setContentType("application/json");
		
		System.out.println(request.getParameter("username"));
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		
		if(session!=null) {
			Transaction transaction = session.beginTransaction();
			try {
				
				String nameOfUser=request.getParameter("username");
				Query query=session.createQuery("from Users user where user.userName = :name");
				query.setParameter("name", nameOfUser);
				 user=(Users)query.getSingleResult();
				System.out.println("retrieved successfully");
				if(user!=null) {
					//response.getWriter().print("Hello "+request.getParameter("username"));
					System.out.println("response created successfully");
					try {
						HttpSession httpSession=request.getSession();
						String strSession=(String) httpSession.getId();
						httpSession.setAttribute("user", user);
						System.out.println(strSession);
						
						
						UserDetails userInfo=new UserDetails();
						userInfo.setEmail(user.getEmail());
						userInfo.setUserName(user.getUserName());
						userInfo.setPassword(user.getPassword());
						Gson gson=new Gson();
						String jsonObj=gson.toJson(userInfo);
						response.getWriter().print(jsonObj);
						System.out.println(jsonObj);
					}
					catch(Exception e) {
						System.out.println(e);
					}
					
				}
				
			}catch(Exception e) {
				System.out.println("Error Mesage:"+e.getMessage());
				transaction.rollback();
			}
			
		}else {
			System.out.println("session is null");
		}
		
		
		
	}

}
