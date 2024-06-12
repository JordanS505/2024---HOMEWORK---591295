package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.partita.Partita;

public class ComandoAiuto extends AbstractComando{
	private String nome;
	private String[] elencoComandi = {" -vai","-aiuto","-fine","-prendi","-posa","-guarda"};
	public ComandoAiuto(){
		this.nome="ComandoAiuto";
	}
	
	@Override
	public void esegui(Partita partita,IO io) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]);
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}
}
