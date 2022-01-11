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
import mcs.p3.cities.DTOs.CityDTO;
import mcs.p3.cities.entities.City;
import mcs.p3.cities.entities.Country;
import mcs.p3.cities.services.CityService;

@RestController
@RequestMapping("/api/city")
@Api(tags = "City Services")
public class CityController {

	private final CityService service;

	public CityController(CityService service) {
		this.service = service;
	}

	@GetMapping("/getAll")
	@Operation(summary = "Get All Cities", description = "Method to get All Cities")
	public List<CityDTO> getAll() {
		List<CityDTO> dtos = service.getAll();
		dtos.forEach(d-> this.generateLink(d));
		return dtos;
	}

	@GetMapping("/getById/{id}")
	@Operation(summary = "Get Cities by Id", description = "Method to get City its input param id")
	public CityDTO getById(@PathVariable Long id) {
		CityDTO dto = service.getById(id);
		this.generateLink(dto);
		return dto;
	}

	@GetMapping("/getByName/{name}")
	@Operation(summary = "Get City by name", description = "Method to get City by its input param name")
	public CityDTO getByName(@PathVariable String name) {
		CityDTO dto = service.getByName(name);
		this.generateLink(dto);
		return dto;
	}

	@PostMapping("/getByCountry")
	@Operation(summary = "Get Cities by Country", description = "Method to get all Cities in the same Country")
	public List<CityDTO> getByCountry(@RequestBody Country c) {
		List<CityDTO> dtos = service.getByCountry(c);
		dtos.forEach(d-> this.generateLink(d));
		return dtos;
	}

	@PostMapping("/save")
	@Operation(summary = "Save City", description = "Method to save a new City")
	public CityDTO save(@RequestBody City c) {
		CityDTO dto = service.save(c);
		this.generateLink(dto);
		return dto;
	}

	@PostMapping("/update")
	@Operation(summary = "Update City", description = "Method to update a City with the input params")
	public CityDTO update(@RequestBody City c) {
		CityDTO dto = service.save(c);
		this.generateLink(dto);
		return dto;
	}

	@DeleteMapping("/delteById/{id}")
	@Operation(summary = "Delete City", description = "Mehtod to delete a City with its id")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	private void generateLink(CityDTO dto) {
		CityDTO d = WebMvcLinkBuilder.methodOn(CityController.class).getById(dto.getId());
		dto.add(WebMvcLinkBuilder.linkTo(d).withSelfRel());
		dto.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CountryController.class).getById(dto.getCountry().getId()))
				.withRel("contry"));
	}
}
