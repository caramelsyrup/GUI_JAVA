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
import com.board.model.PageBean;

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
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		// ���� �������� pageNum�� ����ȭ
		int currentPage = Integer.parseInt(pageNum);
		// ���������� 4���� ���� ���̵���
		int pageSize = 4;
		
		// �������� �ѹ��� 3���� ǥ��,  123 / 456 / 789 �� ���
		int pageBlock = 3;
		
		// �������� �����ͺ��̽��� �� ù��° ����, 1�������� 1�� ù°��, 2�������� 5�� ù����, 3�������� 9�� ù����
		int startRow = ((currentPage-1)*pageBlock)+1;
		// �������� �����ͺ��̽��� �� ������ ����, 1������ 4�� ������, 2������ 8, 3������ 12
		int endRow = currentPage*pageBlock+1;
		// �� �ΰ��� ������ ������, �����ͺ��̽����� ���� �̾Ƴ���. ���ϴ� ������ŭ.
		
		// �������� �����ϱ� ���� �ܰ�
		// ��ü ���� ������ ���Ѵ�.
		int count = dao.boardCount();
		
		// ��ü �� ����/���������� ���̴� ���� �� �� �ϸ� ��ü ���� �� ������ ���� ����� �ȴ�.��ü���� ���� �������� ����� �ƴ϶�� �������� �����Ѵ�.
		// �̰��� ǥ���Ϸ��� �ϸ� 1�������� ���;��Ѵ�. �׸��� �� �������� 4���� ���� �ߴµ�, ���� 5���� ��쿡�� 2������������ ���;��Ѵ�.
		// �׷��� �ڿ� 4�� ���������� ���� ������ �߰��� 1�������� �� �������� �ؾ��Ѵ�.
		int totalpage = (count/pageSize)+(count%pageSize==0?0:1);
		
		// ù ���� �������� ���� ����, ù �������� 1, �ι��� ������ 4, ����° �������� 7�̴�.
		// ù 1�������� ������ �����Ѵ�. �׸��� ���� 3���� ���� �߱� ������, 3������������ ��ŸƮ �������� 1�� �Ǿ���Ѵ�. 
		// 2���� ���� ������ 4�������� 5�� 6������������ ��� �����ؾ��Ѵ�.
		// ((currentPage-1)/pageBlock)���� currentPage�� 1,2,3�� �Ǿ, ���� 0�̴�. �׷��� ���� ���ص� 0�̴�. �� ������ ��ŸƮ�� 1�������� 1�� ����.
		// currentPage�� 4�� �Ǹ�, ���� 1�� �ȴ�. �ι��� �������� 4�������� ��ŸƮ��. �׷��� ���� ���ϸ� 3�� �����Ҽ� �ְ�, ���⿡ 1�� ���ϸ� 4�������� ������ �ִ�.
		int startPage = (((currentPage-1)/pageBlock)*pageBlock)+1;
		// �� ������ ������ ��ŸƮ���������� ���� ���Ѵ�. �׷��� ù�������� 1+3�� �Ǿ 4���ȴ�. ���⼭ 1�� ���� ù���� ������ �������� �ȴ�.
		int endPage = startPage+pageBlock-1;
		// ���������� ��ü ������������ ũ�� �ȵǱ� ������, ���� �����.
		if(endPage>totalpage) endPage=totalpage;
		
		// �׸��� ������ �������� ���� �ڹ� ���Ͽ� ������ �ߴ�.
		PageBean pb = new PageBean();
		pb.setCurrentPage(currentPage);
		pb.setEndPage(endPage);
		pb.setEndRow(endRow);
		pb.setPageBlock(pageBlock);
		pb.setStartPage(startPage);
		pb.setStartRow(startRow);
		pb.setTotalpage(totalpage);
		
		// ����¡�� ����� ��ü���⸦ �����ϱ� ���ؼ� �޼��带 �̿�.
		ArrayList<BoardDTO> arr=null;
		arr = dao.boardList(startRow, endRow);
		request.setAttribute("list", arr);
		request.setAttribute("pb", pb);
		
		// �� �����͸� ������ list.jsp
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
