package mcs.p3.tourist.entities;

import java.util.ArrayList;
import java.util.List;

public class Tourism {
	private List<CityDTO> cities;
	private ActivityCity data;
	public Tourism(ActivityCity data) {
		this.cities = new ArrayList<>();
		this.data = data;
	}
	public Tourism(List<CityDTO> cities, ActivityCity data) {
		this.cities = cities;
		this.data = data;
	}
	public Tourism() {
		this.cities = new ArrayList<>();
	}
	public List<CityDTO> getCities() {
		return cities;
	}
	public void setCities(List<CityDTO> cities) {
		this.cities = cities;
	}
	public ActivityCity getData() {
		return data;
	}
	public void setData(ActivityCity data) {
		this.data = data;
	}
	
}
