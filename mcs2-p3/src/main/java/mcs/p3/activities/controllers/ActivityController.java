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
import mcs.p3.activities.dtos.ActivityDTO;
import mcs.p3.activities.entities.Type;
import mcs.p3.activities.entities.Activity;
import mcs.p3.activities.services.IActivityService;

@RestController
@RequestMapping("/api/activity")
@Api(tags = "Activity Service")
public class ActivityController {
	private final IActivityService service;

	public ActivityController(IActivityService service) {
		this.service = service;

	}

	@GetMapping("/getAll")
	@Operation(summary = "Get All Activity", description = "Method to get all activities in data base")
	public List<ActivityDTO> getAll() {

		List<ActivityDTO> dtos = service.getAll();
		dtos.forEach(d -> this.getLinks(d));

		return dtos;
	}

	@GetMapping("/getById/{id}")
	@Operation(summary = "Get by Id", description = "Method to get an activity with its id in data base")
	public ActivityDTO getById(@PathVariable Long id) {
		ActivityDTO a = service.getByID(id);
		if (a != null)
			this.getLinks(a);
		return a;
	}

	@GetMapping("/getByName/{name}")
	@Operation(summary = "Get by Name", description = "Method to get an activity with its name")
	public ActivityDTO getByName(@PathVariable String name) {
		ActivityDTO a = service.getByName(name);
		if (a != null)
			this.getLinks(a);
		return a;
	}

	@GetMapping("/getByIdCity/{idCity}")
	@Operation(summary = "Get Activities by City", description = "Method to get all activities in the same city")
	public List<ActivityDTO> getByIdCity(@PathVariable Long idCity) {
		List<ActivityDTO> dtos = service.getByIdCity(idCity);
		dtos.forEach(d -> this.getLinks(d));
		return dtos;
	}

	@PostMapping("/getByType")
	@Operation(summary = "Get by Type", description = "Method to get a activities list with the same type")
	public List<ActivityDTO> getByType(@RequestBody Type t) {
		List<ActivityDTO> dtos = service.getByType(t);
		dtos.forEach(d -> this.getLinks(d));
		return dtos; 
	}

	@PostMapping("/save")
	@Operation(summary = "Save a new Activity", description = "Method to save a new activity in data base")
	public ActivityDTO save(@RequestBody Activity a) {
		ActivityDTO ac = service.save(a);
		if (ac != null)
			this.getLinks(ac);
		return ac;
	}

	@PostMapping("/update")
	@Operation(summary = "Update an activity", description = "Method to update a old Activity")
	public ActivityDTO update(@RequestBody Activity a) {
		ActivityDTO ac = service.save(a);
		if (ac != null)
			this.getLinks(ac);
		return ac;
	}

	@DeleteMapping("/deleteById/{id}")
	@Operation(summary = "Delete By Id", description = "Delete an activity with its id")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	private void getLinks(ActivityDTO dto) {
		ActivityDTO a = WebMvcLinkBuilder.methodOn(ActivityController.class).getById(dto.getId());
		dto.add(WebMvcLinkBuilder.linkTo(a).withSelfRel());
		dto.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(TypeController.class).getById(dto.getType().getId())).withRel("TypeActivity"));
	}
}
