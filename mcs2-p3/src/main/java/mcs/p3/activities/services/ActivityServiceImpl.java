package mcs.p3.activities.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mcs.p3.activities.dtos.ActivityDTO;
import mcs.p3.activities.entities.Activity;
import mcs.p3.activities.entities.Type;
import mcs.p3.activities.mappers.IMapperActivity;
import mcs.p3.activities.repositories.IRepositoryActivity;

@Service
public class ActivityServiceImpl implements IActivityService {

	private final IRepositoryActivity repository;
	private final IMapperActivity mapper;

	public ActivityServiceImpl(IRepositoryActivity repository, IMapperActivity mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<ActivityDTO> getAll() {
		List<Activity> activities = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(activities::add);
		
		if (activities != null && activities.size() > 0)
			return mapper.ActivitiesToActivitiesDTO(activities);		
		else
			return null;
	}

	@Override
	public ActivityDTO getByID(Long id) {
		Optional<Activity> activity = repository.findById(id);
		if (activity.isPresent())
			return mapper.ActivityToActivityDTO(activity.get());
		else
			return null;
	}

	@Override
	public ActivityDTO getByName(String name) {
		Activity activity = repository.getByName(name);
		if (activity != null)
			return mapper.ActivityToActivityDTO(activity);
		else
			return null;
	}

	@Override
	public ActivityDTO save(Activity a) {

		return mapper.ActivityToActivityDTO(repository.save(a));
	}

	@Override
	public List<ActivityDTO> getByType(Type t) {
		// TODO Auto-generated method stub
		List<Activity> activities = repository.getByType(t);
		if (activities != null && activities.size() > 0)
			return mapper.ActivitiesToActivitiesDTO(activities);
		else
			return null;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<ActivityDTO> getByIdCity(Long id) {
		List<Activity> activities = new ArrayList<>();
		repository.getByIdCity(id).iterator().forEachRemaining(activities::add);
		if (activities != null && activities.size() > 0)
			return mapper.ActivitiesToActivitiesDTO(activities);
		else
			return null;
	}

}
