package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.partita.Partita;

public class ComandoRegala extends AbstractComando{
	
	
	@Override
	public void esegui(Partita partita, IO io) {
		if(partita.giocatore.borsa.hasAttrezzo(parametro)) {
			Attrezzo attrezzo;
			String msg;
			attrezzo=partita.giocatore.borsa.getAttrezzo(parametro);
			partita.giocatore.borsa.removeAttrezzo(parametro);
			msg=partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita);
			io.mostraMessaggio(msg);
		}
		else
			io.mostraMessaggio("Non hai nessun oggetto con quel nome nella borsa!");
	}
	
	@Override
	public String getNome() {
		return "ComandoRegala";
	}
}
