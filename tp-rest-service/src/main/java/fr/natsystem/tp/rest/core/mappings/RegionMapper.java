package fr.natsystem.tp.rest.core.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.rest.dto.RegionDTO;
import fr.natsystem.tp.rest.dto.RegionDTO2;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegionMapper {
	RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);

	RegionDTO convertToDto(Region entity);
	Region convertToEntity(RegionDTO dto);
	
	@Mapping(source="nom", target="nomRegion")
	RegionDTO2 convertToDto2(Region entity);
	
	@Mapping(source="nomRegion", target="nom")
	Region convertToEntity2(RegionDTO2 dto);
	
}