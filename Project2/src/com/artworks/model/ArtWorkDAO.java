package com.artworks.model;

import java.util.ArrayList;

public interface ArtWorkDAO {
	// 작품 전체 보기
	public ArrayList<ArtWorkDTO> artworkList(int startRow, int endRow);
	// 작품 추가
	public void artworkInsert(ArtWorkDTO art);
	// 작품 상세 보기
	public ArtWorkDTO artworkDetail(int artid);
	// 작품 삭제 하기
	public void artworkDelete(int artid);
	// 작품 전체 개수
	public int artworkCount();
	
}
