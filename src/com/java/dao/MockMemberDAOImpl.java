package com.java.dao;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.java.command.Criteria;
import com.java.dto.MemberVO;

public class MockMemberDAOImpl implements MemberDAO {

	private Map<String, MemberVO> memberMap = new TreeMap<String, MemberVO>();

	{
		for (int i = 0; i < 20; i++) {
			String index = new DecimalFormat("000").format(i);
			MemberVO member = new MemberVO("test" + index, "test" + index);
			memberMap.put(member.getId(), member);

		}

	}

	@Override
	public List<MemberVO> selectMemberList(Criteria cri) throws SQLException {

		List<MemberVO> memberList = new ArrayList<MemberVO>();

		Set<String> keySet = memberMap.keySet();
		if (!keySet.isEmpty())
			for (String key : keySet) {
				memberList.add(memberMap.get(key));
			}

		return memberList;

	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {

		MemberVO member = memberMap.get(id);

		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {

		memberMap.put(member.getId(), member);

	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		memberMap.put(member.getId(), member);
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		memberMap.remove(id);
	}

}
