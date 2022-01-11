package mcs.p3.cities.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mcs.p3.cities.DTOs.CityDTO;
import mcs.p3.cities.entities.City;
import mcs.p3.cities.entities.Country;
import mcs.p3.cities.mapper.IMapperCity;
import mcs.p3.cities.repositories.IRepositoryCity;

@Service
public class CityServiceImpl implements CityService {
	
	private final IRepositoryCity repository;
	private final IMapperCity mapper;

	public CityServiceImpl(IRepositoryCity repository, IMapperCity mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<CityDTO> getAll() {
		List<City> cities = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(cities::add);
		if(cities==null || cities.size()==0)
		return null;
		else
			return mapper.CitiesToCitiesDTO(cities);
	}

	@Override
	public CityDTO getById(Long id) {
		Optional<City> city = repository.findById(id);
		if(city.isPresent()) return mapper.CityToCityDTO(city.get());
		else return null;
	}

	@Override
	public CityDTO getByName(String name) {
		City c = repository.getCityByName(name);
		if(c!=null) return mapper.CityToCityDTO(c);
		else return null;
	}

	@Override
	public CityDTO save(City c) {
		
		return mapper.CityToCityDTO(repository.save(c));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public List<CityDTO> getByCountry(Country c) {
		List<City> cities = repository.getCitiesByCountry(c);
		//List<City> cities = new ArrayList<>();
		if(cities==null || cities.size()==0) return null;
		else return mapper.CitiesToCitiesDTO(cities);
	}
	
}
