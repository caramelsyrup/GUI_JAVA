package com.address.action;

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

import com.address.model.SAddressDAO;
import com.address.model.SAddressDTO;

/**
 * Servlet implementation class SearchAction
 */
@WebServlet("/address/search.do")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String field = request.getParameter("field");
		String word = request.getParameter("word");
		SAddressDAO dao = SAddressDAO.getinstance();
		ArrayList<SAddressDTO> arr = dao.addressSearch(field, word);
		int count = dao.searchCount(field, word);
		
		JSONObject mainobj = new JSONObject();
		// °Ë»ö °á°ú °´Ã¼
		JSONArray jarr = new JSONArray();
		// °Ë»ö °¹¼ö ¼¼±â °´Ã¼
		JSONObject Scount = new JSONObject();
		
		for(SAddressDTO dto:arr) {
			JSONObject obj = new JSONObject();
			obj.put("num", dto.getNum());
			obj.put("name", dto.getName());
			obj.put("address", dto.getAddress());
			obj.put("tel", dto.getTel());
			obj.put("zipcode", dto.getZipcode());
			jarr.add(obj);
		}
		
		Scount.put("count", count);
		
		mainobj.put("Scount",Scount);
		mainobj.put("Sarr", jarr);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(mainobj.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
