package com.board.model;

import java.util.ArrayList;

public interface BoardDAO {
	// �߰�
	public void boardSave(BoardDTO board);
	// ��ü����
	public ArrayList<BoardDTO>boardList();
	// ��ü���� ����¡
	public ArrayList<BoardDTO>boardList(int startRow,int endRow);
	// �󼼺���
	public BoardDTO boardfindById(int num);
	// ����
	public void boardUpdate(BoardDTO board);
	// ����
	public void boardDelete(int num);
	// �� ���� ����
	public int boardCount();
	// ��� �߰�
	public void commentInsert(CommentDTO comment);
	// ��� ��ü����
	public ArrayList<CommentDTO>commentList(int bnum);
}	
