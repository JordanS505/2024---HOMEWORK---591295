package it.uniroma3.diadia.ambienti;

public class stanzaBloccata extends Stanza{
	String bloccata;
	String chiave;
	
	public stanzaBloccata(String nome,String bloccata, String chiave) {
		super(nome);
		this.bloccata=bloccata;
		this.chiave=chiave;
	}
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione==this.bloccata && super.hasAttrezzo(this.chiave)==false)
			return super.getStanzaAdiacente(null);
		return super.getStanzaAdiacente(direzione);
	}
	@Override
	public String getDescrizione() {
		return "Sembra che la direzione "+this.bloccata+" sia bloccata e necessiti dell'oggetto"+ this.chiave +super.toString();
	}
}
