package mcs.p3.tourist.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mcs.p3.tourist.entities.CityDTO;
import mcs.p3.tourist.entities.CountryDTO;

@Service
public class PlaceServiceImpl implements PlaceService{
	
	@Autowired
	@LoadBalanced
	private RestTemplate restemplate;
	
	@Override
	public List<CityDTO> getPlaces() {
		// TODO Auto-generated method stub
		try {
			//List<CityDTO> cities = restemplate.getForObject("http://cities-service/api/city/getAll", List.class);
			CityDTO[] cities = restemplate.getForObject("http://cities-service/api/city/getAll", CityDTO[].class);
			return Arrays.asList(cities);
		}catch(Exception ex) {
			System.out.println("Exception: " +ex.getMessage());
		}
		return null;
		
	}

	@Override
	public List<CountryDTO> getCountries() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
