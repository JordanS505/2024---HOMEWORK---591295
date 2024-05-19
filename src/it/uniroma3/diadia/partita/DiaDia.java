package it.uniroma3.diadia.partita;


import it.uniroma3.diadia.IOConsole.IO;

//import java.util.Scanner;

import it.uniroma3.diadia.IOConsole.IOConsole;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;


/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	//static final private String[] elencoComandi = {" -vai","-aiuto","-fine","-prendi","-posa","-borsa"};
	
	public Partita partita;
	public IO io;
	public labirinto labirinto;
	public DiaDia(IO io,labirinto labirinto) {
		this.partita = new Partita(labirinto);
		this.io=io;
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita,this.io);
		if(partita.giocatore.getCfu()==0) {
			io.mostraMessaggio("Hai finito i cfu");
			//this.fine();
			return true;
		}
		if(istruzione.isBlank())
			return false;
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else if(this.partita.isFinita())
			return true;
			return false;
	}   

	// implementazioni dei comandi dell'utente:
	/*private void prendi(String oggetto) {
		if(oggetto==null) {
		IOconsole.mostraMessaggio("Che attrezzo vuoi prendere?");
		Scanner cercato= new Scanner(System.in);
		oggetto= IOconsole.leggiRiga();
		}
		if(this.partita.getStanzaCorrente().hasAttrezzo(oggetto)) {
			Attrezzo attrezzo=this.partita.getStanzaCorrente().getAttrezzo(oggetto);
			boolean preso=this.giocatore.prendi(attrezzo);
			if(preso) {
				this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
				IOconsole.mostraMessaggio("Raccolto: " + oggetto);
			}
			else
				IOconsole.mostraMessaggio("Borsa piena");
		}
		else
			IOconsole.mostraMessaggio("Attrezzo non presente");
		}*/
	
	/*private void posa(String oggetto) {
		if(this.giocatore.borsa.isEmpty())
			IOconsole.mostraMessaggio("Non hai oggetti da posare");
		else {
			if(oggetto==null) {
			IOconsole.mostraMessaggio("Che attrezzo vuoi posare?");
			Scanner cercato= new Scanner(System.in);
			oggetto = IOconsole.leggiRiga();
			}
			if(this.giocatore.borsa.hasAttrezzo(oggetto)==true) {
				Attrezzo attrezzo=this.giocatore.borsa.getAttrezzo(oggetto);
				this.giocatore.borsa.removeAttrezzo(oggetto);
				this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
				IOconsole.mostraMessaggio("Oggetto rimosso dalla borsa e posato nella stanza");
			}
			else
				IOconsole.mostraMessaggio("Oggetto non presente nella borsa!");
		}
	}*/
	
	/*private void borsa() {
		IOconsole.mostraMessaggio(this.giocatore.borsa.toString());
	}*/
	/**
	 * Stampa informazioni di aiuto.
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			IOconsole.mostraMessaggio(elencoComandi[i]);
		
	}*/

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) {
		if(direzione==null) {
			IOconsole.mostraMessaggio("Dove vuoi andare ?");
			Scanner risposta=new Scanner(System.in);
			direzione=IOconsole.leggiRiga();
		}
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			IOconsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			cfu--;
			this.giocatore.setCfu(cfu);
		}
		IOconsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}*/

	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		IOconsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}*/

	public static void main(String[] argc) {
		IO io = new IOConsole();
		labirinto trilocale = new LabirintoBuilder()
				.addStanzaIniziale("salotto")
				.addStanza("cucina")
				.addAttrezzo("pentola",1) // dove? fa riferimento all’ultima stanza aggiunta: la “cucina”
				.addStanzaVincente("camera")
				.addAdiacenza("salotto", "cucina", "nord")
				.addAdiacenza("cucina", "camera", "est")
				.getLabirinto(); // restituisce il Labirinto così specificato
		DiaDia gioco = new DiaDia(io,trilocale);
		gioco.gioca();
	}
}