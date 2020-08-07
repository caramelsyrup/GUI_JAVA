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
		// 페이징처리
		// 현 페이지를 처리하기 위해서 변수 설정. pageNum은 페이지가 설정되어 있지 않을때 1로 설정
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		// 현재 페이지는 pageNum을 숫자화
		int currentPage = Integer.parseInt(pageNum);
		// 한페이지에 4개의 글이 보이도록
		int pageSize = 4;
		
		// 페이지를 한번에 3개씩 표시,  123 / 456 / 789 의 방식
		int pageBlock = 3;
		
		// 페이지의 데이터베이스의 글 첫번째 숫자, 1페이지은 1이 첫째수, 2페이지은 5가 첫쨰수, 3페이지은 9가 첫쨰수
		int startRow = ((currentPage-1)*pageBlock)+1;
		// 페이지의 데이터베이스의 글 마지막 숫자, 1페이지 4가 끝숫자, 2페이지 8, 3페이지 12
		int endRow = currentPage*pageBlock+1;
		// 이 두가지 변수를 가지고, 데이터베이스에서 글을 뽑아낸다. 원하는 갯수만큼.
		
		// 페이지를 구현하기 위한 단계
		// 전체 글의 개수를 구한다.
		int count = dao.boardCount();
		
		// 전체 글 개수/한페이지에 보이는 글의 수 를 하면 전체 글의 총 페이지 수가 계산이 된다.전체글의 수가 사이즈의 배수가 아니라면 나머지가 존재한다.
		// 이것을 표현하려고 하면 1페이지는 나와야한다. 그리고 한 페이지에 4개의 글이 뜨는데, 만약 5개일 경우에는 2페이지까지는 나와야한다.
		// 그래서 뒤에 4로 나누었을때 몫이 있으면 추가로 1페이지가 더 나오도록 해야한다.
		int totalpage = (count/pageSize)+(count%pageSize==0?0:1);
		
		// 첫 시작 페이지를 살펴 보면, 첫 블럭에서는 1, 두번쨰 블럭에선 4, 세번째 블럭에서는 7이다.
		// 첫 1페이지는 무조건 떠야한다. 그리고 블럭을 3으로 지정 했기 떄문에, 3페이지까지는 스타트 페이지는 1이 되어야한다. 
		// 2번쨰 블럭의 시작인 4페이지는 5나 6페이지에서도 계속 존재해야한다.
		// ((currentPage-1)/pageBlock)에서 currentPage가 1,2,3이 되어도, 몫은 0이다. 그래서 블럭을 곱해도 0이다. 이 블럭에서 스타트는 1페이지라서 1을 더함.
		// currentPage가 4가 되면, 몫은 1이 된다. 두번쨰 블럭에서는 4페이지가 스타트다. 그래서 블럭을 곱하면 3을 도출할수 있고, 여기에 1을 더하면 4페이지를 얻을수 있다.
		int startPage = (((currentPage-1)/pageBlock)*pageBlock)+1;
		// 끝 페이지 설정은 스타트페이지에서 블럭을 더한다. 그러면 첫블럭에서는 1+3이 되어서 4가된다. 여기서 1을 뺴면 첫블럭의 마지막 페이지가 된다.
		int endPage = startPage+pageBlock-1;
		// 끝페이지가 전체 페이지수보다 크면 안되기 떄문에, 같게 만든다.
		if(endPage>totalpage) endPage=totalpage;
		
		// 그리고 페이지 변수들을 따로 자바 파일에 저장을 했다.
		PageBean pb = new PageBean();
		pb.setCurrentPage(currentPage);
		pb.setEndPage(endPage);
		pb.setEndRow(endRow);
		pb.setPageBlock(pageBlock);
		pb.setStartPage(startPage);
		pb.setStartRow(startRow);
		pb.setTotalpage(totalpage);
		
		// 페이징이 적용된 전체보기를 구현하기 위해서 메서드를 이용.
		ArrayList<BoardDTO> arr=null;
		arr = dao.boardList(startRow, endRow);
		request.setAttribute("list", arr);
		request.setAttribute("pb", pb);
		
		// 이 데이터를 가지고 list.jsp
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
