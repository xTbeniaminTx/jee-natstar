package fr.natsystem.tp.rest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.rest.dto.RegionDTO;

@RestController
@RequestMapping("/regions")
public class RegionController {
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public RegionDTO getRegion() {
		RegionDTO result = new RegionDTO();
		result.setId(100L);
		result.setNom("Alsace");
		
		return result;
		
	} 

}
