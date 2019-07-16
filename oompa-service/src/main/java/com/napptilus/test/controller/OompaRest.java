package com.napptilus.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.ws.http.HTTPException;

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

import springfox.documentation.service.ResponseMessage;

@RestController
@RequestMapping("/oompas")
public class OompaRest {

	@Autowired
	private OompaRepository oompaRespository;

	@Autowired
	@Qualifier("default")
	private OompaMapping oompaMappingImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getOompas() {
		// Getting oompas from DB
		try {
			final List<Oompa> oompas = oompaRespository.findAll();

			final List<OompaReducedResponseDto> oompaReducedResponseDto = oompas.stream()
					.map(oompa -> this.oompaMappingImpl.mapToReducedDto(oompa)).collect(Collectors.toList());

			return Response.status(Status.OK).entity(oompaReducedResponseDto).build();

		} catch (HTTPException e) {

			return Response.status(e.getStatusCode()).entity(e.getMessage()).build();

		}

	}

	@RequestMapping(value = "/{oompaId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response getOompa(@PathVariable("oompaId") int oompaId) {
		try {
			Oompa oompa = this.oompaRespository.getOne(oompaId);
			OompaResponseDto oompaResponseDto = this.oompaMappingImpl.mapToDto(oompa);
			return Response.status(Status.OK).entity(oompaResponseDto).build();
		} catch (HTTPException e) {

			return Response.status(e.getStatusCode()).entity(e.getMessage()).build();

		}

	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response putOompa(@RequestBody OompaRequestDto request) {
		try {
			this.oompaRespository.save(this.oompaMappingImpl.mapToOompaEntity(request));
			return Response.status(Status.CREATED).build();
		} catch (HTTPException e) {
			return Response.status(e.getStatusCode()).entity(e.getMessage()).build();

		}

	}

	@RequestMapping(value = "/{oompaId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response editOompa(@RequestBody OompaRequestDto request, @PathVariable("oompaId") int oompaId) {

		try {
			final Oompa oompa = this.oompaMappingImpl.mapToOompaEntity(request);
			oompa.setId(oompaId);
			this.oompaRespository.save(oompa);
			return Response.status(Status.OK).build();
		} catch (HTTPException e) {
			return Response.status(e.getStatusCode()).entity(e.getMessage()).build();
		}

	}

}
