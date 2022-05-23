package com.ssafy.vue.service;

import com.ssafy.vue.dto.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
	public MemberDto chkId(String userid);
	public void registerMember(MemberDto memberDto);
	public void updateMember(MemberDto memberDto);
	public boolean deleteMember(String userid);
}
