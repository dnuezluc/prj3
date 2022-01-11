package mcs.p3.cities.controllers;

import java.util.List;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import mcs.p3.cities.DTOs.CountryDTO;
import mcs.p3.cities.entities.Country;
import mcs.p3.cities.services.CountryService;

@RestController
@RequestMapping("/api/countries")
@Api(tags="Countries Services")
public class CountryController {
	private final CountryService service;

	public CountryController(CountryService service) {
		this.service = service;
	}
	
	
	@GetMapping("/getAll")
	@Operation(summary="Get All Countries", description ="Method to get All countries")
	public List<CountryDTO> getAll(){
		List<CountryDTO> dtos = service.getAll();
		dtos.forEach(d-> this.generateLink(d));
		return dtos;
	}
	
	@GetMapping("/getById/{id}")
	@Operation(summary="Get Country by Id", description="Method to get Country with the Id param Input")
	public CountryDTO getById(@PathVariable Long id) {
		CountryDTO dto = service.getById(id);
		this.generateLink(dto);
		return dto;
	}
	
	@GetMapping("/getByName/{name}")
	@Operation(summary="Get Country by Name", description="Method to get Country with its name")
	public CountryDTO getByName(@PathVariable String name) {
		CountryDTO dto = service.getByName(name);
		this.generateLink(dto);
		return dto;
	}
	
	@PostMapping("/save")
	@Operation(summary="Save Country", description="Method to save a new Country")
	public CountryDTO save(@RequestBody Country country) {
		CountryDTO dto = service.save(country);
		this.generateLink(dto);
		return dto;
	}
	
	@PostMapping("/update")
	@Operation(summary="Update Country", description="Method to update a old Country")
	public CountryDTO update(@RequestBody Country c) {
		CountryDTO dto = service.save(c);
		this.generateLink(dto);
		return dto;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@Operation(summary="Delete Country", description="Method to delete a Country")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	private void generateLink(CountryDTO dto) {
		CountryDTO c = WebMvcLinkBuilder.methodOn(CountryController.class).getById(dto.getId());
		dto.add(WebMvcLinkBuilder.linkTo(c).withSelfRel());
	}
}
