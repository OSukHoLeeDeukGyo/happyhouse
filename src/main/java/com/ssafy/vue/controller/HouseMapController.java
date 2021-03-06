package com.ssafy.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.HouseDealDto;
import com.ssafy.vue.dto.HouseInfoDto;
import com.ssafy.vue.dto.SidoGugunCodeDto;
import com.ssafy.vue.service.HouseMapService;

@RestController
@RequestMapping("/map")
@CrossOrigin("*")
public class HouseMapController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService haHouseMapService;
	
	
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
		logger.debug("gugun : {}", haHouseMapService.getGugunInSido(sido));
		//System.out.println("sido: "+ sido);
		return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/guApt")
	public ResponseEntity<List<HouseInfoDto>> guApt(@RequestParam("gu") String gugun) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInGu(gugun), HttpStatus.OK);
	}	
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(dong), HttpStatus.OK);
	}
	
	@GetMapping("/aptDeals")
	public ResponseEntity<List<HouseDealDto>> aptDeals(@RequestParam("aptCode") String aptCode) throws Exception {
		return new ResponseEntity<List<HouseDealDto>>(haHouseMapService.getAptDeals(aptCode), HttpStatus.OK);
	}
	
	@GetMapping("/aptDealsYearly")
	public ResponseEntity<List<HouseDealDto>> aptDealsYearly(@RequestParam("aptCode") String aptCode) throws Exception {
		return new ResponseEntity<List<HouseDealDto>>(haHouseMapService.getAptDealsYearly(aptCode), HttpStatus.OK);
	}
	
	@GetMapping("/aptDetail")
	public ResponseEntity<HouseInfoDto> aptDetail(@RequestParam("aptCode") String aptCode) throws Exception {
		return new ResponseEntity<HouseInfoDto>(haHouseMapService.getAptDetail(aptCode), HttpStatus.OK);
	}
	
}
