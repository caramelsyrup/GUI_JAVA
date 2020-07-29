package org.address.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;
import org.address.model.SAddressDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class AddressSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String field = req.getParameter("field");
		String word = req.getParameter("word");
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
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(mainobj.toString());

	}

}
