package it.uniroma3.diadia.comandi;



import it.uniroma3.diadia.IOConsole.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.partita.Partita;

public class ComandoPosa extends AbstractComando{
	private String attrezzo;
	private String nome="ComandoPosa";
	
	@Override
	public void esegui(Partita partita,IO io) {
		if(partita.giocatore.borsa.isEmpty())
			io.mostraMessaggio("Non hai oggetti da posare");
		else {
			if(this.attrezzo==null) {
			io.mostraMessaggio("Che attrezzo vuoi posare?");
			this.attrezzo = io.leggiRiga();
			}
			if(partita.giocatore.borsa.hasAttrezzo(this.attrezzo)==true) {
				Attrezzo attrezzo=partita.giocatore.borsa.getAttrezzo(this.attrezzo);
				partita.giocatore.borsa.removeAttrezzo(this.attrezzo);
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				io.mostraMessaggio("Oggetto rimosso dalla borsa e posato nella stanza");
			}
			else
				io.mostraMessaggio("Oggetto non presente nella borsa!");
		}
	}
	@Override
	public void setParametro(String parametro){
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
