package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.repository.RegionRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class RegionServiceTest {

	@Autowired
	private RegionRepository repo;

	@Test
	public void testSaveRegions() {
		Region region = new Region("Bordeaux");
		Region result = repo.save(region);
		assertNotNull(result);
	}

	@Test
	public void testGetRegions() {
		List<Region> result = repo.findAll();
		assertNotNull(result);
	}

	@Test
	public void testGetRegionsById() {
		Optional<Region> result = repo.findById(42L);
		assertNotNull(result);
	}

	@Test
	public void testGetRegionsByNom() {
		List<Region> result = repo.getAllByNom("Bordeaux");
		assertNotNull(result);
	}

}
