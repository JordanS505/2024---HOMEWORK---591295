package it.uniroma3.diadia.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	@Test
	public void testGetAttrezzo() {
		Borsa vuota = new Borsa();
		assertNull(vuota.getAttrezzo("insesistente"));	
	}
	
	@Test
	public void testGetAttrezzo_BorsaNonVuota_Presente() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		borsa.addAttrezzo(attrezzo);
		assertNull(borsa.getAttrezzo("nomeDiAttrezzoNonPresente"));	
	}
	
	@Test
	public void testGetAttrezzo_StanzaNonVuota_Preso() {
		Borsa borsa = new Borsa();
		Attrezzo attrezzo = new Attrezzo("attrezzo",0);
		borsa.addAttrezzo(attrezzo);
		assertNotNull(borsa.getAttrezzo("attrezzo"));	
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaNonVuota() {
		Borsa borsa = new Borsa();
		Attrezzo inesistente=new Attrezzo("inesistente",0);
		borsa.addAttrezzo(inesistente);
		assertNull(borsa.removeAttrezzo("esistente"));	
	}
	
	@Test
	public void testRemoveAttrezzo_BorsaNonVuota_Presente() {
		Borsa borsa = new Borsa();
		Attrezzo inesistente=new Attrezzo("inesistente",0);
		borsa.addAttrezzo(inesistente);
		assertNotNull(borsa.removeAttrezzo("inesistente"));	
	}

	@Test
	public void testRemoveAttrezzo_BorsaVuota() {
		Borsa borsa = new Borsa();
		assertNull(borsa.removeAttrezzo("esistente"));		
	}
}
