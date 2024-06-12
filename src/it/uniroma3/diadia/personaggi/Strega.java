package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.partita.Partita;

public class Strega extends AbstractPersonaggio{
	private String msg_nonSalutata="Che impertinente!\nNemmeno un saluto?\nSparisci dalla mia vista!";
	private String msg_Salutata="Che brava persona che sei!\nTi faro' un piacere!";
	private String[] array= {"nord","sud","est","ovest"};
	private String MESSAGGIO_REGALO="AHAHAHAHAHAHAHAHAH! Ben fatto, ora questo oggetto sarà mio per sempre, spero non fosse importante!";
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.haSalutato) {
			msg=msg_Salutata;
			int max=0;
			Stanza stanza=partita.getStanzaCorrente();
			for(int i=0;i<array.length;i++) {
				if(max<partita.getStanzaCorrente().getStanzaAdiacente(array[i]).getAttrezzi().size()) {
					max=partita.getStanzaCorrente().getStanzaAdiacente(array[i]).getAttrezzi().size();
					stanza=partita.getStanzaCorrente().getStanzaAdiacente(array[i]);
				}
			}
			partita.setStanzaCorrente(stanza);
			return msg;
		}
		else {
			msg=msg_nonSalutata;
			int min=20;
			Stanza stanza=partita.getStanzaCorrente();
			for(int i=0;i<array.length;i++) {
				if(min>partita.getStanzaCorrente().getStanzaAdiacente(array[i]).getAttrezzi().size()) {
					min=partita.getStanzaCorrente().getStanzaAdiacente(array[i]).getAttrezzi().size();
					stanza=partita.getStanzaCorrente().getStanzaAdiacente(array[i]);
				}
			}
			partita.setStanzaCorrente(stanza);
			return msg;
		}
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return MESSAGGIO_REGALO;
	}

}
