package mcs.p3.tourist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mcs.p3.tourist.entities.ActivityDTO;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@Override
	public List<ActivityDTO> getActivityByCity(Long id) {
		try {
			List<ActivityDTO> activities = restTemplate.getForObject("http://activities-service/api/activity/getByIdCity/"+id,List.class);	
			return activities;

		}catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		return null;
	}
	
	
}
