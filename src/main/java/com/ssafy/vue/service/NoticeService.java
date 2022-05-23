package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.Notice;

public interface NoticeService {
	public List<Notice> retrieveNotice();
	public Notice detailNotice(int articleno);
	public void updateHit(int articleno);
	public boolean writeNotice(Notice noticedto);
	public boolean updateNotice(Notice noticedto);
	public boolean deleteNotice(int articleno);
}
