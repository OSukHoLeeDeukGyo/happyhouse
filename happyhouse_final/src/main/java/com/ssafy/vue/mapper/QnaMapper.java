package com.ssafy.vue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.Qna;
@Mapper
public interface QnaMapper {
	public List<Qna> selectQna(int page);
	public Qna selectQnaByNo(int articleno);
	public int insertQna(Qna qna);
	public int updateQna(Qna qna);
	public int deleteQna(int articleno);
	
	public int updateReply(Qna qna);
	public int deleteReply(int articleno);
	public List<Qna> searchQna(String searchword);
	public int selectQnaCount();
}