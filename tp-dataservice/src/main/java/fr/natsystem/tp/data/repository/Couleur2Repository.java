package fr.natsystem.tp.data.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.natsystem.tp.data.models.Couleur2;

public interface Couleur2Repository  extends JpaRepository<Couleur2, Long>{

	List<Couleur2> findAll(Specification<Couleur2> spec);

}
