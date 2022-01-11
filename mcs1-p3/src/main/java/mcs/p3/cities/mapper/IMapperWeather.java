package mcs.p3.cities.mapper;

import java.util.List;

import mcs.p3.cities.DTOs.WeatherDTO;
import mcs.p3.cities.entities.Weather;

public interface IMapperWeather {
	public List<WeatherDTO> weathersToWeathersDTO(List<Weather> ws);
	public WeatherDTO weatherToWheatherDTO(Weather ws);
}
