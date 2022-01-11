package mcs.p3.cities.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mcs.p3.cities.DTOs.CountryDTO;
import mcs.p3.cities.entities.Country;
import mcs.p3.cities.mapper.IMapperCountry;
import mcs.p3.cities.repositories.IRepositoryCountry;

@Service
public class CountryServiceImpl implements CountryService {
	
	private final IRepositoryCountry repository;
	private final IMapperCountry mapper;
	
	public CountryServiceImpl(IRepositoryCountry repository, IMapperCountry mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<CountryDTO> getAll() {
		List<Country> countries = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(countries::add);
		if(countries==null || countries.size()==0) {
			return null;
		}else {
			return mapper.CountriesToCountriesDTO(countries);
		}
	}

	@Override
	public CountryDTO getById(Long id) {
		Optional<Country> country = repository.findById(id);
		if(country.isPresent())
			return mapper.CountryToCountryDTO(country.get());
		else return null;
	}

	@Override
	public CountryDTO getByName(String name) {
		Country country = repository.getByName(name);
		if(country!=null)
			return mapper.CountryToCountryDTO(country);
		else return null;
	}

	@Override
	public CountryDTO save(Country c) {
		
		return mapper.CountryToCountryDTO(repository.save(c));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}

}
