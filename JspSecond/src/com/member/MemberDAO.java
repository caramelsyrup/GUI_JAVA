package com.member;

import java.util.ArrayList;

public interface MemberDAO {
	//�߰�
	public void memberInsert(MemberVO vo);
	//��ü����
	public ArrayList<MemberVO> memberList();
	//����
	public void memberUpdate(MemberVO vo);
	//�󼼺���
	public MemberVO memberDetail(String userID);
	//����
	public void memberDelete(String userID);
	//���̵� �ߺ� üũ
	public String idCheck(String userID);
}
