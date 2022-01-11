package mcs.p3.tourist.entities;

public class ActivityDTO {
	private Long id;
	private String name;
	private TypeDTO type;
	public ActivityDTO() {
	}
	public ActivityDTO(Long id, String name, TypeDTO type) {
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
	
}
