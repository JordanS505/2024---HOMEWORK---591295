package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.partita.Partita;

public class Cane extends AbstractPersonaggio{
	public static final String MESSAGGIO="Woof woof... ARRRRR WOOF! (Hai perso 1 CFU provando ad accarezzare il cane)";
	private static final String MANGIA="Il cane apprezza la pietanza che gli hai offerto e lascia a terra l'oggetto che teneva tra i denti!";
	private static final String NON_MANGIA="Il cane rifiuta l'oggetto da te proposto, forse sarebbe meglio provare con del cibo...";
	private Attrezzo oggettoTenuto=new Attrezzo("pala",3);
	private String cibo="cibo";
	
	public Cane(String nome,String presentazione){
		super(nome,presentazione);
	}
	
	public String agisci(Partita partita) {
		String msg=MESSAGGIO;
		partita.giocatore.setCfu(partita.giocatore.getCfu()-1);
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(cibo.equals(attrezzo.getNome())) {
			partita.getStanzaCorrente().addAttrezzo(oggettoTenuto);
			oggettoTenuto=null;
			return MANGIA;
		}
		else
		return NON_MANGIA;
	}
}
