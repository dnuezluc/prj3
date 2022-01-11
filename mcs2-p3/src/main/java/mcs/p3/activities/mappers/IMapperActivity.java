package mcs.p3.activities.mappers;

import java.util.List;

import mcs.p3.activities.dtos.ActivityDTO;
import mcs.p3.activities.entities.Activity;

public interface IMapperActivity {
	public List<ActivityDTO> ActivitiesToActivitiesDTO (List<Activity> activities);
	public ActivityDTO ActivityToActivityDTO(Activity a);
}
