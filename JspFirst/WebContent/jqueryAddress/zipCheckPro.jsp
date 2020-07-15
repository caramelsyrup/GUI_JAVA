<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.address.ZipcodeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.address.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  
	// 파싱할때는 데이터만 들어갈수 있도록 한다. 태그가 들어가면 안된다.
	request.setCharacterEncoding("UTF-8");
	String dong = request.getParameter("dong");
//	String dong = "서면";
	// AddressDAO 객체 생성.
	AddressDAO dao = AddressDAO.getInstance();
	// ArrayList 객체생성. 리스트 형은 ZipcodeBean클래스 형.
	ArrayList<ZipcodeBean>arr = dao.zipcodeRead(dong);
	// arr 객체에서 JSON으로 변환해야 데이터를 ajax에서 사용 가능. 라이브러리 json jar 받음.
	JSONArray jarr = new JSONArray();
	// for문을 돌려서 arr배열 전부를 제이슨객체에 넣는다.
	for(ZipcodeBean z: arr){
		JSONObject obj = new JSONObject();
		obj.put("zipcode", z.getZipcode());
		obj.put("sido", z.getSido());
		obj.put("gugun", z.getGugun());
		obj.put("bunji", z.getBunji());
		obj.put("dong", z.getDong());
		jarr.add(obj);
	}
	out.println(jarr.toString());
%>