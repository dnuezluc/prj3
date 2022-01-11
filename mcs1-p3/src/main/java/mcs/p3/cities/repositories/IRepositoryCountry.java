package mcs.p3.cities.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mcs.p3.cities.entities.Country;

@Repository
public interface IRepositoryCountry extends CrudRepository<Country,Long> {
	
	@Query(value="select * from Countries where name = :name", nativeQuery=true)
	public Country getByName(@Param("name") String name);
	
}
