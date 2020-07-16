package com.member;

import java.util.ArrayList;

public interface MemberDAO {
	//추가
	public void memberInsert(MemberVO vo);
	//전체보기
	public ArrayList<MemberVO> memberList();
	//수정
	public void memberUpdate(MemberVO vo);
	//상세보기
	public MemberVO memberDetail(String userID);
	//삭제
	public void memberDelete(String userID);
	//아이디 중복 체크
	public String idCheck(String userID);
}
