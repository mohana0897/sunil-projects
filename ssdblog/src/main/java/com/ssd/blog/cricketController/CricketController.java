package com.ssd.blog.cricketController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.blog.cricketDto.CricketDto;
import com.ssd.blog.cricketService.CricketService;

@RestController
@RequestMapping("/cric")
public class CricketController {

//	@Autowired
	private CricketService cricketService;

	@GetMapping("/crickets")
	public ResponseEntity<?> getAllCricketList(
			@RequestParam(value = "pageNo", defaultValue = "2", required = false) int pageNo,

			@RequestParam(value = "pageSize", defaultValue = "4", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {

		return new ResponseEntity<List<CricketDto>>(cricketService.getAllCricketList(pageNo, pageSize, sortBy, sortDir),
				HttpStatus.OK);
		
	}

}
