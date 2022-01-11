package mcs.p3.cities.mapper;

import java.util.List;

import mcs.p3.cities.DTOs.CityDTO;
import mcs.p3.cities.entities.City;

public interface IMapperCity {
	public List<CityDTO> CitiesToCitiesDTO(List<City> cities);
	public CityDTO CityToCityDTO(City city);
	public List<City> CityDTOToCity(List<CityDTO> dtos);
	public City CityDTOToCity(CityDTO dto);
}
