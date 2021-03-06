package org.addrMy.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.addMy.config.MybatisManager;
import org.addrMy.model.AddressVO;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;

/**
 * Servlet implementation class DeleteAjaxAction
 */
@WebServlet("/address/deleteAjaxAction.amy")
public class DeleteAjaxAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAjaxAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		SqlSessionFactory sqlMapper = MybatisManager.getSqlMapper();
		SqlSession sqlsession = sqlMapper.openSession(ExecutorType.REUSE);
		
		try {
			// 삭제를 먼저 진행.
		sqlsession.delete("deleteAjaxData",num);
		sqlsession.commit();
		// 전체 리스트를 뽑는다.
		List<AddressVO> arr = sqlsession.selectList("listData");
		// 리스트 객체를 담을 map객체 선언.
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 리스트 객체를 담는다. map객체에
		map.put("list", arr);
		
		// 갯수도 가져가라
		int count = sqlsession.selectOne("countData");
		map.put("count",count);
		
		//gson 객체 생성.
		Gson gson = new Gson();
		// obj에 map객체를 gson을 이용하여 Json형태로 바꿈.
		String obj = gson.toJson(map);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		
		}finally {
			sqlsession.clearCache();
			sqlsession.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
