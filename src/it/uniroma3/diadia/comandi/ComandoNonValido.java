package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;

public class ComandoNonValido implements Comando{
	private String nome;
	public ComandoNonValido(){
		this.nome="ComandoNonValido";
	}
	@Override
	public void esegui(Partita partita,IO io) {
		io.mostraMessaggio("Comando non valido\n");
	}
	@Override
	public void setParametro(String parametro) {
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
