package com.model;

import java.util.ArrayList;

public interface scheduleDAO {
		
		// ��ü����
		public ArrayList<schedule> scheduleView();
		// �󼼺���
		public schedule scheduleDetail(int num);
		// ����� �˻�
		public ArrayList<schedule> departureSearch(String dep,String word);
		// ������ �˻�
		public ArrayList<schedule> arriveSearch(String arrive,String word);
		// �� �˻�
		public ArrayList<schedule> schSearch(String yea,int word);
}