package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.stanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class stanzaBloccataTest {

	@Test
	public void testGetStanzaAdiacente_oggettoNonPresente() {
		Stanza stanza=new stanzaBloccata("Atrio","nord","osso");
		stanza.getStanzaAdiacente("nord");
	}
	
	@Test
	public void testGetStanzaAdiacente_oggettoPresente() {
		Stanza stanza=new stanzaBloccata("Atrio","nord","osso");
		Attrezzo osso=new Attrezzo("osso",1);
		stanza.addAttrezzo(osso);
		stanza.getStanzaAdiacente("nord");
	}

	@Test
	public void testGetDescrizione() {
		Stanza stanza=new stanzaBloccata("Atrio","nord","osso");
		stanza.getDescrizione().toString();
	}

}
