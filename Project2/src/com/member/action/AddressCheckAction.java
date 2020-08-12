package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.member.model.AddressDTO;
import com.member.model.MemberDAOImpl;

/**
 * Servlet implementation class AddressCheckAction
 */
@WebServlet("/addrCheck.do")
public class AddressCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressCheckAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("addrCheck.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String dong = request.getParameter("addrChk");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		ArrayList<AddressDTO> arr = dao.addressSearch(dong);
		
		JSONObject mainObj = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for (AddressDTO addr : arr) {
			JSONObject obj = new JSONObject();
			obj.put("zipcode", addr.getZipcode());
			obj.put("sido", addr.getSido());
			obj.put("gugun", addr.getGugun());
			obj.put("dong", addr.getDong());
			obj.put("bunji", addr.getBunji());
			jarr.add(obj);
		}
		mainObj.put("jarr", jarr);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(mainObj.toString());
	}

}
