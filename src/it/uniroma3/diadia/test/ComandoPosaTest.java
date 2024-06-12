package it.uniroma3.diadia.test;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.*;
public class ComandoPosaTest {

	@Test
	public void testEsegui_null() {
		IO io=new IOConsole();
		labirinto trilocale = new labirinto.LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così specificato
		Partita partita=new Partita(trilocale);
		ComandoPosa comando = new ComandoPosa();
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_oggettoNonEsistente() {
		IO io=new IOConsole();
		labirinto trilocale = new labirinto.LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così specificato
		Partita partita=new Partita(trilocale);
		ComandoPosa comando = new ComandoPosa();
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_oggetto() {
		IO io=new IOConsole();
		labirinto trilocale = new labirinto.LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così specificato
		Partita partita=new Partita(trilocale);
		Attrezzo attrezzo=new Attrezzo("acqua",1);
		partita.giocatore.borsa.addAttrezzo(attrezzo);
		ComandoPosa comando = new ComandoPosa();
		comando.esegui(partita,io);
	}

}
