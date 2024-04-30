package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.stanzaBuia;

public class stanzaBuiaTest {

	@Test
	public void testGetDescrizione() {
		Stanza stanza=new stanzaBuia("Biblioteca","osso");
		stanza.getDescrizione();
	}

}
