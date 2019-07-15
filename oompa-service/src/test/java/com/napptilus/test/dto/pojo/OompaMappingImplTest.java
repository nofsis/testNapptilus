package com.napptilus.test.dto.pojo;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.napptilus.test.dto.OompaReducedResponseDto;
import com.napptilus.test.dto.OompaRequestDto;
import com.napptilus.test.dto.OompaResponseDto;
import com.napptilus.test.model.Oompa;

@RunWith(value = MockitoJUnitRunner.class)
public class OompaMappingImplTest {
	
	@InjectMocks
	private OompaMappingImpl oompaMapping ;
	
	@Mock
	private OompaResponseDto oompaResponse;
	
	@Mock
	private OompaRequestDto oompaRequest;
	
	@Mock
	private OompaReducedResponseDto oompaResponseReducedDto;
	
	@Mock
	private Oompa oompa;
	
	
	@Before
	public void init() {

		
		
	}
	
	@Test
	public void when_oompaRequestDto_is_null_should_return_new_object_with_null_attributes() {
		
		Oompa oompa = this.oompaMapping.mapToOompaEntity(null);
		
		assertTrue(oompa.getAge() == 0);
		assertTrue(oompa.getJob() == null);
		assertTrue(oompa.getDescription() == null);
		assertTrue(oompa.getName() == null);
		assertTrue(oompa.getHeight() == 0.0);
		assertTrue(oompa.getWeight() == 0.0);
		
		
	}
	
	@Test
	public void should_return_same_value_attributes_oompaRequestDto() {
		
		
		
		Mockito.when(this.oompaRequest.getAge()).thenReturn(2);
		Mockito.when(this.oompaRequest.getDescription()).thenReturn("Super Oompa");
		Mockito.when(this.oompaRequest.getHeight()).thenReturn(5.5);
		Mockito.when(this.oompaRequest.getWeight()).thenReturn(6.3);
		Mockito.when(this.oompaRequest.getJob()).thenReturn("Super Job");
		Mockito.when(this.oompaRequest.getName()).thenReturn("Name");
		
		
		Oompa oompa = this.oompaMapping.mapToOompaEntity(this.oompaRequest);
		
		
		assertTrue(oompa.getAge() == 2);
		assertTrue(oompa.getJob().equals("Super Job"));
		assertTrue(oompa.getDescription().equals("Super Oompa"));
		assertTrue(oompa.getName().equals("Name"));
		assertTrue(oompa.getHeight() == 5.5);
		assertTrue(oompa.getWeight() == 6.3);
		
		
	}
	
	@Test
	public void when_oompa_is_null_should_return_new_oompaReducedResponseDto_with_null_attributes() {
		
		OompaReducedResponseDto oompaReducedResponseDto = this.oompaMapping.mapToReducedDto(null);
		
		assertTrue(oompaReducedResponseDto.getAge() == 0);
		assertTrue(oompaReducedResponseDto.getJob() == null);
		assertTrue(oompaReducedResponseDto.getName() == null);

		
	}
	
	@Test
	public void should_return_same_value_attributes_oompa() {
		
		
		
		Mockito.when(this.oompa.getAge()).thenReturn(2);
		Mockito.when(this.oompa.getJob()).thenReturn("Super Job");
		Mockito.when(this.oompa.getName()).thenReturn("Name");
		
		
		OompaReducedResponseDto oompa = this.oompaMapping.mapToReducedDto(this.oompa);
		
		
		assertTrue(oompa.getAge() == 2);
		assertTrue(oompa.getJob().equals("Super Job"));
		assertTrue(oompa.getName().equals("Name"));
		
		
	}
	
	@Test
	public void when_oompa_is_null_should_return_new_oompaResponseDto_with_null_attributes() {
		
		OompaReducedResponseDto oompaResponseDto = this.oompaMapping.mapToReducedDto(null);
		
		assertTrue(oompaResponseDto.getAge() == 0);
		assertTrue(oompaResponseDto.getJob() == null);
		assertTrue(oompaResponseDto.getName() == null);

		
	}
	
	@Test
	public void should_return_same_value_attributes_oompa2() {
		
		
		
		Mockito.when(this.oompa.getAge()).thenReturn(2);
		Mockito.when(this.oompa.getDescription()).thenReturn("Super Oompa");
		Mockito.when(this.oompa.getHeight()).thenReturn(5.5);
		Mockito.when(this.oompa.getWeight()).thenReturn(6.3);
		Mockito.when(this.oompa.getJob()).thenReturn("Super Job");
		Mockito.when(this.oompa.getName()).thenReturn("Name");
		
		
		OompaResponseDto oompa = this.oompaMapping.mapToDto(this.oompa);
		
		
		assertTrue(oompa.getAge() == 2);
		assertTrue(oompa.getJob().equals("Super Job"));
		assertTrue(oompa.getDescription().equals("Super Oompa"));
		assertTrue(oompa.getName().equals("Name"));
		assertTrue(oompa.getHeight() == 5.5);
		assertTrue(oompa.getWeight() == 6.3);
		
		
	}
	


}
