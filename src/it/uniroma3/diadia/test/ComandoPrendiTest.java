package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.labirinto;
public class ComandoPrendiTest {

	
	@Test
	public void testEsegui_oggettoNonEsistente() {
		IO io=new IOConsole();
		labirinto trilocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così specificato
		Partita partita=new Partita(trilocale);
		ComandoPrendi comando = new ComandoPrendi("gioco");
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_oggetto() {
		IO io=new IOConsole();
		labirinto trilocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così specificato
		Partita partita=new Partita(trilocale);
		Attrezzo attrezzo=new Attrezzo("acqua",1);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		ComandoPrendi comando = new ComandoPrendi("acqua");
		comando.esegui(partita,io);
	}
}
