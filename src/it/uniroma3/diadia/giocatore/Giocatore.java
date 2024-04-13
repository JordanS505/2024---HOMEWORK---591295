package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	
	public Borsa borsa;
	private int cfu;
	static final private int CFU_INIZIALI = 2;
	
	public Giocatore() {
		this.borsa= new Borsa();
		this.cfu = CFU_INIZIALI;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
	
	public boolean prendi(Attrezzo attrezzo) {
		if(borsa.addAttrezzo(attrezzo))
			return true;
			else			
				return false;
	}
	
	public boolean posa(Attrezzo attrezzo) {
		return false;
	}
	
}
