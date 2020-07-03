package com.model;

import java.util.ArrayList;

public interface memberDAO {
	
	// ����,������ ���� �׸�
	// �߰�
	public void memberInsert(member m);
	// ����
	public void memberUpdate(member m);
	
	// ������ �׸�
	public void memberDelete(int num);
	// ��ü����
	public ArrayList<member> memberView();
	// �󼼺���
	public member memberDetail(int num);
	// �˻��ϱ�
	public ArrayList<member> memberSearch(String key,String word);
	
	
}