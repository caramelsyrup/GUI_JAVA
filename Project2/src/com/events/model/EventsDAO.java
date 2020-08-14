package com.events.model;

import java.util.ArrayList;

public interface EventsDAO {
	// 행사 추가하기
	public void eventsInsert(EventsDTO event);
	// 행사 전체보기
	public ArrayList<EventsDTO> eventsList();
	// 행사 상세보기
	public EventsDTO eventsDetail(int eventnum);
	
}
