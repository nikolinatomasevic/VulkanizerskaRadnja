package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;
	
	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Marka i model 1");
		ag.setPrecnik(17);
		ag.setSirina(170);
		ag.setVisina(27);
		
		radnja.dodajGumu(ag);
		
		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(ag, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuViseGuma() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Marka i model 1");
		ag1.setPrecnik(17);
		ag1.setSirina(170);
		ag1.setVisina(27);
		
		radnja.dodajGumu(ag1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Marka i model 2");
		ag2.setPrecnik(18);
		ag2.setSirina(171);
		ag2.setVisina(28);
		
		radnja.dodajGumu(ag2);
		
		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(ag1));
		assertTrue(radnja.vratiSveGume().contains(ag2));
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Marka i model 1");
		ag1.setPrecnik(17);
		ag1.setSirina(170);
		ag1.setVisina(27);
		
		radnja.dodajGumu(ag1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Marka i model 1");
		ag2.setPrecnik(17);
		ag2.setSirina(170);
		ag2.setVisina(27);
		
		assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(ag2));
	}
	
	@Test
	void testPronadjiGumuNijedanRezultat() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Marka i model 1");
		ag1.setPrecnik(17);
		ag1.setSirina(170);
		ag1.setVisina(27);
		
		radnja.dodajGumu(ag1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Marka i model 2");
		ag2.setPrecnik(18);
		ag2.setSirina(171);
		ag2.setVisina(28);
		
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("Marka i model 3");
		
		assertEquals(0, rezultat.size());
	}
	
	@Test
	void testPronadjiGumuJedanRezultat() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Marka i model 1");
		ag1.setPrecnik(17);
		ag1.setSirina(170);
		ag1.setVisina(27);
		
		radnja.dodajGumu(ag1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Marka i model 2");
		ag2.setPrecnik(18);
		ag2.setSirina(171);
		ag2.setVisina(28);
		
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("Marka i model 2");
		
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(ag2));
	}
	
	@Test
	void testPronadjiGumuViseRezultata() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Marka i model 1");
		ag1.setPrecnik(17);
		ag1.setSirina(170);
		ag1.setVisina(27);
		
		radnja.dodajGumu(ag1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Marka i model 1");
		ag2.setPrecnik(18);
		ag2.setSirina(171);
		ag2.setVisina(28);
		
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("Marka i model 1");
		
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(ag1));
		assertTrue(rezultat.contains(ag2));
	}
	
	@Test
	void testPronadjiGumuMarkaModelNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}

	@Test
	void testVratiSveGume() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Marka i model 1");
		ag.setPrecnik(17);
		ag.setSirina(170);
		ag.setVisina(27);
		
		radnja.dodajGumu(ag);
		
		assertEquals(1, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(ag));
	}

}
