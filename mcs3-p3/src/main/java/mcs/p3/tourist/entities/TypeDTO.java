package mcs.p3.tourist.entities;

public class TypeDTO {
	private Long id;
	private String name;
	public TypeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public TypeDTO() {
	
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
	
}
