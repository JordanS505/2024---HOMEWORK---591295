package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	@Test
	public void testCostruisciComandoPrendi() {
		Comando comando;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comando=factory.costruisciComando("prendi");
		comando.getNome().equals("ComandoPrendi");
	}
	
	@Test
	public void testCostruisciComandoPosa() {
		Comando comando;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comando=factory.costruisciComando("posa");
		comando.getNome().equals("ComandoPosa");
	}
	
	@Test
	public void testCostruisciComandoVai() {
		Comando comando;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comando=factory.costruisciComando("vai");
		comando.getNome().equals("ComandoVai");
	}
	
	@Test
	public void testCostruisciComandoGuarda() {
		Comando comando;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comando=factory.costruisciComando("guarda");
		comando.getNome().equals("ComandoGuarda");
	}
	
	@Test
	public void testCostruisciComandoPrendi_Parametro() {
		Comando comando;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comando=factory.costruisciComando("prendi oggetto");
		comando.getParametro().equals("oggetto");
	}
}
