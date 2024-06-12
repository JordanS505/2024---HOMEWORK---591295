package it.uniroma3.diadia.ambienti;

import java.io.*;
import java.util.*;

import it.uniroma3.diadia.ambienti.labirinto.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:";             

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";    

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";  

	/* prefisso della riga contenente le specifiche degli attrezzi da collocare nel formato <nomeAttrezzo> <peso> <nomeStanza> */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/* prefisso della riga contenente le specifiche dei collegamenti tra stanza nel formato <nomeStanzaDa> <direzione> <nomeStanzaA> */
	private static final String USCITE_MARKER = "Uscite:";
	private static final String STANZA_BUIE_MARKER="Buie:";
	private static final String STANZE_MAGICHE_MARKER="Magiche:";
	private static final String STANZE_BLOCCATE_MARKER="Bloccate:";
	private static final String MAGHI_MARKER="Maghi:";
	private static final String STREGHE_MARKER="Streghe:";
	private static final String CANI_MARKER="Cani:";
	/*
	 *  Esempio di un possibile file di specifica di un labirinto (vedi POO-26-eccezioni-file.pdf)

		Stanze: biblioteca, N10, N11
		Inizio: N10
		Vincente: N11
		Attrezzi: martello 10 biblioteca, pinza 2 N10
		Uscite: biblioteca nord N10, biblioteca sud N11

	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private labirinto.LabirintoBuilder l;

	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.reader = new LineNumberReader(new FileReader("C://Users//jorda//Desktop//lol.txt"));
		l=new LabirintoBuilder();
	}

	public CaricatoreLabirinto(StringReader stringReader) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String,Stanza>();
		this.reader = new LineNumberReader(stringReader);
		l=new LabirintoBuilder();
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiECreaStanzeMagiche();
			this.leggiECreaStanzeBuie();
			this.leggiECreaStanzeBloccate();
			this.leggiInizialeEvincente();
			this.leggiECreaMago();
			this.leggiECreaStrega();
			this.leggiECreaCane();
			this.leggiECollocaAttrezzi();
			this.leggiEImpostaUscite();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker),"era attesa una riga che cominciasse per "+marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}
	
	private void leggiECreaMago() throws FormatoFileNonValidoException {
		String maghi= this.leggiRigaCheCominciaPer(MAGHI_MARKER);
		for(String spec : separaStringheAlleVirgole(maghi)) {
			try(Scanner scanner=new Scanner(spec)){
				while(scanner.hasNext()) {
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile trovare la stanza del mago"));
					String nomeStanza= scanner.next();
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare il mago"));
					String nome=scanner.next();
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare la presentazione"));
					String presentazione=scanner.next();
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare l'attrezzo"));
					String attrezzo=scanner.next();
					
					AbstractPersonaggio mago= new Mago(nome,presentazione,new Attrezzo(attrezzo,4));
					this.nome2stanza.get(nomeStanza).setPersonaggio(mago);
					l.addMago(nomeStanza, nome, presentazione, attrezzo);
				}
			}
		}
	}
	
	private void leggiECreaStrega() throws FormatoFileNonValidoException {
		String maghi= this.leggiRigaCheCominciaPer(STREGHE_MARKER);
		for(String spec : separaStringheAlleVirgole(maghi)) {
			try(Scanner scanner=new Scanner(spec)){
				while(scanner.hasNext()) {
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile trovare la stanza della strega"));
					String nomeStanza= scanner.next();
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare la strega"));
					String nome=scanner.next();
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare la presentazione"));
					String presentazione=scanner.next();
					
					AbstractPersonaggio strega= new Strega(nome,presentazione);
					this.nome2stanza.get(nomeStanza).setPersonaggio(strega);
					l.addStrega(nomeStanza, nome, presentazione);
				}
			}
		}
	}
	
	private void leggiECreaCane() throws FormatoFileNonValidoException {
		String maghi= this.leggiRigaCheCominciaPer(CANI_MARKER);
		for(String spec : separaStringheAlleVirgole(maghi)) {
			try(Scanner scanner=new Scanner(spec)){
				while(scanner.hasNext()) {
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile trovare la stanza del cane"));
					String nomeStanza= scanner.next();
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare il cane"));
					String nome=scanner.next();
					check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare la presentazione"));
					String presentazione=scanner.next();
					
					AbstractPersonaggio cane= new Cane(nome,presentazione);
					this.nome2stanza.get(nomeStanza).setPersonaggio(cane);
					l.addCane(nomeStanza, nome, presentazione);
				}
			}
		}
	}

	private void leggiECreaStanze() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new Stanza(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
			l.addStanza(nomiStanze);
			System.out.println("qui");
		}
	}
	
	private void leggiECreaStanzeMagiche() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MAGICHE_MARKER);
		for(String nomeStanza : separaStringheAlleVirgole(nomiStanze)) {
			Stanza stanza = new stanzaMagica(nomeStanza);
			this.nome2stanza.put(nomeStanza, stanza);
		}
	}
	
	private void leggiECreaStanzeBuie() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZA_BUIE_MARKER);
		for(String riga : separaStringheAlleVirgole(nomiStanze)) {
			
			try(Scanner scanner=new Scanner(riga)){
			while(scanner.hasNext()) {
				check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare la stanza buia"));
				String nomeStanza=scanner.next();
				check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare l'attrezzo per stanza buia"));
				String attrezzoPerLuce=scanner.next();
			
			Stanza stanza = new stanzaBuia(nomeStanza,attrezzoPerLuce);
			this.nome2stanza.put(nomeStanza, stanza);
			}
			}
		}
	}
	
	private void leggiECreaStanzeBloccate() throws FormatoFileNonValidoException  {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_BLOCCATE_MARKER);
		for(String riga : separaStringheAlleVirgole(nomiStanze)) {
			
			try(Scanner scanner=new Scanner(riga)){
			while(scanner.hasNext()) {
				check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare la stanza bloccata"));
				String nomeStanza=scanner.next();
				check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare la direzione della stanza bloccata"));
				String direzione=scanner.next();
				check(scanner.hasNext(),msgTerminazionePrecoce("Impossibile creare l'attrezzo per stanza bloccata"));
				String attrezzoPerAccedere=scanner.next();
			
			Stanza stanza = new stanzaBloccata(nomeStanza,direzione,attrezzoPerAccedere);
			this.nome2stanza.put(nomeStanza, stanza);
			}
			}
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();
		Scanner scanner = new Scanner(string);
		scanner.useDelimiter(",");
		try (Scanner scannerDiParole = scanner) {
			while(scannerDiParole.hasNext())
			result.add(scannerDiParole.next());
		}
		return result;
	}


	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = null;
		nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale +" non definita");
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
		l.addStanzaIniziale(nomeStanzaIniziale);
		l.addStanzaVincente(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for(String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null; 
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome di un attrezzo."));
				nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il peso dell'attrezzo "+nomeAttrezzo+"."));
				pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(),msgTerminazionePrecoce("il nome della stanza in cui collocare l'attrezzo "+nomeAttrezzo+"."));
				nomeStanza = scannerLinea.next();
			}				
			posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}

	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza) throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),"Attrezzo "+ nomeAttrezzo+" non collocabile: stanza " +nomeStanza+" inesistente");
			this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
			l.addAttrezzo(nomeAttrezzo, peso, nomeStanza);
		}
		catch (NumberFormatException e) {
			check(false, "Peso attrezzo "+nomeAttrezzo+" non valido");
		}
	}


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
		for(String specifiche : separaStringheAlleVirgole(specificheUscite))
		try (Scanner scannerDiLinea = new Scanner(specifiche)) {			

			while (scannerDiLinea.hasNext()) {
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("le uscite di una stanza."));
				String stanzaPartenza = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la direzione di una uscita della stanza "+stanzaPartenza));
				String dir = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),msgTerminazionePrecoce("la destinazione di una uscita della stanza "+stanzaPartenza+" nella direzione "+dir));
				String stanzaDestinazione = scannerDiLinea.next();
				
				impostaUscita(stanzaPartenza, dir, stanzaDestinazione);
				l.addAdiacenza(stanzaPartenza, stanzaDestinazione, dir);
			}
		} 
	}
	
	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere "+msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
		check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		Stanza arrivoA = this.nome2stanza.get(nomeA);
		partenzaDa.impostaStanzaAdiacente(dir, arrivoA);
	}


	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore) throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException("Formato file non valido [" + this.reader.getLineNumber() + "] "+messaggioErrore);		
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	public labirinto getLab() {
		return l.getLabirinto();
	}
}