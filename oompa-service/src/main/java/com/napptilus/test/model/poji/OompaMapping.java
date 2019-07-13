package com.napptilus.test.model.poji;

import com.napptilus.test.dto.OompaReducedResponseDto;
import com.napptilus.test.dto.OompaRequestDto;
import com.napptilus.test.dto.OompaResponseDto;
import com.napptilus.test.model.Oompa;

public interface OompaMapping {
	
	
	public OompaReducedResponseDto mapToReducedDto(Oompa oompa);
	
	
	public OompaResponseDto mapToDto(Oompa oompa);
	
	
	public Oompa mapToOompaEntity(OompaRequestDto oompaRequestDto);
	
	
	

}
