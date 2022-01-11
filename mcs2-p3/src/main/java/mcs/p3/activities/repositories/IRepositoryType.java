package mcs.p3.activities.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mcs.p3.activities.entities.Type;

@Repository
public interface IRepositoryType extends CrudRepository<Type,Long> {
	
	@Query(value="select * from Types where name = :name", nativeQuery=true)
	public Type getTypeByName(@Param("name") String name);
}
