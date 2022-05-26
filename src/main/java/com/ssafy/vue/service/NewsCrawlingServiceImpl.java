package com.ssafy.vue.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NewsCrawlingServiceImpl implements NewsCrawlingService {
	
	public static final Logger logger = LoggerFactory.getLogger(NewsCrawlingServiceImpl.class);
	
	@Override
	public String[] crawling() throws IOException {
		String url = "https://land.naver.com/news/breaking.naver";
		Document doc = Jsoup.connect(url).get();
		
		Elements titleList = doc.select(".live_list dt");
		Elements articleList = doc.select(".live_list dd");
		String[] newsList = new String[6];

		System.out.println("------------------------");
		System.out.println("타이틀" + titleList.get(1).text());
		System.out.println("내용" + articleList.get(0).text());
		System.out.println("------------------------");
		System.out.println("타이틀" + titleList.get(2).text());
		System.out.println("내용" + articleList.get(1).text());
		
		newsList[0] = titleList.get(1).text();
		newsList[1] = articleList.get(0).text();
		newsList[2] = titleList.get(3).text();
		newsList[3] = articleList.get(1).text();
		newsList[4] = titleList.get(5).text();
		newsList[5] = articleList.get(2).text();

		return newsList;
	}
}
