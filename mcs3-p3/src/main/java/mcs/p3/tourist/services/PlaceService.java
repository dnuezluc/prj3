package mcs.p3.tourist.services;

import java.util.List;

import mcs.p3.tourist.entities.CityDTO;
import mcs.p3.tourist.entities.CountryDTO;

public interface PlaceService {
	public List<CityDTO> getPlaces();
	public List<CountryDTO> getCountries();
}
