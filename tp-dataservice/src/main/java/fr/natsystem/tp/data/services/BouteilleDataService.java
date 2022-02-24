package fr.natsystem.tp.data.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import fr.natsystem.tp.data.models.Bouteille;
import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.repository.BouteilleRepository;
import fr.natsystem.tp.data.repository.RegionRepository;
import fr.natsystem.tp.data.specification.BouteilleSpecification;
import fr.natsystem.tp.data.specification.RegionCriteriaUpdate;
import fr.natsystem.tp.data.specification.RegionSpecification;

@Service
public class BouteilleDataService implements Serializable {
	private static final long serialVersionUID = -2276139062930532654L;

	@Autowired
	private BouteilleRepository bouteilleRepository;

	@Transactional
	public Bouteille saveCouleur(Bouteille bouteille) {
		return bouteilleRepository.save(bouteille);
	}

	@Transactional
	public List<Bouteille> getParNomRegion(String nom) {

		Specification<Bouteille> spec = Specification.where(BouteilleSpecification.getBouteilleParNomRegion(nom));
	
		List<Bouteille> result = bouteilleRepository.findAll(spec);

		return result;
	}
}
