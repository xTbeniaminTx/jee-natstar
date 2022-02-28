package fr.natsystem.tp.rest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.data.embedded.IdentitePk;
import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.services.PersonneDataService;
import fr.natsystem.tp.rest.core.mappings.PersonneMapper;
import fr.natsystem.tp.rest.dto.PersonneDTO;
import fr.natsystem.tp.rest.dto.RegionDTO;

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
	

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PersonneDTO createPersonne(@RequestBody PersonneDTO dto) {
		
		IdentitePk identite = new IdentitePk();
		identite.setNom(dto.getNom());
		identite.setPrenom(dto.getPrenom());
		identite.setDateNaissance(dto.getDateNaissance());
		
		
		Personne personne = new Personne();
		
		personne.setIdentite(identite);
		personne.setId(dto.getId());
		
		personneDataService.createPersonne(personne);
		

		return personneMapper.convertToDto(personne);
		
	} 
}
