package fr.natsystem.tp.data.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.repository.PersonneRepository;
import fr.natsystem.tp.data.specification.PersonneSpecification;

@Service
public class PersonneDataService {

	@Autowired
	private PersonneRepository personneRepository;

	@Transactional
	public List<Personne> getPersonnesParNomEtDateNaissance(String nom, Long anneeNaissance) {

		Specification<Personne> spec = Specification
				.where(PersonneSpecification.getPersonneAvecNomOuPrenomContenant(nom))
				.and(PersonneSpecification.getPersonneParAnneeNaissance(anneeNaissance));

		List<Personne> result = personneRepository.findAll(spec);

		return result;
	}

}
