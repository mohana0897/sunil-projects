package com.ssd.blog.cricketService;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssd.blog.cricketDto.CricketDto;
import com.ssd.blog.cricketRepo.CricketRepository;

@Service
public class CricketService {
	@Autowired
	private CricketRepository repository;
	@Autowired
	private ModelMapper mapper;
	
	
	public List<CricketDto>getAllCricketList(int pageNo,int pageSize,String sortBy,String sortDir){
		
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():
			Sort.by(sortBy).descending();
		List<CricketDto> cricketdtoList=new ArrayList<>();
		Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
		
		repository.findAll(pageable).getContent().forEach(cricket->{
			
			CricketDto dto=mapper.map(cricket, CricketDto.class);
			cricketdtoList.add(dto);
			
		});
		return cricketdtoList;
		
	}
	

}
