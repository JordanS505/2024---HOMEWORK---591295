package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private labirinto labirinto;
	private Stanza stanzaInizio;
	private Stanza stanzaFinale;
	private Stanza ultima;
	private Map<String,Stanza> stanze;
	
	public LabirintoBuilder(){
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
