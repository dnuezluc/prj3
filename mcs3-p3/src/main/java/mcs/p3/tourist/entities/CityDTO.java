package mcs.p3.tourist.entities;

public class CityDTO {
	private Long id;
	private String name;
	private CountryDTO country;
	public CityDTO(Long id, String name, CountryDTO country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}
	public CityDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
}
