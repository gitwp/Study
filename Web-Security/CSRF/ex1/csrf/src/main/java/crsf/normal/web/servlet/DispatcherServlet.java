package crsf.normal.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crsf.normal.web.bean.User;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getRequestURI().substring(5);
		HttpSession session = request.getSession();
		if(action.equals("/login")){
			String userNo = request.getParameter("userNo");
			String password = request.getParameter("password");
			
			if(userNo==null){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp"); 
				dispatcher.forward(request,response);
			}else{
				User user = new User();
				user.setUserNo(userNo);
				user.setPassword(password);
				
				session.setAttribute("user", session);
				List<User> userlist = new ArrayList<User>();
				userlist.add(user);
				session.setAttribute("userlist", userlist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/userlist.jsp"); 
				dispatcher.forward(request,response);
			}
		}else if(action.equals("/userlist")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/userlist.jsp"); 
			dispatcher.forward(request,response);
		}else if(action.equals("/userAdd")){
			String userNo = request.getParameter("userNo");
			String password = request.getParameter("password");
			
			if(userNo==null || userNo.isEmpty()){
				RequestDispatcher dispatcher = request.getRequestDispatcher("/userAdd.jsp"); 
				dispatcher.forward(request,response);
			}else{
				User user = new User();
				user.setUserNo(userNo);
				user.setPassword(password);
				List<User> userlist = new ArrayList<User>();
				userlist = (List<User>) session.getAttribute("userlist");
				userlist.add(user);
				session.setAttribute("userlist", userlist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/userlist.jsp"); 
				dispatcher.forward(request,response);
			}
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp"); 
			dispatcher.forward(request,response);
		}
	}

}
