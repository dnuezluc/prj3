package mcs.p3.cities.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mcs.p3.cities.DTOs.CountryDTO;
import mcs.p3.cities.entities.Country;

@Service
public class MapperCountryImpl implements IMapperCountry {

	@Override
	public List<CountryDTO> CountriesToCountriesDTO(List<Country> countries) {
		List<CountryDTO> dtos = new ArrayList<>();
		countries.forEach(c-> {
			try {
				dtos.add(new CountryDTO(c.getId(),c.getName(),c.getWeather().getName()));
			}catch(Exception ex){
				dtos.add(new CountryDTO(c.getId(),c.getName()));
			}
		});
		return dtos;
	}

	@Override
	public CountryDTO CountryToCountryDTO(Country country) {
		CountryDTO dto;
		try {
			dto = new CountryDTO(country.getId(),country.getName(),country.getWeather().getName());
		}catch(Exception ex){
			dto = new CountryDTO(country.getId(),country.getName());
		}
		
		return dto;
	}

	@Override
	public List<Country> CountriesDTOToCountry(List<CountryDTO> dtos) {
		List<Country> countries = new ArrayList<>();
		dtos.forEach(d->{
			
		});
		return countries;
	}

	@Override
	public Country CountryDTOtoCountry(CountryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
