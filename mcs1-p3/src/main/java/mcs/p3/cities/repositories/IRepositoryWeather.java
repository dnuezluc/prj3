package mcs.p3.cities.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mcs.p3.cities.entities.Weather;

@Repository
public interface IRepositoryWeather extends CrudRepository<Weather,Long> {
	
}
