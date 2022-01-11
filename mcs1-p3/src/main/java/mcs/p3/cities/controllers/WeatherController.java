package mcs.p3.cities.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import mcs.p3.cities.DTOs.WeatherDTO;
import mcs.p3.cities.services.WeatherService;

@RestController
@RequestMapping("/api/weather")
@Api(tags="Weather Service")
public class WeatherController {
	
	private final WeatherService service;

	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	
	@GetMapping("/getAll")
	@Operation(summary="Get all Weather", description = "Method to get all weather")
	public List<WeatherDTO> getAll(){
		return service.getAll();
	}
	
}
