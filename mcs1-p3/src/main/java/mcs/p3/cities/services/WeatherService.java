package mcs.p3.cities.services;

import java.util.List;

import mcs.p3.cities.DTOs.WeatherDTO;
import mcs.p3.cities.entities.Weather;

public interface WeatherService {
	List<WeatherDTO> getAll();
	WeatherDTO getById(Long id);
	WeatherDTO save(Weather w);
	void deleteById(Long id);
}
