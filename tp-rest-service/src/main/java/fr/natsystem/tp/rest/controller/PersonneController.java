package fr.natsystem.tp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.services.PersonneDataService;
import fr.natsystem.tp.rest.core.mappings.PersonneMapper;
import fr.natsystem.tp.rest.dto.PersonneDTO;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

	@Autowired
	private PersonneDataService personneDataService;
	
	@Autowired
	private PersonneMapper personneMapper;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonneDTO> getPersonne(
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "anneeNaissance", required = false) Long anneeNaissance) {
		
		List<Personne> liste = personneDataService.getPersonnesParNomEtAnneeNaissance(nom, anneeNaissance);
		
		List<PersonneDTO> result = personneMapper.convertToDtos(liste);
		
		return result;
	}
}
