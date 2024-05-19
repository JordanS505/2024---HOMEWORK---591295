package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class comparatoreAttrezziPeso implements Comparator<Attrezzo>{

	public int compare(Attrezzo uno, Attrezzo due) {
		if(uno.getPeso()-due.getPeso()==0)
			return uno.getNome().compareTo(due.getNome());
		return uno.getPeso()-due.getPeso();
	}
	
}
