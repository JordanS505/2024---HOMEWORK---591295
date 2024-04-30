package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.IOConsole.*;
public class ComandoPosaTest {

	@Test
	public void testEsegui_null() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		ComandoPosa comando = new ComandoPosa(null);
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_oggettoNonEsistente() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		ComandoPosa comando = new ComandoPosa("gioco");
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_oggetto() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		Attrezzo attrezzo=new Attrezzo("acqua",1);
		partita.giocatore.borsa.addAttrezzo(attrezzo);
		ComandoPosa comando = new ComandoPosa("acqua");
		comando.esegui(partita,io);
	}

}
