package com.hms.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.model.LoginImpl;
import com.hms.model.LoginServicesModel;

/* 
 * Servlet implementation class AddAppointment
 */
@WebServlet("/addAppointment")
public class AddAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(300);
			if (session.getAttribute("userData") != null) {
				LoginServicesModel lms = new LoginImpl();
				ResultSet rs = lms.fetchRecord("patient");
				ResultSet ds = lms.fetchRecord("doctor");

				request.setAttribute("rs", rs);
				request.setAttribute("ds", ds);
				if (rs != null && ds != null) {
					RequestDispatcher rd = request
							.getRequestDispatcher("/WEB-INF/reception_view/create_appointment.jsp");
					rd.forward(request, response);
				} else {
					// create a general page laer to add list of docs and patients
					System.out.println("No record found!!");
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("status", "Session timed out, login again");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(300);
		if (session.getAttribute("userData") != null)
			doGet(request, response);
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("status", "Session timed out, login again");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
