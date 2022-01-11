package mcs.p3.activities.dtos;

import org.springframework.hateoas.RepresentationModel;

public class ActivityDTO extends RepresentationModel<ActivityDTO>{
	private Long id;
	private Long idCity;
	private String name;
	private TypeDTO type;
	public ActivityDTO() {

	}
	public ActivityDTO(Long id,Long idCity, String name, TypeDTO type) {
		this.id = id;
		this.setIdCity(idCity);
		this.name = name;
		this.type = type;
	}
	
	public ActivityDTO(Long id,String name, TypeDTO type) {
		this.id = id;
		this.name = name;
		this.type = type;
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
	public TypeDTO getType() {
		return type;
	}
	public void setType(TypeDTO type) {
		this.type = type;
	}
	public Long getIdCity() {
		return idCity;
	}
	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}
	
	
}
