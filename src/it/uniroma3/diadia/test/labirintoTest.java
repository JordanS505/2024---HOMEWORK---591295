package it.uniroma3.diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.labirinto;

public class labirintoTest {

	@Test
	public void testGetStanzaIniziale_Presente() {
		labirinto labirint= new labirinto();
		Stanza stanza = new Stanza("ciao");
		labirint.setStanzaIniziale(stanza);
		assertNotNull(labirint.getStanzaIniziale());
	}
	@Test
	public void testGetStanzaIniziale_NonPresente() {
		labirinto labirint= new labirinto();
		labirint.setStanzaIniziale(null);
		assertNull(labirint.getStanzaIniziale());
	}

}
