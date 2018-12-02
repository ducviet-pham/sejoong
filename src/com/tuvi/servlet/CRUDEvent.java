package com.tuvi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;  
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.tuvi.dao.Event;
import com.tuvi.utils.DBConnection;
import com.tuvi.utils.DBUtil;

/**
 * Servlet implementation class CRUDEvent
 */
@WebServlet("/CRUDEvent")
public class CRUDEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDEvent() {
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
		String stype = request.getParameter("type");
		System.out.println("stype = " + stype);
		int type = Integer.parseInt(stype);
		System.out.println("CRUDEvent doPost");
		System.out.println("CRUDEvent doPost type="+ type);
		
		int result = 0;
		PrintWriter out = response.getWriter();
		switch (type){
			case 1: {
				//create
				String stimePlace = request.getParameter("timePlace");				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
				
				Date date = null;
				try {
					date = sdf.parse(stimePlace);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					out.print (-1);
					break;
				}  
				
				Timestamp timePlace = new Timestamp(date.getTime());				
				
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				Event event = new Event();
				event.setTimePlace(timePlace);
				//event.setTimeCreated(timeCreated);
				event.setTitle(title);
				event.setContent(content);			

				try {
					result = DBUtil.insertEvent(DBConnection.getMySQLConnection(), event);
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
				String stimePlace = request.getParameter("timePlace");				
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
				
				Date date = null;
				try {
					date = sdf.parse(stimePlace);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					out.print (-1);
					break;
				}  
				
				Timestamp timePlace = new Timestamp(date.getTime());				
				
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				Event event = new Event();
				event.setTimePlace(timePlace);
				//event.setTimeCreated(timeCreated);
				event.setTitle(title);
				event.setContent(content);
				
				try {
					result = DBUtil.updateEvent(DBConnection.getMySQLConnection(), event);
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
				int id = Integer.parseInt(request.getParameter("eventId"));
				try {
					result = DBUtil.deleteEvent(DBConnection.getMySQLConnection(), id);
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
				int id = Integer.parseInt(request.getParameter("eventId"));
				System.out.println("id=" + id);
				try {
					Event resultObject = DBUtil.getEvent(DBConnection.getMySQLConnection(), id);
					if (resultObject != null){
						JSONObject  json = new JSONObject();
						try {
							//json.put("id", resultObject.getEvetnId());
							json.put("timePlace", resultObject.getTimePlace().toString());
							json.put("timeCreated", resultObject.getTimeCreated().toString());
							json.put("title", resultObject.getTitle());
							json.put("content", resultObject.getContent());						
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
					ArrayList<Event> list = (ArrayList<Event>) DBUtil.queryEvent(DBConnection.getMySQLConnection());
					if (list.size() > 0){
						for (Event event: list){
							JSONObject  json = new JSONObject();
							try {
								//json.put("id", resultObject.getEvetnId());
								json.put("timePlace", event.getTimePlace().toString());
								json.put("timeCreated", event.getTimeCreated().toString());
								json.put("title", event.getTitle());
								json.put("content", event.getContent());						
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
				
			}
		}
		System.out.println("CRUDEvent doPost end");
	}

}
