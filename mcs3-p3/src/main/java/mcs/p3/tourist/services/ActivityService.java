package mcs.p3.tourist.services;

import java.util.List;

import mcs.p3.tourist.entities.ActivityDTO;

public interface ActivityService {
	public List<ActivityDTO> getActivityByCity(Long id);
}
