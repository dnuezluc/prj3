package mcs.p3.activities.services;

import java.util.List;

import mcs.p3.activities.dtos.TypeDTO;
import mcs.p3.activities.entities.Type;

public interface ITypeService {
	public List<TypeDTO> getAll();
	public TypeDTO getById(Long id);
	public TypeDTO getByName(String name);
	public TypeDTO save(Type t);
	public void deleteById(Long id);
}
