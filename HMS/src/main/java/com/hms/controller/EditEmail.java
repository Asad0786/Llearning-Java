package com.hms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
//import com.hms.model.LoginImpl;
//import com.hms.model.LoginServicesModel;
//import com.hms.model.LoginUserData;

/**
 * Servlet implementation class EditEmail
 */
@WebServlet("/editEmail")
public class EditEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//
//		String email = request.getParameter("email");
//		request.setAttribute("email", email);
//
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/general_view/ChangeEmail.jsp");
//		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String newEmail = request.getParameter("newEmail");
//		String oldEmail = request.getParameter("oldEmail");
//		if (newEmail.equals(oldEmail))
//			System.out.println("Its same as old email");
//		else {
//			LoginServicesModel lsm = new LoginImpl();
//			boolean changeEmail = lsm.changeEmail(oldEmail, newEmail);
//			if (changeEmail) {
//				HttpSession session = request.getSession();
//				LoginUserData userData = (LoginUserData) session.getAttribute("userData");
//				userData = lsm.getUserDetails(Integer.parseInt(userData.getId()), userData.getRole());
//				session.setAttribute("userData", userData);
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/doctor_view/home.jsp");
//				rd.forward(request, response);
//			} else
//				System.out.println("Some error");
//		}

	}

}
