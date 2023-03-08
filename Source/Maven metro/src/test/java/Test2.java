//kupovina karte 

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Impl.KupovinaKarticeServiceImpl;
import Model.KupovinaKarte;

public class Test2 {
	private static KupovinaKarticeServiceImpl kupovina;
	
	@BeforeClass
	public static void initTest() {
		kupovina=new KupovinaKarticeServiceImpl();
		System.out.println("Inicijalizacija testa uspesna!");
		
	}
	
	@Before
	public void testPrecondition() {
		KupovinaKarte karta=kupovina.vratiKartu(2);
		assertNotNull(karta);
		KupovinaKarte osoba= kupovina.vratiOsobu(4);
		assertNotNull(osoba);
		System.out.println("Preduslov ispunjen!");	
	}
		
	@Test
	public void executeTest() {
		//int idOsobe=4;
		//int idKarte=2;
		kupovina.novaKupovina(63, 2, 4);
		System.out.println("Izvrsen test");
	}
	
	@After
	public void testPostcondition() {
		KupovinaKarte kreiranaKupovina= kupovina.vratiKupovinu(63);
		assertNotNull(kreiranaKupovina);
		System.out.println("Post uslov izvrsen!");
	}
	
	@AfterClass
	public static void clearTest() {
		kupovina.obrisiKupovinu(63);
		System.out.println("Obnovljeni su podaci korisceni u testu");
	}
}
