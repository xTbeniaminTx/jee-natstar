package fr.natsystem.tp.data.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.natsystem.tp.data.embedded.IdentitePk;
import fr.natsystem.tp.data.models.Personne;

public interface PersonneRepository extends JpaRepository<Personne, IdentitePk> {

	List<Personne> findAll(Specification<Personne> spec);
	
	List<Personne> findAll(Specification<Personne> spec, Pageable pageable);
	
}
