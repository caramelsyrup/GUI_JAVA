package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

/**
 * Servlet implementation class memberDetailAction
 */
@WebServlet("/memberDetail.do")
public class memberDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberDetailAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		HttpSession session = request.getSession();
		
		int grade = (int) session.getAttribute("grade");
		// 0은 일반회원, 1은 관리자
		if(grade == 0){
			String userid = (String)session.getAttribute("userid");;
			MemberDTO dto = dao.memberDetail(userid);
			request.setAttribute("memberDetail", dto);
		}else if(grade == 1){
			String userid = (String)session.getAttribute("userid");;
			MemberDTO dto = dao.memberDetail(userid);
			request.setAttribute("memberDetail", dto);
		}else {
			int usernum =Integer.parseInt(request.getParameter("usernum"));
			MemberDTO dto = dao.memberDetail(usernum);
			request.setAttribute("memberDetail", dto);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("memberdetail.jsp");
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
