package org.address.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;
import org.address.model.SAddressDTO;


public class AddressUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SAddressDTO dto = new SAddressDTO();
		dto.setAddress(req.getParameter("address"));
		dto.setName(req.getParameter("name"));
		dto.setTel(req.getParameter("tel"));
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		
		SAddressDAO dao = SAddressDAO.getinstance();
		dao.addressUpdate(dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);
		

	}

}
