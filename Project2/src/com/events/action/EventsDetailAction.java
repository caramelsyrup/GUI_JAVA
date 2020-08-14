package com.events.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.events.model.EventsDAOImpl;
import com.events.model.EventsDTO;

/**
 * Servlet implementation class EventsDetailAction
 */
@WebServlet("/eventsDetail.do")
public class EventsDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventsDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int eventnum = Integer.parseInt(request.getParameter("eventnum"));
		EventsDAOImpl dao = EventsDAOImpl.getInstance();
		EventsDTO event = dao.eventsDetail(eventnum);
		
		request.setAttribute("event", event);
		
		RequestDispatcher rd = request.getRequestDispatcher("eventsDetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
