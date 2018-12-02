package com.tuvi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.tuvi.dao.AdminAccount;
import com.tuvi.dao.Event;
import com.tuvi.utils.DBConnection;
import com.tuvi.utils.DBUtil;

/**
 * Servlet implementation class CRUDAdmin
 */
@WebServlet("/CRUDAdmin")
public class CRUDAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String stype = request.getParameter("type");
		System.out.println("stype = " + stype);
		int type = Integer.parseInt(stype);
		System.out.println("CRUDAdmin doPost");
		System.out.println("CRUDAdmin doPost type="+ type);
		
		int result = 0;
		PrintWriter out = response.getWriter();
		switch (type){
			case 1: {
				//create
				
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				int permission = Integer.parseInt(request.getParameter("password"));
				AdminAccount adminAccount = new AdminAccount();
				adminAccount.setUserName(userName);
				//event.setTimeCreated(timeCreated);
				adminAccount.setPassword(password);
				adminAccount.setPermission(permission);			

				try {
					result = DBUtil.insertAdminAccount(DBConnection.getMySQLConnection(), adminAccount);
					if (result == 1){
						out.print(0);
					} else {
						out.print(1);
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print(-1);
					break;
				}				
				break;
			}
			case 2: {
				//update
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				int permission = Integer.parseInt(request.getParameter("password"));
				
				AdminAccount adminAccount = new AdminAccount();
				adminAccount.setUserName(userName);
				adminAccount.setPassword(password);
				adminAccount.setPermission(permission);
				
				try {
					result = DBUtil.updateAdminAccountByName(DBConnection.getMySQLConnection(), adminAccount);
					if (result == 1){
						out.print(0);
					} else {
						out.print(1);
					}
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print(-1);
					break;
				}	
				
				break;
			}
			case 3: {
				//delete
				String userName = request.getParameter("userName");
				try {
					result = DBUtil.deleteAdminAccount(DBConnection.getMySQLConnection(), userName);
					out.print(0);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print(-1);					
				}				
				break;
			}
			case 4: {
				//get
				String userName = request.getParameter("UserName");
				System.out.println("userName: " + userName);
				try {
					AdminAccount resultObject = DBUtil.getAdminAccount(DBConnection.getMySQLConnection(), userName);
					if (resultObject != null){
						JSONObject  json = new JSONObject();
						try {
							json.put("userId", resultObject.getUserId());
							json.put("userName", resultObject.getUserName());
							json.put("password", resultObject.getPassword());
							json.put("permission", resultObject.getPermission());						
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							out.print(-1);		
							break;
						}					
						out.print(json.toString());		
					} else {
						out.print(1);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print(-1);					
				}	
				break;
			}
			case 5: {
				//get all
				try {
					ArrayList<AdminAccount> list = (ArrayList<AdminAccount>) DBUtil.queryAdminAccount(DBConnection.getMySQLConnection());
					if (list.size() > 0){
						for (AdminAccount adminAccount: list){
							JSONObject  json = new JSONObject();
							try {
								json.put("userId", adminAccount.getUserId());
								json.put("userName", adminAccount.getUserName());
								json.put("password", adminAccount.getPassword());
								json.put("permission", adminAccount.getPermission());						
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								continue;
							}					
							out.print(json.toString());	
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					out.print(-1);
				}
				break;
			}
			default: {
				out.print(1);
			}
		}
		System.out.println("CRUDAdmin doPost end");
	}
}
