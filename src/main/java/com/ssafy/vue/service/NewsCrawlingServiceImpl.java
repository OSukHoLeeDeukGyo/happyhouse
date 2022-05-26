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
		
		int chk = 0;
		if (articleList.get(0) != null) {
			while (titleList.get(chk).text().length() == 0) {
				++chk;
			}
			newsList[0] = titleList.get(chk).text();
			newsList[1] = articleList.get(0).text();
			++chk;
		}
		
		if (articleList.get(1) != null) {
			while (titleList.get(chk).text().length() == 0) {
				++chk;
			}
			newsList[2] = titleList.get(chk).text();
			newsList[3] = articleList.get(1).text();
			++chk;
		}
		
		if (articleList.get(2) != null) {
			while (titleList.get(chk).text().length() == 0) {
				++chk;
			}
			newsList[4] = titleList.get(chk).text();
			newsList[5] = articleList.get(2).text();
			++chk;
		}

		return newsList;
	}
}
