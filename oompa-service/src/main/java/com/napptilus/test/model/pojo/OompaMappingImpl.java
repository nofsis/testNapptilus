package com.napptilus.test.model.pojo;

import org.springframework.stereotype.Component;

import com.napptilus.test.dto.OompaReducedResponseDto;
import com.napptilus.test.dto.OompaRequestDto;
import com.napptilus.test.dto.OompaResponseDto;
import com.napptilus.test.model.Oompa;
import com.napptilus.test.model.poji.OompaMapping;

@Component("default")
public class OompaMappingImpl implements OompaMapping {



	@Override
	public OompaReducedResponseDto mapToReducedDto(Oompa oompa) {
		OompaReducedResponseDto oompaReducedResponseDto = new OompaReducedResponseDto();
		oompaReducedResponseDto.setAge(oompa.getAge());
		oompaReducedResponseDto.setJob(oompa.getJob());
		oompaReducedResponseDto.setName(oompa.getName());
		return oompaReducedResponseDto;
	}

	@Override
	public OompaResponseDto mapToDto(Oompa oompa) {
		OompaResponseDto oompaResponseDto = new OompaResponseDto();
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
		Oompa oompa = new Oompa();
		oompa.setAge(oompaRequestDto.getAge());
		oompa.setJob(oompaRequestDto.getJob());
		oompa.setName(oompaRequestDto.getName());
		oompa.setDescription(oompaRequestDto.getDescription());
		oompa.setWeight(oompaRequestDto.getWeight());
		oompa.setHeight(oompaRequestDto.getHeight());
		return oompa;
	}

	
	

}
