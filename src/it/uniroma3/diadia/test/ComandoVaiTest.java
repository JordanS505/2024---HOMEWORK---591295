package it.uniroma3.diadia.test;


import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.IOConsole.*;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.labirinto;
public class ComandoVaiTest {

	@Test
	public void testEsegui_null() {
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
		ComandoVai comando= new ComandoVai(null);
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_direzione() {
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
		ComandoVai comando= new ComandoVai("nord");
		comando.esegui(partita,io);
	}
	
	@Test
	public void testEsegui_direzioneInesistente() {
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
		partita.getStanzaCorrente().impostaStanzaAdiacente("sud", null);
		ComandoVai comando= new ComandoVai("sud");
		comando.esegui(partita,io);
	}

}
