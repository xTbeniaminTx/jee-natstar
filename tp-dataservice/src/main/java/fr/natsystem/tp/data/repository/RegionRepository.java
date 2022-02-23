package fr.natsystem.tp.data.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.natsystem.tp.data.models.Region;

public interface RegionRepository extends JpaRepository<Region, Long>, Serializable {
	
	@Query(value = "SELECT r from Region r WHERE r.nom = :nom")
	List<Region> getAllByNom(@Param("nom") String nom);

}
