package org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 페이지에서 method가 post, get 어느 것인지 알수 없기에 따로 메소드를 만들어서 처리를 유도.
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
