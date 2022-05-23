package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.Qna;
import com.ssafy.vue.service.QnaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private QnaService qnaService;

	@ApiOperation(value = "qna 개수 반환.", response = List.class)
	@GetMapping
	public ResponseEntity<Integer> selectQnaCount() throws Exception {
		logger.debug("retrieveQna - 호출");
		
		return new ResponseEntity<Integer>(qnaService.selectQnaCount(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "모든 qna의 정보를 반환한다.", response = List.class)
	@GetMapping("{page}")
	public ResponseEntity<List<Qna>> retrieveQna(@PathVariable int page) throws Exception {
		logger.debug("retrieveQna - 호출");
		
		page-=1;
		
		if( page>=1) {
			page*=10;
		}
		return new ResponseEntity<List<Qna>>(qnaService.retrieveQna(page), HttpStatus.OK);
	}

	@ApiOperation(value = "글번호에 해당하는 qna의 정보를 반환한다.", response = Qna.class)
	@GetMapping("/getdetail/{articleno}")
	public ResponseEntity<Qna> detailQna(@PathVariable int articleno) {
		logger.debug("detailQna - 호출");
		return new ResponseEntity<Qna>(qnaService.detailQna(articleno), HttpStatus.OK);
	}

	@ApiOperation(value = "유저가 qna를 작성. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeQna(@RequestBody Qna qna) {
		logger.debug("writeQna - 호출");
		if (qnaService.writeQna(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "유저가 글번호에 해당하는 qna의 질문글을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{articleno}")
	public ResponseEntity<String> updateQna(@RequestBody Qna qna) {
		logger.debug("updateQna - 호출");
		logger.debug("" + qna);

		if (qnaService.updateQna(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "유저가 글번호에 해당하는 qna를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteQna(@PathVariable int articleno) {
		logger.debug("deleteQna - 호출");
		if (qnaService.deleteQna(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "관리자가 글번호에 해당하는 qna의 답변을 등록,수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/admin/{articleno}")
	public ResponseEntity<String> updateReply(@RequestBody Qna qna) {
		logger.debug("updateQna - 호출");
		logger.debug("" + qna);

		if (qnaService.updateReply(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "관리자가 글번호에 해당하는 답변을 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/admin/{articleno}")
	public ResponseEntity<String> deleteReply(@PathVariable int articleno) {
		logger.debug("deleteQna - 호출");
		if (qnaService.deleteReply(articleno)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "qna 검색", response = List.class)
	@GetMapping("/search/{searchword}")
	public ResponseEntity<List<Qna>> searchQna(@PathVariable String searchword) throws Exception {
		logger.debug("searchQna - 호출");
		return new ResponseEntity<List<Qna>>(qnaService.searchQna(searchword), HttpStatus.OK);
	}
}