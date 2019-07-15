package com.napptilus.test.dto.pojo;

import org.springframework.stereotype.Component;

import com.napptilus.test.dto.OompaReducedResponseDto;
import com.napptilus.test.dto.OompaRequestDto;
import com.napptilus.test.dto.OompaResponseDto;
import com.napptilus.test.dto.poji.OompaMapping;
import com.napptilus.test.model.Oompa;

@Component("default")
public class OompaMappingImpl implements OompaMapping {



	@Override
	public OompaReducedResponseDto mapToReducedDto(Oompa oompa) {
		final OompaReducedResponseDto oompaReducedResponseDto = new OompaReducedResponseDto();
		
		if(oompa == null) {
			return oompaReducedResponseDto;
		}
		oompaReducedResponseDto.setAge(oompa.getAge());
		oompaReducedResponseDto.setJob(oompa.getJob());
		oompaReducedResponseDto.setName(oompa.getName());
		
		return oompaReducedResponseDto;
	}

	@Override
	public OompaResponseDto mapToDto(Oompa oompa) {
		final OompaResponseDto oompaResponseDto = new OompaResponseDto();
		
		if(oompa == null) {
			return oompaResponseDto;
		}
		oompaResponseDto.setAge(oompa.getAge());
		oompaResponseDto.setJob(oompa.getJob());
		oompaResponseDto.setName(oompa.getName());
		oompaResponseDto.setId(oompa.getId());
		oompaResponseDto.setDescription(oompa.getDescription());
		oompaResponseDto.setWeight(oompa.getWeight());
		oompaResponseDto.setHeight(oompa.getHeight());
		
		return oompaResponseDto;
	}

	@Override
	public Oompa mapToOompaEntity(OompaRequestDto oompaRequestDto) {
		final Oompa oompa = new Oompa();
		
		if(oompaRequestDto == null) {
			return oompa;
		}
		oompa.setAge(oompaRequestDto.getAge());
		oompa.setJob(oompaRequestDto.getJob());
		oompa.setName(oompaRequestDto.getName());
		oompa.setDescription(oompaRequestDto.getDescription());
		oompa.setWeight(oompaRequestDto.getWeight());
		oompa.setHeight(oompaRequestDto.getHeight());
		
		return oompa;
	}

	
	

}
