package mcs.p3.cities.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mcs.p3.cities.DTOs.WeatherDTO;
import mcs.p3.cities.entities.Weather;

@Service
public class MapperWeatherImpl implements IMapperWeather {

	@Override
	public List<WeatherDTO> weathersToWeathersDTO(List<Weather> ws) {
		List<WeatherDTO> dtos = new ArrayList<>();
		ws.forEach(w->{
			dtos.add(new WeatherDTO(w.getId(),w.getName()));
		});
		return dtos;
	}

	@Override
	public WeatherDTO weatherToWheatherDTO(Weather ws) {
		// TODO Auto-generated method stub
		return new WeatherDTO(ws.getId(),ws.getName());
	}
	
	
}
