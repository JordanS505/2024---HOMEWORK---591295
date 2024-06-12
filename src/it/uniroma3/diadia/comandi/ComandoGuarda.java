package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;

public class ComandoGuarda extends AbstractComando{
	private String nome;
	public ComandoGuarda() {
		this.nome="ComandoGuarda";
	}
	@Override
	public void esegui(Partita partita,IO io) {
		io.mostraMessaggio(partita.giocatore.borsa.toString());
		io.mostraMessaggio("CFU rimanenti:"+partita.giocatore.getCfu());
		io.mostraMessaggio(partita.getStanzaCorrente().toString());
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
}
