package mcs.p3.tourist.entities;

import java.util.ArrayList;
import java.util.List;

public class ActivityCity {
	private String cityName;
	private List<ActivityDTO> activities;
	
	public ActivityCity() {
		this.activities = new ArrayList<>();
	}
	public ActivityCity(String cityName) {
		this.cityName = cityName;
		this.activities = new ArrayList<>();
	}
	public ActivityCity(String cityName, List<ActivityDTO> dtos) {
		this.cityName = cityName;
		this.activities = dtos;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<ActivityDTO> getActivities() {
		return activities;
	}
	public void setActivities(List<ActivityDTO> activities) {
		this.activities = activities;
	}
	
}
