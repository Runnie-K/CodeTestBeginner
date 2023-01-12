package com.java.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.java.command.Criteria;
import com.java.dto.MemberVO;
import com.java.service.MemberServiceImpl;

public class TestMemberServiceImpl {

	private MemberServiceImpl memberService = new MemberServiceImpl();

	@Before
	public void init() {
//		memberService.setMemberDAO(new MockMemberDAOImpl());
		memberService.setMemberDAO(new MemberDAOImpl());
	}

	@Test
	public void testGetMemberList() throws Exception {
		Criteria cri = new Criteria();
		cri.setKeyword("");
		cri.setSearchType("");

		List<MemberVO> memberList = memberService.getMemberList(cri);
		System.out.println(memberList);
		Assert.assertEquals(12, memberList.size());

	}

	@Test
	public void testGetMember() throws Exception {
		String targetId = "mimi";
		MemberVO member = memberService.getMember(targetId);
		System.out.println(member);
		Assert.assertEquals(member.getId(), targetId);
	}

	@Test
	public void testCRUDMember() throws Exception {
		MemberVO targetMember = new MemberVO("target", "target");

		memberService.regist(targetMember);
		MemberVO returnMember = memberService.getMember(targetMember.getId());
		System.out.println("regist: " + returnMember);
		Assert.assertEquals(targetMember.getId(), returnMember.getId());

		returnMember.setName("tatata");
		memberService.modify(returnMember);
		MemberVO updateMember = memberService.getMember(returnMember.getId());
		System.out.println("update: " + updateMember);
		Assert.assertEquals(updateMember.getName(), returnMember.getName());

		memberService.remove(returnMember.getId());
		MemberVO removeMember = memberService.getMember(returnMember.getId());
		System.out.println("remove: " + removeMember);
		Assert.assertNull(removeMember);
		;
	}

}
