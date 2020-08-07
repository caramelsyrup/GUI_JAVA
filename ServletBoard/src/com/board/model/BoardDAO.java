package com.board.model;

import java.util.ArrayList;

public interface BoardDAO {
	// 추가
	public void boardSave(BoardDTO board);
	// 전체보기
	public ArrayList<BoardDTO>boardList();
	// 전체보기 페이징
	public ArrayList<BoardDTO>boardList(int startRow,int endRow);
	// 상세보기
	public BoardDTO boardfindById(int num);
	// 수정
	public void boardUpdate(BoardDTO board);
	// 삭제
	public void boardDelete(int num);
	// 글 개수 세기
	public int boardCount();
	// 댓글 추가
	public void commentInsert(CommentDTO comment);
	// 댓글 전체보기
	public ArrayList<CommentDTO>commentList(int bnum);
}	
