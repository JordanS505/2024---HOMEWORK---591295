package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.partita.Partita;

public class ComandoVai extends AbstractComando{
	private String direzione;
	private String nome="ComandoVai";
	
	
	@Override
	public void esegui(Partita partita,IO io) {
		Stanza stanzaCorrente=partita.getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(direzione==null) {
			System.out.println("Dove vuoi andare ?");
			return;
		}
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if (prossimaStanza == null) {
			System.out.println("Direzione inesistente");
			return;
		}
			partita.setStanzaCorrente(prossimaStanza);
			System.out.println(partita.getStanzaCorrente().getDescrizione());
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}
	@Override
	public String getParametro() {
		return this.direzione;
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}
}