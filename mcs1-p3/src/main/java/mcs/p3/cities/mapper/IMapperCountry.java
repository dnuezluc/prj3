package mcs.p3.cities.mapper;

import java.util.List;

import mcs.p3.cities.DTOs.CountryDTO;
import mcs.p3.cities.entities.Country;

public interface IMapperCountry {
	public List<CountryDTO> CountriesToCountriesDTO(List<Country> countries);
	public CountryDTO CountryToCountryDTO(Country country);
	public List<Country> CountriesDTOToCountry(List<CountryDTO> dtos);
	public Country CountryDTOtoCountry(CountryDTO dto);
}
