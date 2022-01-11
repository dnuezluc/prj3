package mcs.p3.activities.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mcs.p3.activities.dtos.TypeDTO;
import mcs.p3.activities.entities.Type;

@Service
public class MapperTypeImpl implements IMapperType {

	@Override
	public List<TypeDTO> TypesToTypesDTO(List<Type> types) {
		List<TypeDTO> dtos = new ArrayList<>();
		if(types!=null && types.size()>0) {
			types.forEach(t-> dtos.add(new TypeDTO(t.getId(),t.getName())));
		}
		return dtos;
	}

	@Override
	public TypeDTO TypeToTypeDTO(Type t) {
		// TODO Auto-generated method stub
		return new TypeDTO(t.getId(),t.getName());
	}
	
}
