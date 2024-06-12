package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando{
	private String messaggio;
	private String MESSAGGIO_CON_CHI="Con chi dovrei interagire?";

	@Override
	public void esegui(Partita partita, IO io) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.saluta();
			io.mostraMessaggio(this.messaggio);
		} 
		else 
			io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}

	@Override
	public String getNome() {
		return "ComandoSaluta";
	}
}
