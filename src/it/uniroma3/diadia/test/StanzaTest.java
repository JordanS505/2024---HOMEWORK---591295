package it.uniroma3.diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {

	@Test
	public void testGetAttrezzo_StanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertNull(vuota.getAttrezzo("insesistente"));		
	}
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertNull(stanza.getAttrezzo("nomeDiAttrezzoNonPresente"));	
	}
	
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Preso() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		stanza.addAttrezzo(attrezzo);
		assertNotNull(stanza.getAttrezzo("attrezzo"));	
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaVuota() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo inesistente=new Attrezzo("inesistente",0);
		assertFalse(stanza.removeAttrezzo(inesistente));	
	}
	
	@Test
	public void testRemoveAttrezzo_StanzaNonVuota_Presente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo inesistente=new Attrezzo("inesistente",0);
		stanza.addAttrezzo(inesistente);
		assertTrue(stanza.removeAttrezzo(inesistente));	
	}

	@Test
	public void testRemoveAttrezzo_StanzaNonVuota_Assente() {
		Stanza stanza = new Stanza("stanza");
		Attrezzo inesistente=new Attrezzo("inesistente",0);
		Attrezzo attrezzo=new Attrezzo("sbagliato",1);
		stanza.addAttrezzo(inesistente);
		assertFalse(stanza.removeAttrezzo(attrezzo));	
	}
}
