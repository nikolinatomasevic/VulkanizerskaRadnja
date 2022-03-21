package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;
	
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		assertEquals(null, ag.getMarkaModel());
		assertEquals(-1, ag.getPrecnik());
		assertEquals(-1, ag.getSirina());
		assertEquals(-1, ag.getVisina());
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Marka i model 1", 17, 170, 27);
		
		assertEquals("Marka i model 1", ag.getMarkaModel());
		assertEquals(17, ag.getPrecnik());
		assertEquals(170, ag.getSirina());
		assertEquals(27, ag.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Marka i model 3");
		
		assertEquals("Marka i model 3", ag.getMarkaModel());
	}
	
	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelManjeOdTriZnaka() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setMarkaModel("M1"));
	}

	@ParameterizedTest
	@CsvSource({
		"13", "17", "22"
	})
	void testSetPrecnikDozvoljeno(int precnik) {
		ag.setPrecnik(precnik);
		
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({
		"5", "12", "23"
	})
	void testSetPrecnikNedozvoljenoGreskaUIfUslovu(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setPrecnik(precnik));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1", "12", "25"
	})
	void testSetPrecnikNedozvoljeno(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setPrecnik(precnik));
	}

	@ParameterizedTest
	@CsvSource({
		"135", "200", "355"
	})
	void testSetSirinaDozvoljeno(int sirina) {
		ag.setSirina(sirina);
		
		assertEquals(sirina, ag.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"50", "134", "356"
	})
	void testSetSirinaNedozvoljenoGreskaUIfUslovu(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setSirina(sirina));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1", "134", "400"
	})
	void testSetSirinaNedozvoljeno(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setSirina(sirina));
	}

	@ParameterizedTest
	@CsvSource({
		"25", "27", "90"
	})
	void testSetVisinaDozvoljeno(int visina) {
		ag.setVisina(visina);
		
		assertEquals(visina, ag.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"17", "14", "96"
	})
	void testSetVisinaNedozvoljeno(int visina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setVisina(visina));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Marka i model 1");
		ag.setPrecnik(17);
		ag.setSirina(170);
		ag.setVisina(27);
		
		String s = ag.toString();
		
		assertTrue(s.contains("Marka i model 1"));
		assertTrue(s.contains("17"));
		assertTrue(s.contains("170"));
		assertTrue(s.contains("27"));
	}

	@ParameterizedTest
	@CsvSource({
		"Marka i model 1, 17, 170, 27, Marka i model 1, 17, 170, 27, true",
		"Marka i model 1, 17, 170, 27, Marka i model 2, 17, 170, 27, false",
		"Marka i model 1, 17, 170, 27, Marka i model 1, 18, 170, 27, false",
		"Marka i model 1, 17, 170, 27, Marka i model 1, 17, 171, 27, false",
		"Marka i model 1, 17, 170, 27, Marka i model 1, 17, 170, 28, false",
		"Marka i model 1, 17, 170, 27, Marka i model 2, 17, 171, 28, false",
	})
	void testEqualsObject(String markaModel1, int precnik1, int sirina1, int visina1,
			String markaModel2, int precnik2, int sirina2, int visina2, boolean equals) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel(markaModel2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);
		
		assertEquals(equals, ag.equals(ag2));
	}

}
