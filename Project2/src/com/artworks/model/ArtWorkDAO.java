package com.artworks.model;

import java.util.ArrayList;

public interface ArtWorkDAO {
	// ��ǰ ��ü ����
	public ArrayList<ArtWorkDTO> artworkList();
	// ��ǰ �߰�
	public void artworkInsert(ArtWorkDTO art);
	// ��ǰ �� ����
	public ArtWorkDTO artworkDetail(int artid);
	// ��ǰ ���� �ϱ�
	public void artworkDelete(int artid);
	
}
