package com.ssafy.vue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.Notice;
@Mapper
public interface NoticeMapper {
	public List<Notice> selectNotice();
	public Notice selectNoticeByNo(int articleno);
	public void updateHit(int articleno);
	public int insertNotice(Notice notice);
	public int updateNotice(Notice notice);
	public int deleteNotice(int articleno);
}