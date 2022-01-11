package mcs.p3.activities.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mcs.p3.activities.entities.Activity;
import mcs.p3.activities.entities.Type;

@Repository
public interface IRepositoryActivity extends CrudRepository<Activity,Long> {
	@Query(value="select * from Activities where name = :name",nativeQuery = true)
	public Activity getByName(@Param("name") String name);
	
	@Query("Select a from Activity a where a.type LIKE :type")
	public List<Activity> getByType (@Param("type") Type type);
	
	@Query(value="select * from Activities where City_id= :idCity",nativeQuery = true)
	public List<Activity> getByIdCity(@Param("idCity") Long idCity);
}
