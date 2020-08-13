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
 * Servlet implementation class DisplayInsertAction
 */
@WebServlet("/artworkInsert.do")
public class ArtworkInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtworkInsertAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String arttitle = request.getParameter("arttitle");
		String artmaker = request.getParameter("artmaker");
		String artdescription = request.getParameter("artdescription");
		String filename =  request.getParameter("afilename");
		
		ArtWorkDTO art = new ArtWorkDTO();
		art.setArtdescription(artdescription);
		art.setArtmaker(artmaker);
		art.setArttitle(arttitle);
		art.setFilename(filename);
		
		ArtWorkDAOImpl dao = ArtWorkDAOImpl.getInstance();
		dao.artworkInsert(art);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("artworkList.do");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
