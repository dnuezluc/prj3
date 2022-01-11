package mcs.p3.cities.services;

import java.util.List;

import mcs.p3.cities.DTOs.CityDTO;
import mcs.p3.cities.entities.City;
import mcs.p3.cities.entities.Country;

public interface CityService {
	List<CityDTO> getAll();
	CityDTO getById(Long id);
	CityDTO getByName(String name);
	CityDTO save(City c);
	void deleteById(Long id);
	List<CityDTO> getByCountry(Country c);
}
