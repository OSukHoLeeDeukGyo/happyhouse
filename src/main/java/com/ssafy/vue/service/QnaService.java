package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.Qna;

public interface QnaService {
	public List<Qna> retrieveQna();
	public Qna detailQna(int articleno);
	public void updateHit(int articleno);
	public boolean writeQna(Qna qnadto);
	public boolean updateQna(Qna qnadto);
	public boolean deleteQna(int articleno);
	public boolean writeQnaReply(Qna qna);
	public boolean updateQnaReply(Qna qna);
	public boolean deleteQnaReply(int articleno);
}
