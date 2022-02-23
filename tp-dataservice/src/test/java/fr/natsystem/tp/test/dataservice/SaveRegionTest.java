package fr.natsystem.tp.test.dataservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/")

public class SaveRegionTest {
	
	@Test
	public void test01() {
		var name = 10;
		
		var nameu = 15;
		
		System.out.println("coucou");
		
		var toot = name + nameu;
		
	
		
		assertEquals(20, toot);
	}
	
	@Test
	public void test02() {
		var name = 10;
		
		var nameu = 10;
		
		var toot = name + nameu;
		
	
		
		assertEquals(20, toot);
	}
	

}
