package Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Model.Karta;
import Model.KupovinaKarte;
import Model.Osoba;
import Model.TipMesecne;
import Service.KupovinaKarteService;

@Stateless
public class KupovinaKarteServiceImpl implements KupovinaKarteService {
	
	@PersistenceContext(name="MetroDynamicWeb")
	private EntityManager em;
	
	@Override
	public void setKupovina(int idKupovine, int idKarte, int idOsobe) {
		KupovinaKarte novakupovna=new KupovinaKarte(idKupovine, idKarte, idOsobe);
		em.persist(novakupovna);
	}	

	@Override
	public void obrisiKupovinu(int idKupovine) {
		KupovinaKarte kupovina=em.find(KupovinaKarte.class, idKupovine);
		em.remove(kupovina);
	}

	@Override
	public int getIdKarte(int idKupovine) {
		KupovinaKarte karta=em.find(KupovinaKarte.class, idKupovine);
		return karta.getIdKarte();
	}

	@Override
	public List<KupovinaKarte> listaKupovine() {
		TypedQuery<KupovinaKarte> query=em.createQuery("SELECT k FROM KupovinaKarte k", KupovinaKarte.class);
		List<KupovinaKarte> kupovine=query.getResultList();
		return kupovine;
	}

	@Override
	public void novaKupovinaKarticom(int idKupovine, int idOsobe) {
		try {

			Osoba osoba=em.find(Osoba.class, idOsobe);
			String tipKartice=this.generisiTipKarte();
			System.out.println("Tip karte: " +tipKartice);
			if(tipKartice=="studentska") {
				TipMesecne tipPop=em.find(TipMesecne.class, 1);
				Karta kartica=em.find(Karta.class, 3);
				osoba.platiKartu(kartica.getCenaKarte()-tipPop.getVisinaPopusta());
				KupovinaKarte nova=new KupovinaKarte(idKupovine, 3, idOsobe);
				em.persist(nova);
			}else if(tipKartice =="regularna") {
				TipMesecne tipPop=em.find(TipMesecne.class, 2);
				Karta kartica=em.find(Karta.class, 4);
				osoba.platiKartu(kartica.getCenaKarte()-tipPop.getVisinaPopusta());
				KupovinaKarte nova=new KupovinaKarte(idKupovine, 4, idOsobe);
				em.persist(nova);
			}else if(tipKartice =="penzionerska") {
				TipMesecne tipPop=em.find(TipMesecne.class, 3);
				Karta kartica=em.find(Karta.class, 5);
				osoba.platiKartu(kartica.getCenaKarte()-tipPop.getVisinaPopusta());
				KupovinaKarte nova=new KupovinaKarte(idKupovine, 5, idOsobe);
				em.persist(nova);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getIdOsobe(int idKupovine) {
		KupovinaKarte osoba=em.find(KupovinaKarte.class, idKupovine);
		return osoba.getIdOsobe();
	}

	@Override
	public KupovinaKarte getKupovinaKarte(int idKupovine) {
		KupovinaKarte kupovina=em.find(KupovinaKarte.class, idKupovine);
		return kupovina;
	}
	
	private static final String USER_AGENT = "Mozilla/5.0";
	
	public String generisiTipKarte() throws IOException{
		URL obj = new URL("http://192.168.99.100/?kupovina=true");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: "+responseCode);
		String outcome="";
		
		if(responseCode== HttpURLConnection.HTTP_OK) {
			BufferedReader in= new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response=new StringBuffer();
			while((inputLine=in.readLine())!=null){
				response.append(inputLine);
			}
			in.close();
			
			outcome=response.toString();
			System.out.println(outcome);
			return response.toString();
			
		}else {
			System.out.println("GET request failure");
			return outcome;
		}
		
	}

}
