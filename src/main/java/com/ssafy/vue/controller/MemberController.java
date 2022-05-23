package com.ssafy.vue.controller;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.service.JwtServiceImpl;
import com.ssafy.vue.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("MemberController V1")
@RestController
@RequestMapping("/user")
public class MemberController {

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;

	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value = "아이디중복체크", notes = "중복된 아이디가 이미 존재하는지 여부를 반환한다", response = Map.class)
	@GetMapping("/{userid}")
	public ResponseEntity<String> idCheck(@PathVariable String userid) {
		if (memberService.chkId(userid) != null) return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		else return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);
			if (loginUser != null) {
				String token = jwtService.create("userid", loginUser.getUserid(), "access-token");// key, data, subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userid,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				MemberDto memberDto = memberService.userInfo(userid);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원가입요청", notes = "회원가입 요청을 보낸다.", response = Map.class)
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody MemberDto memberDto) throws Exception {
		if (memberDto != null) {
			memberService.registerMember(memberDto);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "개인정보 업데이트요청", notes = "개인정보 업데이트 요청을 보낸다.", response = Map.class)
	@PutMapping("/update")
	public ResponseEntity<String> updateId(@RequestBody MemberDto memberDto) throws Exception {
		if (memberDto != null) {
			memberService.updateMember(memberDto);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "계정 삭제 요청", notes = "계정 삭제 요청을 보낸다.", response = Map.class)
	@PostMapping("/delete")
	public ResponseEntity<String> deleteId(@RequestBody String userid) {
		userid = userid.substring(1, userid.length() - 1);
		logger.debug("로그인 정보 : {}", userid);
		if (memberService.deleteMember(userid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
