package mcs.p3.cities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mcs.p3.cities.entities.City;
import mcs.p3.cities.entities.Country;

@Repository
public interface IRepositoryCity extends CrudRepository<City,Long>{
	
	@Query(value="select * from Cities where name = :name", nativeQuery=true)
	public City getCityByName(@Param("name") String name);
	
	
	@Query("Select c from City c where c.country LIKE :country")
	public List<City> getCitiesByCountry(@Param("country") Country country);
	
}
