package com.events.model;

import java.util.ArrayList;

public interface EventsDAO {
	// ��� �߰��ϱ�
	public void eventsInsert(EventsDTO event);
	// ��� ��ü����
	public ArrayList<EventsDTO> eventsList();
	// ��� �󼼺���
	public EventsDTO eventsDetail(int eventnum);
	
}
