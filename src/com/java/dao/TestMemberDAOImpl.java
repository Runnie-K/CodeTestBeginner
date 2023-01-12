package com.java.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.java.command.Criteria;
import com.java.dto.MemberVO;



public class TestMemberDAOImpl {

	private MemberDAO memberDAO = new MemberDAOImpl();
		
	@Test
	public void testSelectMemberList() throws Exception{
		
		Criteria cri = new Criteria();
		cri.setKeyword("mimi");
		cri.setSearchType("i");
		
		List<MemberVO> memberList = memberDAO.selectMemberList(cri);
		
		Assert.assertEquals(1, memberList.size());
		System.out.println(memberList);
	}
	

}






