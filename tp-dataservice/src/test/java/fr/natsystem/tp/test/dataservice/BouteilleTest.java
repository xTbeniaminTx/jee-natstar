package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.natsystem.tp.data.models.Bouteille;

import fr.natsystem.tp.data.services.BouteilleDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class BouteilleTest {

	
	@Autowired
	private BouteilleDataService bDataService;
	
	@Test
	public void testJointure() {
		List<Bouteille> result = bDataService.getParNomRegion("Bordeaux");
		assertNotNull(result);
	}

}
