/*brisanje kupljene karte*/

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import Impl.KupovinaKarticeServiceImpl;
import Model.KupovinaKarte;

public class Test1 {
	private static KupovinaKarticeServiceImpl kupovina;
	private static int idKupovine;
	private static int idKarte;
	private static int idOsobe;
	
	@BeforeClass
	public static void initTest() {
		kupovina = new KupovinaKarticeServiceImpl();
		KupovinaKarte kupovinica=kupovina.vratiKupovinu(77);
		idKupovine=kupovinica.getIdKupovine();
		idKarte=kupovinica.getIdKarte();
		idOsobe=kupovinica.getIdOsobe();
		System.out.println("Inicijalizacija testa uspesna!");
	}
	
	@Before
	public void testPrecondition() {
		KupovinaKarte kupovinica=kupovina.vratiKupovinu(77);
		assertNotNull(kupovinica);
		System.out.println("Preduslov ispunjen!");	
	}
	
	@Test
	public void executeTest() {
		kupovina.obrisiKupovinu(77);
		System.out.println("Izvrsen test");
	}
	
 	@After
	public void testPostcondition() {
		KupovinaKarte kupovinica=kupovina.vratiKupovinu(77);
		assertNull(kupovinica);
		System.out.println("Post uslov izvrsen!");
	}
	
	@AfterClass
	public static void clearTest() {
		
		kupovina.novaKupovina(idKupovine, idKarte, idOsobe);
		System.out.println("Obnovljeni su podaci korisceni u testu");
	}
	
	
	
}
