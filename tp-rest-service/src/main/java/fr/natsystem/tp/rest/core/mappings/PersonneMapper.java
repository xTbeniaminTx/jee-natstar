package fr.natsystem.tp.rest.core.mappings;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.rest.dto.PersonneDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PersonneMapper {
	PersonneMapper INSTANCE = Mappers.getMapper(PersonneMapper.class);

	@Mapping(source="identite.nom", target="nom")
	@Mapping(source="identite.prenom", target="prenom")
	@Mapping(source="identite.dateNaissance", target="dateNaissance")
	PersonneDTO convertToDto(Personne entity);

	Personne convertToEntity(PersonneDTO dto);
	
	List<PersonneDTO> convertToDtos(List<Personne> entities);
}
