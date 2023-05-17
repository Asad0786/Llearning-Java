package com.hms.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.model.AppointmentData;
import com.hms.model.LoginImpl;
import com.hms.model.LoginServicesModel;

/**
 * Servlet implementation class listAppointment
 */
@WebServlet("/listAppo")
public class listAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(300);
			if (session.getAttribute("userData") != null) {
				ArrayList<Integer> pd = new ArrayList<>();
				ArrayList<Integer> dd = new ArrayList<>();
				ArrayList<String> date = new ArrayList<>();
				ArrayList<AppointmentData> ares = new ArrayList<>();

				LoginServicesModel lsm = new LoginImpl();
				ResultSet fetchAppo = lsm.fetchAppo();
				try {
					while (fetchAppo.next()) {
						pd.add(fetchAppo.getInt(2));
						dd.add(fetchAppo.getInt(3));
						date.add(fetchAppo.getString(5));
					}
					int i = 0;

					while (i < pd.size()) {
						ResultSet rs = lsm.fetchRecordById("patient", pd.get(i));
						if (rs.next()) {
							AppointmentData ad = new AppointmentData();
							ad.setPatientName(rs.getString(2));
							ad.setAppointmentDate(date.get(i));
							rs.close();
							rs = lsm.fetchRecordById("doctor", dd.get(i));
							if (rs.next()) {
								ad.setDoctorName(rs.getString(2));
							}
							rs.close();
							ares.add(ad);
						}
						i = i + 1;
					}

					request.setAttribute("data", ares);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/common_view/listAppo.jsp");
					rd.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("status", "login again");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(300);
			if (session.getAttribute("userData") != null) {
				doGet(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("status", "login again");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}
