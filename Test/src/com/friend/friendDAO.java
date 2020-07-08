package com.friend;

import java.util.ArrayList;

public interface friendDAO {
	// 추�?
	public void friendInsert(friend f);
	
	// ?��체보�?
	public ArrayList<friend> friendView();
	
	//?��?��보기
	public friend friendDetail(int num);
	
	// ?��?��?���?
	public void friendUpdate(friend f);
	
	// ?��?��?���?
	public void friendDelete(int num);
	
	// �??��?���?
	public ArrayList<friend> friendSearch(String key,String word);
	
	
}
