package mcs.p3.cities.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mcs.p3.cities.DTOs.CityDTO;
import mcs.p3.cities.entities.City;

@Service
public class MapperCityImpl implements IMapperCity {
	
	private final IMapperCountry mapperC;
	
	public MapperCityImpl(IMapperCountry mapperC) {
		this.mapperC = mapperC;
	}
	
	@Override
	public List<CityDTO> CitiesToCitiesDTO(List<City> cities) {
		List<CityDTO> dtos = new ArrayList<>();
		cities.forEach(c->{
			dtos.add(new CityDTO(c.getId(),c.getName(),mapperC.CountryToCountryDTO(c.getCountry())));
		});
		return dtos;
	}

	@Override
	public CityDTO CityToCityDTO(City city) {
		// TODO Auto-generated method stub
		return new CityDTO(city.getId(),city.getName(),mapperC.CountryToCountryDTO(city.getCountry()));
	}

	@Override
	public List<City> CityDTOToCity(List<CityDTO> dtos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City CityDTOToCity(CityDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
