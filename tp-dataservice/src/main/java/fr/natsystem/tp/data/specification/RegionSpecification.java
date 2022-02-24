package fr.natsystem.tp.data.specification;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import fr.natsystem.tp.data.models.Region;




public class RegionSpecification {

	public static Specification<Region> getRegionById(Long id) {
		if (id == null)
			return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public static Specification<Region> getRegionByNameContaining(String nom) {
		if (StringUtils.isBlank(nom))
			return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nom"), "%" + nom + "%");
	}
	
}
