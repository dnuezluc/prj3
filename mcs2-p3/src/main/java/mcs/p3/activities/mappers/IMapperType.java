package mcs.p3.activities.mappers;

import java.util.List;

import mcs.p3.activities.dtos.TypeDTO;
import mcs.p3.activities.entities.Type;

public interface IMapperType {
	public List<TypeDTO> TypesToTypesDTO(List<Type> types);
	public TypeDTO TypeToTypeDTO(Type t);
}
