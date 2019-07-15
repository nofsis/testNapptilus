package com.napptilus.test.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.napptilus.test.dto.OompaReducedResponseDto;
import com.napptilus.test.dto.OompaRequestDto;
import com.napptilus.test.dto.OompaResponseDto;
import com.napptilus.test.dto.poji.OompaMapping;
import com.napptilus.test.model.Oompa;
import com.napptilus.test.repository.OompaRepository;

@RestController
@RequestMapping("/oompas")
public class OompaRest {
	
	@Autowired
	private OompaRepository oompaRespository;
	
	@Autowired
	@Qualifier("default")
	private OompaMapping oompaMappingImpl;
	
	
	@RequestMapping(value="/", 
            method=RequestMethod.GET, 
            produces=MediaType.APPLICATION_JSON_VALUE)
	public List<OompaReducedResponseDto> getOompas(){
		//Getting oompas from DB
		final List<Oompa> oompas = oompaRespository.findAll();
		
		return oompas.stream().map(oompa -> this.oompaMappingImpl.mapToReducedDto(oompa)
			).collect(Collectors.toList());
		
	}
	
	@RequestMapping(value="/{oompaId}", 
            method=RequestMethod.GET, 
            produces=MediaType.APPLICATION_JSON_VALUE)
	public OompaResponseDto getOompa(@PathVariable("oompaId") int oompaId) {
		
		return this.oompaMappingImpl.mapToDto(this.oompaRespository.getOne(oompaId)) ;
		
	}
	
	@RequestMapping(
            method=RequestMethod.POST, 
            produces=MediaType.APPLICATION_JSON_VALUE)
	public void putOompa(@RequestBody OompaRequestDto request) {
		
		this.oompaRespository.save(this.oompaMappingImpl.mapToOompaEntity(request));
		
		
		
	}
	
	@RequestMapping(value= "/{oompaId}",
            method=RequestMethod.PUT, 
            produces=MediaType.APPLICATION_JSON_VALUE)
	public void editOompa(@RequestBody OompaRequestDto request,@PathVariable("oompaId") int oompaId) {
		final Oompa oompa = this.oompaMappingImpl.mapToOompaEntity(request);
		oompa.setId(oompaId);
		this.oompaRespository.save(oompa);
		
		
		
	}

}
