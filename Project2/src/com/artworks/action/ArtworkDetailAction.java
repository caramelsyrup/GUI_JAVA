package com.artworks.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artworks.model.ArtWorkDAOImpl;
import com.artworks.model.ArtWorkDTO;

/**
 * Servlet implementation class ArtworkDetailAction
 */
@WebServlet("/artworkDetail.do")
public class ArtworkDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtworkDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("utf-8");
		
		int artid = Integer.parseInt(request.getParameter("artid"));
		ArtWorkDAOImpl dao = ArtWorkDAOImpl.getInstance();
		ArtWorkDTO artDto =  dao.artworkDetail(artid);
		
		request.setAttribute("artDetail", artDto);
		
		RequestDispatcher rd = request.getRequestDispatcher("artworkDetail.jsp");
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
