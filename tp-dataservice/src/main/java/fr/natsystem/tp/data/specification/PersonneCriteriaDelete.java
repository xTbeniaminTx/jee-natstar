package fr.natsystem.tp.data.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import fr.natsystem.tp.data.models.Personne;

public class PersonneCriteriaDelete {

	public static CriteriaDelete<Personne> getDeletePersonne(
			CriteriaBuilder cb,
			String valeur
			) {
		if (StringUtils.isBlank(valeur) || cb == null) return null;
		
		CriteriaDelete<Personne> criteriaDelete = cb.createCriteriaDelete(Personne.class);
		Root<Personne> root = criteriaDelete.from(Personne.class);
		
		List<Predicate> predicates = new ArrayList<>();
		predicates.add(cb.like(root.get("identite").get("nom"), "%" + valeur + "%"));
		predicates.add(cb.like(root.get("identite").get("prenom"), "%" + valeur + "%"));
		
		Expression<Boolean> expression = cb.or(predicates.toArray(new Predicate[0]));
		
		criteriaDelete.where(expression);
		return criteriaDelete;
	}
	
}