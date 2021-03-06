package com.model;

import java.util.ArrayList;

public interface friendDAO {
	// 추가
	public void friendInsert(friend f);
	
	// 전체보기
	public ArrayList<friend> friendView();
	
	//상세보기
	public friend friendDetail(int num);
	
	// 수정하기
	public void friendUpdate(friend f);
	
	// 삭제하기
	public void friendDelete(int num);
	
	// 검색하기
	public ArrayList<friend> friendSearch(String key,String word);
	
	
}
