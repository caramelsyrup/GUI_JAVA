package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	// ȸ�� �߰�
	public void memberInsert(MemberDTO vo);
	// ȸ�� ���� ����
	public int memberUpdate(MemberDTO vo);
	// ȸ�� ���� �󼼺��� - �Ϲ�ȸ��
	public MemberDTO memberDetail(String userID);
	// ȸ�� ���� �󼼺��� - ������ 
	public MemberDTO memberDetail(int usernum);
	//����
	public void memberDelete(String userID);
	//���̵� �ߺ� üũ
	public String idCheck(String userID);
	// �α��� �Ǵ�
	public int loginCheck(String userID, String userPwd );
	//��ü����
	public ArrayList<MemberDTO> memberList();
	// �ּҰ˻�
	public ArrayList<AddressDTO> addressSearch(String addr);
	
}
