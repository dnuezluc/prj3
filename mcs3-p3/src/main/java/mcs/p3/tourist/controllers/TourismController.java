package mcs.p3.tourist.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import mcs.p3.tourist.entities.ActivityCity;
import mcs.p3.tourist.entities.ActivityDTO;
import mcs.p3.tourist.entities.CityDTO;
import mcs.p3.tourist.services.ActivityService;
import mcs.p3.tourist.services.PlaceService;

@RestController
@RequestMapping("/api/tourism")
@Api(tags = "Tourism Service API")
public class TourismController {
	private final PlaceService service;
	private final ActivityService service2;

	public TourismController(PlaceService service, ActivityService service2) {
		this.service = service;
		this.service2 = service2;
	}

	@GetMapping("/getPlaces")
	@Operation(summary = "Get all places", description = "Method to get all places with information about its country")
	public List<CityDTO> getPlaces() {
		return service.getPlaces();
	}

	@GetMapping("/getAllActivities")
	@Operation(summary = "Get all Activities By Cities", description = "Method to get all activities by cities")
	public List<ActivityCity> getActivitiesByCity() {

		List<CityDTO> cities = service.getPlaces();
		List<ActivityCity> dtos = new ArrayList<>();
		if (cities != null && cities.size() > 0) {
			cities.forEach(c -> {
				ActivityCity aC = new ActivityCity(c.getName());
				try {
					aC.setActivities(service2.getActivityByCity(c.getId()));
				} catch (Exception e) {
					System.out.println("Without activities fot this city");
				}
				dtos.add(aC);
			});
			return dtos;
		} else {
			return null;
		}
	}
}
