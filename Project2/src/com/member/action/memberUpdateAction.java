package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

/**
 * Servlet implementation class memberUpdateAction
 */
@WebServlet("/memberupdate.do")
public class memberUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MemberDTO member = new MemberDTO();
		member.setUseraddr(request.getParameter("upuseraddr"));
		member.setUseremail(request.getParameter("upuseremail"));
		member.setUsername(request.getParameter("upusername"));
		member.setUserpwd(request.getParameter("upuserpwd"));
		member.setUsertel(request.getParameter("upusertel"));
		member.setUserzipcode(request.getParameter("upuserzipcode"));
		member.setUserid(request.getParameter("upuserid"));
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		dao.memberUpdate(member);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberlist.do");
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
