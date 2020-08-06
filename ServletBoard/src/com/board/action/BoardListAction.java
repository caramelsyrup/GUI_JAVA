package com.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDAOImpl;
import com.board.model.BoardDTO;

/**
 * Servlet implementation class BoardListAction
 */
@WebServlet("/board/list")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAOImpl dao =BoardDAOImpl.getinstance();
		// 페이징처리
		// 현 페이지를 처리하기 위해서 변수 설정. pageNum은 페이지가 설정되어 있지 않을때 1로 설정
		String pageNum = request.getParameter("pageNum")==null? "1":request.getParameter("pageNum");
		// 현재 페이지는 pageNum을 숫자화
		int currentPage = Integer.parseInt(pageNum);
		// 한페이지에 4개의 글이 보이도록
		int pageSize = 4;
		// 한 목록에 표시를 3개씩,
		int pageBlock = 4;
		//한 목록당 첫 페이지 숫자, 1번쨰 목록은 1이 첫째수, 2번째 목록은 5가 첫쨰수, 3번쨰 목록은 9가 첫쨰수
		int startRow = ((currentPage-1)*pageBlock)+1;
		//한 목록에서 끝숫자, 1번째 목록은 4가 끝숫자, 2번쨰 목록은 8, 3번째 목록은 12
		int endRow = currentPage*pageBlock;
		
		ArrayList<BoardDTO> arr = dao.boardList();
		request.setAttribute("list", arr);
		
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
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
