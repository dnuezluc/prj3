package mcs.p3.activities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Activities")
public class Activity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="City_id")
	private Long idCity;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_type")
	private Type type;

	public Activity(Long idCity, String name, Type type) {
		this.setIdCity(idCity);
		this.name = name;
		this.type = type;
	}
	
	
	public Activity(String name, Type type) {
		this.name = name;
		this.type = type;
	}


	public Activity() {
		
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	public Long getIdCity() {
		return idCity;
	}


	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}
	
	
	
}
