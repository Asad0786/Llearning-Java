package com.hms.model;

import java.sql.Date;
import java.sql.ResultSet;

public interface LoginServicesModel {

	public int authenticateUser(String email, String password, String role);

	public boolean changeEmail(String email, String newEmail);

	public boolean changePassword(String email, String oldPass, String newPass);

	public LoginUserData getUserDetails(int id, String role);
	
	public ResultSet fetchRecord (String role);

	public boolean logout(String email);

	public String getRole(String role);
	
	public int changeSatus(String role, int id, boolean st);
	
	public int bookAppointment(int pId, int dID, String date, String disease);

	public ResultSet fetchRecordByEmail(String role, String email);
	
	public ResultSet fetchAppo() ;
	
	public ResultSet fetchRecordById(String role, int id) ;

}
