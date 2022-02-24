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

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.repository.RegionRepository;
import fr.natsystem.tp.data.specification.RegionCriteriaUpdate;
import fr.natsystem.tp.data.specification.RegionSpecification;

@Service
public class RegionDataService implements Serializable {
	private static final long serialVersionUID = -2276139062930532654L;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public Region saveRegion(Region region) {
		return regionRepository.save(region);
	}

	@Transactional
	public int updateRegion(Long id, String nom) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Region> criteriaUpdate = RegionCriteriaUpdate.getUpdateNomById(criteriaBuilder, id, nom);

		return entityManager.createQuery(criteriaUpdate).executeUpdate();
	}

	@Transactional
	public List<Region> getRegionsPourUnId(Long id, String nom) {

		Specification<Region> spec = Specification.where(RegionSpecification.getRegionById(id))
				.or(RegionSpecification.getRegionByNameContaining(nom));

		List<Region> result = regionRepository.findAll(spec);

		return result;
	}
}
