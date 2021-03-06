package fr.natsystem.tp.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.services.RegionDataService;
import fr.natsystem.tp.rest.core.mappings.RegionMapper;
import fr.natsystem.tp.rest.dto.RegionDTO;

@RestController
@RequestMapping("/regions")
public class RegionController {
	
	@Autowired
	RegionDataService regionDataService;
	
	@Autowired
	RegionMapper regionMapper;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO getRegion() {
		
		RegionDTO result = new RegionDTO();
		result.setId(100L);
		result.setNom("Alsace");
		
		return result;
		
	} 
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO createRegion(@RequestBody RegionDTO dto) {
		
		
		Region region = new Region();
		
		region.setNom(dto.getNom());
		
		regionDataService.saveRegion(region);
		
		return dto;
		
	} 
	
	
	@PutMapping(path="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RegionDTO updateTodo(@PathVariable("id") Long id, @RequestBody RegionDTO dto ) {
		
		Optional<Region> region = regionDataService.getRegionById(id);
		
		region.get().setNom(dto.getNom());
		
		regionDataService.updateRegion(id, region.get().getNom());
		
		return dto;
    
    }
	
	@GetMapping(path="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO getRegionById(@PathVariable("id") Long id) {
		
		Optional<Region> region = regionDataService.getRegionById(id);
		
		if (region != null) {
			RegionDTO result = new RegionDTO();
			result.setId(region.get().getId());
			result.setNom(region.get().getNom());
			
			return result;
		}
		return null;
	
		
	} 
	
	@DeleteMapping(path="/{id}" )
	public void deleteRegionById(@PathVariable("id") Long id) {
		
		 regionDataService.deleteRegion(id);
			
	} 

}
