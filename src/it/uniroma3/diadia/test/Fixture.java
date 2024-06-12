package it.uniroma3.diadia.test;

import java.util.List;

import it.uniroma3.diadia.IOConsole.IOSimulator;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.partita.DiaDia;

public class Fixture {
	public static IOSimulator creaSimulazione1(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		labirinto labirinto = new labirinto.LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}

	public static IOSimulator creaSimulazione2(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		labirinto labirinto =new labirinto.LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.addAdiacenza("Biblioteca", "Atrio", "sud")
				.addStanza("Bagno")
				.addAdiacenza("Bagno", "Atrio", "sud")
				.addAdiacenza("Atrio", "Bagno", "nord")
				.addStanza("Studio")
				.addAdiacenza("Studio", "Atrio", "est")
				.addAdiacenza("Atrio", "Studio", "ovest")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}

	public static IOSimulator Monolocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		labirinto monolocale = new labirinto.LabirintoBuilder()
				.addStanzaIniziale("salotto") 
				.addStanzaVincente("salotto") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, monolocale);
		gioco.gioca();
		return io;
	}
	
	
	public static IOSimulator Bilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		labirinto bilocale = new labirinto.LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) // dove? fa riferimento all’ultima stanza aggiunta
				.addAdiacenza("salotto", "camera", "nord") // camera si trova a nord di salotto
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, bilocale);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator Trilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		labirinto trilocale = new labirinto.LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, trilocale);
		gioco.gioca();
		return io;
	}

	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza stanzaDaRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}
}
