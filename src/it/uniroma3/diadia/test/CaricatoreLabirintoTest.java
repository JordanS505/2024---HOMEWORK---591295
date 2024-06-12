package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.CaricatoreLabirinto;
import it.uniroma3.diadia.ambienti.FormatoFileNonValidoException;
public class CaricatoreLabirintoTest {
	
	private final String monolocale =
			"Stanze:N10\n"
			+ "Magiche:\n"
			+ "Buie:\n"
			+ "Bloccate:\n"
			+ "Inizio:N10\n"
			+ "Vincente:N10\n"
			+ "Maghi:\n"
			+ "Streghe:\n"
			+ "Cani:\n"
			+ "Attrezzi:Osso 5 N10\n"
			+ "Uscite:";
	
	private final String bilocale =
			"Stanze:N10,Biblioteca\n"
			+ "Magiche:\n"
			+ "Buie:\n"
			+ "Bloccate:\n"
			+ "Inizio:N10\n"
			+ "Vincente:Biblioteca\n"
			+ "Maghi:N10 mago ciao spada\n"
			+ "Streghe:\n"
			+ "Cani:\n"
			+ "Attrezzi:Osso 5 N10\n"
			+ "Uscite:N10 nord Biblioteca\n Biblioteca sud N10";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	CaricatoreLabirinto cl;
	@Test
	public void testCarica_monolocale() throws FormatoFileNonValidoException, FileNotFoundException{
			cl = new CaricatoreLabirinto(new StringReader(monolocale));
			cl.carica();
			assertEquals("N10", this.cl.getStanzaIniziale().getNome());
			assertEquals("N10", this.cl.getStanzaVincente().getNome());
			assertTrue( this.cl.getStanzaIniziale().hasAttrezzo("Osso"));
	}

	
	@Test
	public void testCarica_bilocale() throws FormatoFileNonValidoException, FileNotFoundException{
			cl = new CaricatoreLabirinto(new StringReader(bilocale));
			cl.carica();
			assertEquals("N10", this.cl.getStanzaIniziale().getNome());
			assertEquals("Biblioteca", this.cl.getStanzaVincente().getNome());
			assertTrue( this.cl.getStanzaIniziale().hasAttrezzo("Osso"));
			assertEquals("mago",this.cl.getStanzaIniziale().getPersonaggio().getNome());
	}

}
