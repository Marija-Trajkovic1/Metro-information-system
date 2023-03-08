package Controller;

import java.util.List;

import javax.ejb.EJB;

import Model.TipMesecne;
import Service.TipMesecneService;



public class TipMesecneController {
	
	private int idtipMesecne=0;
	private String nazivTipa="";
	private int visinaPopusta=0;
	private TipMesecne tipMes=new TipMesecne();
	
	@EJB
	private TipMesecneService service;
	
	public TipMesecne getTipMesecne() {
		return tipMes;
	}
	
	public void setIdtipMesecne(int id) {
		this.idtipMesecne=id;
	}
	
	public int getIdtipMesecne() {
		return this.idtipMesecne;
	}
	
	public void setNazivTipa(String naziv) {
		this.nazivTipa=naziv;
	}
	
	public String getNazivTipa() {
		return this.nazivTipa;
	}
	
	public void setVisinaPopusta(int visina) {
		this.visinaPopusta=visina;	
	}
	
	public int getVisinaPopusta() {
		return this.visinaPopusta;	
	}
	
	public List<TipMesecne> listaTipova(){
		List<TipMesecne> listaT=service.listaTipova();
		return listaT;
	}
	
	public void dodajnoviTip(TipMesecne tip) {
		service.noviTip(tip.getIdTipMesecne(), tip.getNazivTipa(), tip.getVisinaPopusta());
	}
	
	public String vratiNazivPopusta(int idtip) {
		return service.vratiNazivPopusta(idtip);
	}
	
	public int vratiVisinuPopusta(int idtip) {
		return service.vratiVisinuPopusta(idtip);
	}
	
	
	
}
