package it.polito.tdp.alien.model;

public class Traduzione {
	
	private String alieno;
	private String italiano;
	
	public Traduzione(String alieno, String italiano) {
		super();
		this.alieno = alieno;
		this.italiano = italiano;
	}
	
	public String getItaliano() {
		return italiano;
	}
	public void setItaliano(String italiano) {
		this.italiano = italiano;
	}
	public String getAlieno() {
		return alieno;
	}
	public void setAlieno(String alieno) {
		this.alieno = alieno;
	}
	
	@Override
	public String toString() {
		return alieno.toLowerCase() + " ----> " + italiano.toLowerCase();
	}

}
