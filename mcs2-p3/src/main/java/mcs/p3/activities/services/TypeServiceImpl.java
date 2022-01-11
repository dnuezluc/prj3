package mcs.p3.activities.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mcs.p3.activities.dtos.TypeDTO;
import mcs.p3.activities.entities.Type;
import mcs.p3.activities.mappers.IMapperType;
import mcs.p3.activities.repositories.IRepositoryType;

@Service
public class TypeServiceImpl implements ITypeService {
	
	private final IRepositoryType repository;
	private final IMapperType mapper;
	
	public TypeServiceImpl(IRepositoryType repository, IMapperType mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	@Override
	public List<TypeDTO> getAll() {
		List<Type> types = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(types::add);
		if(types!=null && types.size()>0) return mapper.TypesToTypesDTO(types);
		else return null;
	}

	@Override
	public TypeDTO getById(Long id) {
		// TODO Auto-generated method stub
		Optional<Type> type = repository.findById(id);
		if(type.isPresent()) return mapper.TypeToTypeDTO(type.get());
		else return null;
	}

	@Override
	public TypeDTO getByName(String name) {
		Type type = repository.getTypeByName(name);
		if(type!=null) return mapper.TypeToTypeDTO(type);
		else return null;
	}

	@Override
	public TypeDTO save(Type t) {
		// TODO Auto-generated method stub
		return mapper.TypeToTypeDTO(repository.save(t));
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
