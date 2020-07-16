<%@page import="com.jqueryAddress.Address"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.jqueryAddress.ZipcodeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jqueryAddress.JAddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  
	// 파싱할때는 데이터만 들어갈수 있도록 한다. 태그가 들어가면 안된다.
	request.setCharacterEncoding("UTF-8");
	String word = request.getParameter("word");
	String field = request.getParameter("field");
//	String dong = "서면";
	// AddressDAO 객체 생성.
	JAddressDAO dao = JAddressDAO.getInstance();
	// ArrayList 객체생성. 리스트 형은 ZipcodeBean클래스 형.
	ArrayList<Address>arr = dao.addressList(field, word);
	// arr 객체에서 JSON으로 변환해야 데이터를 ajax에서 사용 가능. 라이브러리 json jar 받음.
	JSONArray jarr = new JSONArray();
	// for문을 돌려서 arr배열 전부를 제이슨객체에 넣는다.
	for(Address a: arr){
		JSONObject obj = new JSONObject();
		obj.put("num", a.getNum());
		obj.put("name", a.getName());
		obj.put("address", a.getAddress());
		obj.put("zipcode", a.getZipcode());
		obj.put("tel", a.getTel());
		jarr.add(obj);
	}
	out.println(jarr.toString());
%>