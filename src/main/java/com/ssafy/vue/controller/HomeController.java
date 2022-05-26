package com.ssafy.vue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.service.NewsCrawlingService;

@RestController
@RequestMapping("/home")
@CrossOrigin("*")
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private NewsCrawlingService newsCrawlingService;
	
	@GetMapping("/news")
	public ResponseEntity<String[]> newsCrawling() throws Exception {
		return new ResponseEntity<String[]>(newsCrawlingService.crawling(), HttpStatus.OK);
	}
}
