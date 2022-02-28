package fr.natsystem.tp.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.natsystem.tp.data.embedded.IdentitePk;
import fr.natsystem.tp.data.exception.ForbiddenException;
import fr.natsystem.tp.data.exception.ValidationEntityException;
import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.services.PersonneDataService;
import fr.natsystem.tp.data.services.ValidationService;
import fr.natsystem.tp.rest.core.mappings.PersonneMapper;
import fr.natsystem.tp.rest.dto.PersonneDTO;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

	@Autowired
	private PersonneDataService personneDataService;
	
	@Autowired
	private PersonneMapper personneMapper;
	
	@Autowired
	private ValidationService validator;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonneDTO> getPersonne(
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "anneeNaissance", required = false) Long anneeNaissance) {
		
		List<Personne> liste = personneDataService.getPersonnesParNomEtAnneeNaissance(nom, anneeNaissance);
		
		List<PersonneDTO> result = personneMapper.convertToDtos(liste);
		
		return result;
	}
	

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonneDTO postPersonne(
			@RequestHeader("NomUtilisateur") String nomUtilisateur,
			@RequestBody PersonneDTO dto) throws ValidationEntityException, ForbiddenException {

		if (!"admin".equals(nomUtilisateur)) 
			throw new ForbiddenException("Privilège insuffisant pour cette action",
					"PersonneController.postPersonne",
					"Vous n'avez pas les autorisations nécessaires");
		
		validator.checkConstraints(dto, "", "PersonneController.postPersonne");
		
		IdentitePk identite = new IdentitePk();
		identite.setNom(dto.getNom());
		identite.setPrenom(dto.getPrenom());
		identite.setDateNaissance(dto.getDateNaissance());
				
		
		Personne personne = new Personne();
		personne.setIdentite(identite);
		personne.setId(dto.getId());
		
		Personne result = personneDataService.createPersonne(personne);
		
		return personneMapper.convertToDto(result);
	}
}
