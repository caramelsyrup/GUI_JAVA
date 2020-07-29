package org.address.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;
import org.address.model.SAddressDTO;


public class AddressInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		String zipcode = req.getParameter("zipcode");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		
		SAddressDTO sa = new SAddressDTO();
		sa.setAddress(address);
		sa.setName(name);
		sa.setTel(tel);
		sa.setZipcode(zipcode);
		
		SAddressDAO dao = SAddressDAO.getinstance();
		dao.insertAddress(sa);
		
		// 해당 페이지로 넘어가면서 모든 권한 넘김.
		resp.sendRedirect("list.ad");

	}

}
