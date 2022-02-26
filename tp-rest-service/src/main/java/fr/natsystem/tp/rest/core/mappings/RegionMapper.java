package fr.natsystem.tp.rest.core.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.rest.dto.RegionDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RegionMapper {
	
	RegionMapper INSTANCE = Mappers.getMapper(RegionMapper.class);
	
	RegionDTO comvertToRegionDTO(Region entityRegion);
	Region comvertToEntity(RegionDTO regionDTO);

}
