package com.artworks.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.artworks.model.ArtWorkDAOImpl;
import com.artworks.model.ArtWorkDTO;
import com.page.model.pageUtil;

/**
 * Servlet implementation class DisplayListAction
 */
@WebServlet("/artworkList.do")
public class ArtworkListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtworkListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ArtWorkDAOImpl dao = ArtWorkDAOImpl.getInstance();
		
		// 현재 페이지 넘버.
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		
		// 한페이지에 3개만 보이도록
		int pageSize = 3;
		// 1페이지면, 1~3까지만 리스트보이게, 2페이지면 4~6까지 보이게
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		// 전체 개수
		int count = dao.artworkCount();
		// 전체 페이지수 구하기
		int totPage = (count/pageSize)+(count%pageSize==0?0:1);
		// 페이지는 3개씩 끊기
		int pageBlock = 3;
		// 페이지가 1~3 / 4~6 / 7~9 이런식으로
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;	// 1페이지가 시작일떄는 계속 1이도록.
		int endPage = startPage+pageBlock-1;						// 3페이지,6페이지,9페이지
		if(endPage > totPage) endPage = totPage;					// 3으로 안나눠떨어지더라도 페이지 보이게
		
		pageUtil pu = new pageUtil();
		pu.setCurrentPage(currentPage);
		pu.setEndPage(endPage);
		pu.setPageBlock(pageBlock);
		pu.setStartPage(startPage);
		pu.setTotPage(totPage);
		
		int rowNo = count - ((currentPage-1)*pageSize);//매 페이지의 시작번호
		
		ArrayList<ArtWorkDTO> array = dao.artworkList(startRow,endRow);
		request.setAttribute("artlist", array);
		request.setAttribute("rowNo", rowNo);
		request.setAttribute("count", count);
		request.setAttribute("pu", pu);
		
		RequestDispatcher rd = request.getRequestDispatcher("artworkDisplay.jsp");
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
