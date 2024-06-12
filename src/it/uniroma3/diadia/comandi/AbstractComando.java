package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;

public abstract class AbstractComando implements Comando{
	protected String parametro;
	private String nome="AbstractComando";
	
	abstract public void esegui(Partita partita,IO io);
	@Override
	public void setParametro(String parametro) {
		this.parametro=parametro;
	}
	@Override
	public String getParametro() {
		return this.parametro;
	}
	@Override
	public String getNome() {
		return this.nome;
	}
}
