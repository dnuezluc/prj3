package mcs.p3.activities.dtos;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

public class TypeDTO extends RepresentationModel<TypeDTO>{
	private Long id;
	private String name;
	
	public TypeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public TypeDTO() {
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
	
	
	
}
