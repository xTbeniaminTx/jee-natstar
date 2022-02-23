package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Bouteille;
import fr.natsystem.tp.data.models.Couleur;
import fr.natsystem.tp.data.models.Region;
import fr.natsystem.tp.data.repository.BouteilleRepository;
import fr.natsystem.tp.data.repository.CouleurRepository;
import fr.natsystem.tp.data.repository.RegionRepository;
import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")

public class SaveRegionTest {
	
	@Autowired
	private RegionRepository repo;
	
	@Autowired
	private BouteilleRepository repoB;
	
	@Autowired
	private CouleurRepository repoC;
	
	@Test
	public void test01() {
		var name = 10;
		
		var nameu = 15;
		
		System.out.println("coucou");
		
		var toot = name + nameu;
		
	
		
		assertEquals(25, toot);
	}
	
	@Test
	public void test02() {
		var name = 10;
		
		var nameu = 10;
		
		var toot = name + nameu;
		
	
		
		assertEquals(20, toot);
	}
	
	@Test
	public void testRegion() {
		Region region = new Region("Bordeaux");
		
		repo.save(region);
		
		assertNotNull(region);
	}
	
	@Test
	public void testCouleur() {
		Couleur c = new Couleur("rouge","oui");
		
		repoC.save(c);
		
		assertNotNull(c);
	}
	
	@Test
	public void testBoutteile() {
		Region region = new Region("Bordeaux");
		repo.save(region);
		Bouteille b = new Bouteille("Cabernet");
		
		b.setRegionRf(region);
		
		repoB.save(b);
		
		
		assertNotNull(b);
	}
	

	@Test
	public void testRegionGet() {
		
		
		List<Region> reg = repo.findAll();
		
		for (Region region : reg) {
			System.out.println(region);
		}
		
		String nomR = repo.findById((long) 15).get().getNom();
		
		assertEquals("Bordeaux", nomR);
		
	}
	
	@Test
	public void testRegiongetByNom() {
		
		
		List<Region> reg = repo.getAllByNom("Bordeaux");
		
		for (Region region : reg) {
			System.out.println(region);
		}
		
		String nomR = repo.findById((long) 15).get().getNom();
		
		assertEquals("Bordeaux", nomR);
		
	}
	

}
