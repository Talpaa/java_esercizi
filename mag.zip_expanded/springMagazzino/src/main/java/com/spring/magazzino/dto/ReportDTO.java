package com.spring.magazzino.dto;

import java.util.LinkedList;
import java.util.Map;

public class ReportDTO {

	private LinkedList<String> descrizioni;
	private int pezziTotaliMagazzino;
	private int prodottiNonDisponibili;
	private double mediaPrezzi;
	private LinkedList<String> nomiProdottiNonDisponibili;
	private Map<String, LinkedList<Integer>> elencoCategorie;
	
	public ReportDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReportDTO(LinkedList<String> descrizioni, int pezziTotaliMagazzino, int prodottiNonDisponibili,
			double mediaPrezzi, LinkedList<String> nomiProdottiNonDisponibili,
			Map<String, LinkedList<Integer>> elencoCategorie) {
		super();
		this.descrizioni = descrizioni;
		this.pezziTotaliMagazzino = pezziTotaliMagazzino;
		this.prodottiNonDisponibili = prodottiNonDisponibili;
		this.mediaPrezzi = mediaPrezzi;
		this.nomiProdottiNonDisponibili = nomiProdottiNonDisponibili;
		this.elencoCategorie = elencoCategorie;
	}

	public LinkedList<String> getDescrizioni() {
		return descrizioni;
	}

	public void setDescrizioni(LinkedList<String> descrizioni) {
		this.descrizioni = descrizioni;
	}

	public int getPezziTotaliMagazzino() {
		return pezziTotaliMagazzino;
	}

	public void setPezziTotaliMagazzino(int pezziTotaliMagazzino) {
		this.pezziTotaliMagazzino = pezziTotaliMagazzino;
	}

	public int getProdottiNonDisponibili() {
		return prodottiNonDisponibili;
	}

	public void setProdottiNonDisponibili(int prodottiNonDisponibili) {
		this.prodottiNonDisponibili = prodottiNonDisponibili;
	}

	public double getMediaPrezzi() {
		return mediaPrezzi;
	}

	public void setMediaPrezzi(double mediaPrezzi) {
		this.mediaPrezzi = mediaPrezzi;
	}

	public LinkedList<String> getNomiProdottiNonDisponibili() {
		return nomiProdottiNonDisponibili;
	}

	public void setNomiProdottiNonDisponibili(LinkedList<String> nomiProdottiNonDisponibili) {
		this.nomiProdottiNonDisponibili = nomiProdottiNonDisponibili;
	}

	public Map<String, LinkedList<Integer>> getElencoCategorie() {
		return elencoCategorie;
	}

	public void setElencoCategorie(Map<String, LinkedList<Integer>> elencoCategorie) {
		this.elencoCategorie = elencoCategorie;
	}
	
	
}
