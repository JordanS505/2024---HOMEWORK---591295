package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.partita.Partita;

public class ComandoPrendi implements Comando{
	private String attrezzo;
	private String nome;
	public ComandoPrendi(String attrezzo){
		this.attrezzo=attrezzo;
		this.nome="ComaandoPrendi";
	}
	@Override
	public void esegui(Partita partita,IO io) {
		if(this.attrezzo==null) {
			io.mostraMessaggio("Che attrezzo vuoi prendere?");
			this.attrezzo= io.leggiRiga();
			}
			if(partita.getStanzaCorrente().hasAttrezzo(this.attrezzo)) {
				Attrezzo attrezzo=partita.getStanzaCorrente().getAttrezzo(this.attrezzo);
				boolean preso=partita.giocatore.prendi(attrezzo);
				if(preso) {
					partita.getStanzaCorrente().removeAttrezzo(attrezzo);
					io.mostraMessaggio("Raccolto: " + this.attrezzo);
				}
				else
					io.mostraMessaggio("Borsa piena");
			}
			else
				io.mostraMessaggio("Attrezzo non presente");
	}
	@Override
	public void setParametro(String parametro) {
		this.attrezzo=parametro;
	}
	@Override
	public String getParametro() {
		return this.attrezzo;
	}
	@Override
	public String getNome() {
		return this.nome;
	}
}
