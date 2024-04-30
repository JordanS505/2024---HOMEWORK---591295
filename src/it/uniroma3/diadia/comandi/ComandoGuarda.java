package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;

public class ComandoGuarda implements Comando{
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
	public void setParametro(String parametro) {}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	
}
