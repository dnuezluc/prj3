package mcs.p3.activities.controllers;

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
import mcs.p3.activities.dtos.TypeDTO;
import mcs.p3.activities.entities.Type;
import mcs.p3.activities.services.ITypeService;

@RestController
@RequestMapping("/api/type")
@Api(tags="Type Service")
public class TypeController {
	private final ITypeService service;

	public TypeController(ITypeService service) {
		this.service = service;
	}
	
	@GetMapping("/getAll")
	@Operation(summary="Get all Types", description="Method to get all Type activities in data base")
	public List<TypeDTO> getAll(){
		List<TypeDTO> dtos = service.getAll();
		if(dtos!=null)
			dtos.forEach(d-> this.generateLink(d));
		return dtos;
	}
	
	@GetMapping("/getById/{id}")
	@Operation(summary="Get By Id", description="Method to get type activity by its id")
	public TypeDTO getById(@PathVariable Long id) {
		TypeDTO dto = service.getById(id);
		if(dto!=null) this.generateLink(dto);
		return dto;
	}
	
	@GetMapping("/getByName/{name}")
	@Operation(summary="Get by Name", description="method to get type activity by name")
	public TypeDTO getByName(@PathVariable String name) {
		TypeDTO dto = service.getByName(name);
		if(dto!=null)
			this.generateLink(dto);
		return dto;
	}
	
	@PostMapping("/save")
	@Operation(summary="Save a new Type", description="Method to save a new type activity in database")
	public TypeDTO save(@RequestBody Type t) {
		TypeDTO dto = service.save(t);
		if(dto!=null) this.generateLink(dto);
		return dto;
	}
	
	@PostMapping("/update")
	@Operation(summary="Update a Type", description="Method to update a old type activity")
	public TypeDTO update(@RequestBody Type t) {
		TypeDTO dto = service.save(t);
		if(dto !=null) this.generateLink(dto);
		return dto;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@Operation(summary="Delete By Id", description="Method to delete a type activity with its Id")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	private void generateLink(TypeDTO dto) {
		TypeDTO t = WebMvcLinkBuilder.methodOn(TypeController.class).getById(dto.getId());
		dto.add(WebMvcLinkBuilder.linkTo(t).withSelfRel());
	}
	
}
