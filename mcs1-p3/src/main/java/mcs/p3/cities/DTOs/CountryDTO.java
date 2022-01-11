package mcs.p3.cities.DTOs;

import org.springframework.hateoas.RepresentationModel;

public class CountryDTO extends RepresentationModel<CountryDTO> {
	private Long id;
	private String name;	
	private String weather;	
	
	public CountryDTO() {
		// TODO Auto-generated constructor stub
	}
	public CountryDTO(Long id, String name, String weather) {
		this.id = id;
		this.name = name;
		this.weather = weather;
	}
	public CountryDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	
}
