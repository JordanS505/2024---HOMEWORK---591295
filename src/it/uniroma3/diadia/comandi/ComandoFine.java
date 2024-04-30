package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;

public class ComandoFine implements Comando{
	private String nome;
	public ComandoFine() {
		this.nome="ComandoFine";
	}
	@Override
	public void esegui(Partita partita,IO io) {
		io.mostraMessaggio("Grazie per aver giocato!");
		partita.setFinita();
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		
	}

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
