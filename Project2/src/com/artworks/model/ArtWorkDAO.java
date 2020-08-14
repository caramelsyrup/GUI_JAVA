package com.artworks.model;

import java.util.ArrayList;

public interface ArtWorkDAO {
	// ��ǰ ��ü ����
	public ArrayList<ArtWorkDTO> artworkList(int startRow, int endRow);
	// ��ǰ �߰�
	public void artworkInsert(ArtWorkDTO art);
	// ��ǰ �� ����
	public ArtWorkDTO artworkDetail(int artid);
	// ��ǰ ���� �ϱ�
	public void artworkDelete(int artid);
	// ��ǰ ��ü ����
	public int artworkCount();
	
}
