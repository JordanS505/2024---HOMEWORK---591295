package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;

public class ComandoNonValido extends AbstractComando{
	private String nome;
	public ComandoNonValido(){
		this.nome="ComandoNonValido";
	}
	@Override
	public void esegui(Partita partita,IO io) {
		io.mostraMessaggio("Comando non valido\n");
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}
}
