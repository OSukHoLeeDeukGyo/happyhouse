package com.ssafy.vue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return memberMapper.login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return memberMapper.userInfo(userid);
	}

	@Override
	public MemberDto chkId(String userid) {
		// TODO Auto-generated method stub
		return memberMapper.chkId(userid);
	}

	@Override
	public void registerMember(MemberDto memberDto) {
		memberMapper.registerMember(memberDto);
		return;
	}

	@Override
	public void updateMember(MemberDto memberDto) {
		memberMapper.updateMember(memberDto);
	}

	@Override
	public boolean deleteMember(String userid) {
		return memberMapper.deleteMember(userid) == 1;
	}
}
