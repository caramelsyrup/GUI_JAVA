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
		// ����¡ó��
		// �� �������� ó���ϱ� ���ؼ� ���� ����. pageNum�� �������� �����Ǿ� ���� ������ 1�� ����
		String pageNum = request.getParameter("pageNum")==null? "1":request.getParameter("pageNum");
		// ���� �������� pageNum�� ����ȭ
		int currentPage = Integer.parseInt(pageNum);
		// ���������� 4���� ���� ���̵���
		int pageSize = 4;
		// �� ��Ͽ� ǥ�ø� 3����,
		int pageBlock = 4;
		//�� ��ϴ� ù ������ ����, 1���� ����� 1�� ù°��, 2��° ����� 5�� ù����, 3���� ����� 9�� ù����
		int startRow = ((currentPage-1)*pageBlock)+1;
		//�� ��Ͽ��� ������, 1��° ����� 4�� ������, 2���� ����� 8, 3��° ����� 12
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
