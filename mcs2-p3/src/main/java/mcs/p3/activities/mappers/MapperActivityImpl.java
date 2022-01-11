package mcs.p3.activities.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mcs.p3.activities.dtos.ActivityDTO;
import mcs.p3.activities.entities.Activity;

@Service
public class MapperActivityImpl implements IMapperActivity {
	private final IMapperType mapperType;

	public MapperActivityImpl(IMapperType mapperType) {
		this.mapperType = mapperType;
	}

	@Override
	public List<ActivityDTO> ActivitiesToActivitiesDTO(List<Activity> activities) {
		List<ActivityDTO> dtos = new ArrayList<>();
		if (activities != null && activities.size() > 0) {			
			activities.forEach(a -> {
				if (a.getIdCity() != null && a.getIdCity() != 0)
					dtos.add(new ActivityDTO(a.getId(), a.getIdCity(), a.getName(),
							mapperType.TypeToTypeDTO(a.getType())));
				else
					dtos.add(new ActivityDTO(a.getId(), a.getName(), mapperType.TypeToTypeDTO(a.getType())));
			});
		}
		return dtos;
	}

	@Override
	public ActivityDTO ActivityToActivityDTO(Activity a) {
		// TODO Auto-generated method stub
		if (a.getIdCity() != null && a.getIdCity() != 0)
			return new ActivityDTO(a.getId(), a.getIdCity(), a.getName(), mapperType.TypeToTypeDTO(a.getType()));
		else
			return new ActivityDTO(a.getId(), a.getName(), mapperType.TypeToTypeDTO(a.getType()));
	}

}
