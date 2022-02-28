package fr.natsystem.tp.data.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Personne;
import fr.natsystem.tp.data.repository.PersonneRepository;
import fr.natsystem.tp.data.specification.PersonneCriteriaDelete;
import fr.natsystem.tp.data.specification.PersonneSpecification;

@Service
public class PersonneDataService {

	private PersonneRepository personneRepository;
	private EntityManager em;

	public PersonneDataService(PersonneRepository personneRepository, EntityManager em) {
		this.personneRepository = personneRepository;
		this.em = em;
	}

	@Transactional
	public int deleteByNomOuPrenom(String valeur) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<Personne> criteriaDelete = PersonneCriteriaDelete.getDeletePersonne(cb, valeur);
		return em.createQuery(criteriaDelete).executeUpdate();
	}
	
	@Transactional
	public List<Personne> getPersonnesParNomEtAnneeNaissance(String nom, Long anneeNaissance) {
		
		Specification<Personne> spec = Specification.where(
				PersonneSpecification.getPersonneAvecNomOuPrenomContenant(nom))
					.and(PersonneSpecification.getPersonneParAnneeNaissance(anneeNaissance));
		
		List<Personne> result = personneRepository.findAll(spec);
		
		return result;
	}

	
	@Transactional
	public Page<Personne> getListePersonnesPaginee(int page, int size) {
		
		final Pageable pageable = PageRequest.of(page, size, Sort.by("identite.nom"));
		Page<Personne> result = personneRepository.findAll(pageable);
		
		return result;
	}
	
	@Transactional
	public Personne createPersonne(Personne personne) {
		
		return personneRepository.save(personne);
	}
}
