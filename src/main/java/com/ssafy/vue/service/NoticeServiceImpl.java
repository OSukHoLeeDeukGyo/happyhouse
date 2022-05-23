package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dto.Notice;
import com.ssafy.vue.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	
    @Autowired
	private NoticeMapper noticeMapper;

    @Override
	public List<Notice> retrieveNotice() {
    	System.out.println("test");
    	System.out.println(noticeMapper.selectNotice());
		return noticeMapper.selectNotice();
	}
    
  	@Override
	public boolean writeNotice(Notice notice) {
		return noticeMapper.insertNotice(notice) == 1;
	}

	@Override
	public Notice detailNotice(int articleno) {
		return noticeMapper.selectNoticeByNo(articleno);
	}
	
	@Override
	public void updateHit(int articleno) {
		noticeMapper.updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean updateNotice(Notice notice) {
		return noticeMapper.updateNotice(notice) == 1;
	}

	@Override
	@Transactional
	public boolean deleteNotice(int articleno) {
		return noticeMapper.deleteNotice(articleno) == 1;
	}
}