package mcs.p3.cities.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mcs.p3.cities.DTOs.WeatherDTO;
import mcs.p3.cities.entities.Weather;
import mcs.p3.cities.mapper.IMapperWeather;
import mcs.p3.cities.repositories.IRepositoryWeather;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	private final IRepositoryWeather repository;
	private final IMapperWeather mapper;	
	
	public WeatherServiceImpl(IRepositoryWeather repository, IMapperWeather mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<WeatherDTO> getAll() {
		List<Weather> weathers = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(weathers::add);
		if(weathers == null || weathers.size()==0) return null;
		else return mapper.weathersToWeathersDTO(weathers);
	}

	@Override
	public WeatherDTO getById(Long id) {
		Optional<Weather> w = repository.findById(id);
		if(w.isPresent()) return mapper.weatherToWheatherDTO(w.get());
		else return null;
	}

	@Override
	public WeatherDTO save(Weather w) {		
		return mapper.weatherToWheatherDTO(repository.save(w));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
