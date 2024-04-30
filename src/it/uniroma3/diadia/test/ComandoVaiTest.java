package it.uniroma3.diadia.test;


import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.IOConsole.*;
public class ComandoVaiTest {

	@Test
	public void testEsegui_null() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		ComandoVai comando= new ComandoVai(null);
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_direzione() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		ComandoVai comando= new ComandoVai("nord");
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_direzioneInesistente() {
		IO io=new IOConsole();
		Partita partita=new Partita();
		partita.getStanzaCorrente().impostaStanzaAdiacente("sud", null);
		ComandoVai comando= new ComandoVai("sud");
		comando.esegui(partita,io);
	}

}
