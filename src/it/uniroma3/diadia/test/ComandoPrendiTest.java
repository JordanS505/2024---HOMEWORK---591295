package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.IOConsole.*;
public class ComandoPrendiTest {

	
	@Test
	public void testEsegui_oggettoNonEsistente() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		ComandoPrendi comando = new ComandoPrendi("gioco");
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_oggetto() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		Attrezzo attrezzo=new Attrezzo("acqua",1);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		ComandoPrendi comando = new ComandoPrendi("acqua");
		comando.esegui(partita,io);
	}
}
