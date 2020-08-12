package com.artworks.model;

import java.util.ArrayList;

public interface ArtWorkDAO {
	// 작품 전체 보기
	public ArrayList<ArtWorkDTO> artworkList();
	// 작품 추가
	public void artworkInsert(ArtWorkDTO art);
}
