package org.address.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.address.model.SAddressDAO;
import org.address.model.SAddressDTO;

public class AddressListAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		SAddressDAO sa = SAddressDAO.getinstance();
		int count = sa.addressCount();
		ArrayList<SAddressDTO> arr = sa.addressList();
		req.setAttribute("listArr", arr);
		req.setAttribute("count", count);
		
		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, resp);

	}

}
