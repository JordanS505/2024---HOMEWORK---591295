package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.partita.Partita;

public abstract class AbstractPersonaggio {
	private String nome;
	private String presentazione;
	protected boolean haSalutato;
	protected Attrezzo attrezzoRegalato;
	
	public AbstractPersonaggio(String nome, String presentaz) {
		this.nome = nome;
		this.presentazione = presentaz;
		this.haSalutato = false;
	 }
	
	public String getNome() {
		return this.nome;
	 }
	
	public boolean haSalutato() {
		return this.haSalutato;
	 }
	
	 public String saluta() {
		 StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		 risposta.append(this.getNome()+"."); 
		 if (!haSalutato)
			 risposta.append(this.presentazione);
		 else
			 risposta.append("Ci siamo gia' presentati!");
		 this.haSalutato = true;
		 return risposta.toString();
		 }
	 
		 abstract public String agisci(Partita partita);
		
		 @Override
		 public String toString() {
			 return this.getNome();
		 }
		 
		 public abstract String riceviRegalo(Attrezzo attrezzo,Partita partita);
		 
}
