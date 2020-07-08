package com.friend;

import java.util.ArrayList;

public interface friendDAO {
	// ì¶”ê?
	public void friendInsert(friend f);
	
	// ? „ì²´ë³´ê¸?
	public ArrayList<friend> friendView();
	
	//?ƒ?„¸ë³´ê¸°
	public friend friendDetail(int num);
	
	// ?ˆ˜? •?•˜ê¸?
	public void friendUpdate(friend f);
	
	// ?‚­? œ?•˜ê¸?
	public void friendDelete(int num);
	
	// ê²??ƒ‰?•˜ê¸?
	public ArrayList<friend> friendSearch(String key,String word);
	
	
}
