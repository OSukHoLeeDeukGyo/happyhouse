package com.ssafy.vue.mapper;

import java.sql.SQLException;

import com.ssafy.vue.dto.MemberDto;


public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto userInfo(String userid) throws SQLException;
	public MemberDto chkId(String userid);
	public void registerMember(MemberDto memberDto);
	public void updateMember(MemberDto memberDto);
	public int deleteMember(String userid);
}