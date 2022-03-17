package it.polito.tdp.alien.model;

import java.util.*;

public class Dizionario {
	
	private List<Traduzione> dizionario;

	public Dizionario() {
		super();
		this.dizionario = new LinkedList<>();
	}
	
	public void addTraduzione(String alieno, String italiano) {
		Traduzione tempT = new Traduzione(alieno, italiano);
		this.dizionario.add(tempT);
	}
	
	public String getTraduzione(String s) {
		String stringa = "";
		for(Traduzione t: this.dizionario) {
			if(t.getAlieno().toLowerCase().equals(s.toLowerCase())) {
				stringa += t.toString()+"\n";
			}
		}
		return stringa;
	}	

}
