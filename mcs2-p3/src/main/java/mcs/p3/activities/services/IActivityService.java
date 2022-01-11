package mcs.p3.activities.services;

import java.util.List;

import mcs.p3.activities.dtos.ActivityDTO;
import mcs.p3.activities.entities.Activity;
import mcs.p3.activities.entities.Type;

public interface IActivityService {
	public List<ActivityDTO> getAll();
	public ActivityDTO getByID(Long id);
	public ActivityDTO getByName(String name);
	public ActivityDTO save(Activity a);
	public List<ActivityDTO> getByType(Type t);
	public List<ActivityDTO> getByIdCity(Long id);
	public void deleteById(Long id);
}
