package fr.natsystem.tp.data.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private PersonneRepository personneRepository;
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	public List<Personne> getPersonnesParNomEtDateNaissance(String nom, Long anneeNaissance) {

		Specification<Personne> spec = Specification
				.where(PersonneSpecification.getPersonneAvecNomOuPrenomContenant(nom))
				.and(PersonneSpecification.getPersonneParAnneeNaissance(anneeNaissance));

		List<Personne> result = personneRepository.findAll(spec);

		return result;
	}
	
	@Transactional
	public int deleteByNomOuPrenom(String valeur) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Personne> criteriaDelete = PersonneCriteriaDelete.getdeletePersonne(criteriaBuilder, valeur);
		
		return entityManager.createQuery(criteriaDelete).executeUpdate();
	
	}


	@Transactional
	public Page<Personne> getListePersonnesPaginee(int page, int size) {

		final Pageable pageable = PageRequest.of(page, size, Sort.by("identite.nom"));
		Page<Personne> result = personneRepository.findAll(pageable);

		return result;

	}
}
