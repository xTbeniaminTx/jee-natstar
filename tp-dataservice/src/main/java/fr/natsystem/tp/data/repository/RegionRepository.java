package fr.natsystem.tp.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.natsystem.tp.data.models.Region;

public interface RegionRepository extends JpaRepository<Region, Long>, Serializable {

}
