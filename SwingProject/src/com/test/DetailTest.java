package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.model.friend;
import com.model.friendDAOImpl;

// 메서드를 하나씩 만들고 난후 즉시 테스트를 해보는 과정.

public class DetailTest {
	friendDAOImpl dao = new friendDAOImpl();
	
	
	// 해당 메소드가 정의되어 있지 않음.
	@Test
	public void detailFriend() {
//		assertEquals("aaaa", dao.friendDetail(1).getName());
	}
/*	
	@Test
	public void friendInsert() {
		friend f = new friend();
		f.setAddr("addrtest");
		f.setBirth("202020");
		f.setName("asdfg");
		f.setNum(20);
		f.setPhone("asdasd");
		dao.friendInsert(f);
	}
*/	
	@Test
	public void friendDelete() {
		dao.friendDelete(22);
	}
	
	
}
