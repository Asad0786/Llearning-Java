package com.hms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.model.LoginImpl;
import com.hms.model.LoginServicesModel;
import com.hms.model.LoginUserData;

@WebServlet("/verifyCred")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	try {
		String email = request.getParameter("userEmail");
		String passw = request.getParameter("userPassw");
		String role = request.getParameter("role");
		LoginServicesModel li = new LoginImpl();
		int loginStatus = li.authenticateUser(email, passw, role);

		if (loginStatus != 0) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(300);
			String currentPage = "";
			LoginUserData userData = li.getUserDetails(loginStatus, role);
			session.setAttribute("userData", userData);
			if (role.equals("Patient")) {
				currentPage = "/WEB-INF/patient_view/home.jsp";

			} else if (role.equals("Doctor")) {
				currentPage = "/WEB-INF/doctor_view/home.jsp";

			} else if (role.equals("Reception")) {
				currentPage = "/WEB-INF/reception_view/home.jsp";

			} else {
				currentPage = "/WEB-INF/common_view/home.jsp";

			}
			RequestDispatcher rd = request.getRequestDispatcher(currentPage);
			rd.forward(request, response);
		} else {
			request.setAttribute("status", "Invalid Role/Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}
	catch(Exception e) {
		request.setAttribute("status", "Session timed out");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	}

}
