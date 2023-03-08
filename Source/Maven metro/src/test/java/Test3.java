//izmena ocene usluge korisnika

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Impl.OsobaServiceImpl;
import Model.Osoba;

import static org.junit.Assert.*;

public class Test3 {
	
	private static OsobaServiceImpl osobica;
	private static int ocenaUsluge;
	
	@BeforeClass
	public static void initTest() {
		osobica=new OsobaServiceImpl();
		Osoba osobica1=osobica.vratiOsobu(2);
		ocenaUsluge=osobica1.getOcenaUsluge();
		System.out.println("Inicijalizacija testa uspesna!");
		
	}
	
	@Before
	public void testPrediction() {
		Osoba osoba=osobica.vratiOsobu(2);
		assertNotNull(osoba);
		System.out.println("Preduslov ispunjen!");	
	}
	
	@Test
	public void executeTest() {
		osobica.oceniUslugu(2, 3);
		System.out.println("Izvrsen test");
	}
	
	@After
	public void testPostcondition() {
		Osoba osoba=osobica.vratiOsobu(2);
		assertEquals(osoba.getOcenaUsluge(), 3);
		System.out.println("Post uslov izvrsen!");
	}
	
	@AfterClass
	public static void clearTest() {
		osobica.oceniUslugu(1, ocenaUsluge);
		System.out.println("Obnovljeni su podaci korisceni u testu");
	}
}
