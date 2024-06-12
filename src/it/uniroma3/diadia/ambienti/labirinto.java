package it.uniroma3.diadia.ambienti;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class labirinto {

	public labirinto a;
	public CaricatoreLabirinto b;
	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public void setStanzaFinale(Stanza stanzaFinale) {
		this.stanzaVincente = stanzaFinale;
	}
	public labirinto() {
		//creaStanze();
	}
	
   /* private void creaStanze() {

		// crea gli attrezzi 
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		//crea stanze del labirinto
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		// collega le stanze 
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        // pone gli attrezzi nelle stanze
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
    }*/

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	

public static class LabirintoBuilder {
	private labirinto labirinto;
	private Stanza stanzaInizio;
	private Stanza stanzaFinale;
	private Stanza ultima;
	private Map<String,Stanza> stanze;
	
	public LabirintoBuilder() {
		this.labirinto= new labirinto();
		this.stanze=new HashMap<>();
		
	}
	
	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		this.stanzaInizio=new Stanza(stanzaIniziale);
		labirinto.setStanzaIniziale(stanzaInizio);
		this.stanze.put(stanzaIniziale, stanzaInizio);
		this.ultima=this.stanzaInizio;
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		this.stanzaFinale=new Stanza(stanzaVincente);
		labirinto.setStanzaFinale(stanzaFinale);
		this.stanze.put(stanzaVincente, stanzaFinale);
		this.ultima=this.stanzaFinale;
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String uno,String due,String adiacenza) {
		Stanza s= this.stanze.get(due);
		this.stanze.get(uno).impostaStanzaAdiacente(adiacenza, s);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome,int peso) {
		Attrezzo attrezzo = new Attrezzo(nome,peso);
		this.ultima.addAttrezzo(attrezzo);
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String nome,int peso,String nuova) {
		Attrezzo attrezzo = new Attrezzo(nome,peso);
		this.stanze.get(nuova).addAttrezzo(attrezzo);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nuova) {
		Stanza a = new Stanza(nuova);
		this.stanze.put(nuova, a);
		this.ultima=a;
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nuova,String attrezzo) {
		Stanza a = new stanzaBuia(nuova,attrezzo);
		this.stanze.put(nuova, a);
		this.ultima=a;
		return this;
	}
	
	public LabirintoBuilder addMago(String stanza,String nome, String pres, String attrezzo) {
		Attrezzo a= new Attrezzo(attrezzo,5);
		AbstractPersonaggio mago= new Mago(nome,pres,a);
		this.stanze.get(stanza).setPersonaggio(mago);
		return this;
	}
	
	public LabirintoBuilder addStrega(String stanza,String nome, String pres) {
		AbstractPersonaggio strega= new Strega(nome,pres);
		this.stanze.get(stanza).setPersonaggio(strega);
		return this;
	}
	
	public LabirintoBuilder addCane(String stanza,String nome, String pres) {
		AbstractPersonaggio cane= new Cane(nome,pres);
		this.stanze.get(stanza).setPersonaggio(cane);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nuova,int soglia) {
		Stanza a = new stanzaMagica(nuova,soglia);
		this.stanze.put(nuova, a);
		this.ultima=a;
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nuova,String bloccata,String chiave) {
		Stanza a = new stanzaBloccata(nuova,bloccata,chiave);
		this.stanze.put(nuova, a);
		this.ultima=a;
		return this;
	}
	
	public labirinto getLabirinto() {
		return this.labirinto;
	}
}
}
