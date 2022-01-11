package mcs.p3.cities.services;

import java.util.List;

import mcs.p3.cities.DTOs.CountryDTO;
import mcs.p3.cities.entities.Country;

public interface CountryService {
	List<CountryDTO> getAll();
	CountryDTO getById(Long id);
	CountryDTO getByName(String name);
	CountryDTO save(Country c);
	void deleteById(Long id);
}
