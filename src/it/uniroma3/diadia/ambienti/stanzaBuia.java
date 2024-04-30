package it.uniroma3.diadia.ambienti;

public class stanzaBuia extends Stanza{
	public stanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzo=attrezzo;
	}

	String attrezzo;
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.attrezzo)) {
		return super.toString();
		}
		else
			return "è buio pesto qui";
	}
}
