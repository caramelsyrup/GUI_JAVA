package com.events.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.events.model.EventsDAO;
import com.events.model.EventsDAOImpl;
import com.events.model.EventsDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class EventsInsertAction
 */
@WebServlet("/eventsInsert.do")
public class EventsInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventsInsertAction() {
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
		request.setCharacterEncoding("utf-8");
		// ���� ���ε�
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "utf-8";
		String savePath = "images";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(request, 
				uploadFilePath, 
				uploadFileSizeLimit,
				encType,
				new DefaultFileRenamePolicy()
				);
		String filename = multi.getFilesystemName("efilename");
		if(filename==null) {
			System.out.println("���Ͼ��ε� �ȵ�");
		}else {
			// ���� ���ε� ������ �ش� �������� �Ķ���͸� ��� DTO�� �Է�
			EventsDTO event = new EventsDTO();
			
			event.setEventname(multi.getParameter("eventname"));
			event.setEventdescip(multi.getParameter("eventdescip"));
			event.setEventhost(multi.getParameter("eventhost"));
			event.setEventlocation(multi.getParameter("eventlocation"));
			event.setEventsche(multi.getParameter("eventsche"));
			event.setFilename(filename);
			
			// �߰��޼ҵ� ����
			EventsDAOImpl dao = EventsDAOImpl.getInstance();
			dao.eventsInsert(event);
			
			RequestDispatcher rd = request.getRequestDispatcher("eventslist.do");
			rd.forward(request, response);
		}
	}

}
