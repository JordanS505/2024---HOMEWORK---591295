package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.comparatoreAttrezziPeso;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List <Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi =new ArrayList<Attrezzo>();//easterEgg...
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.add(attrezzo);
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (Attrezzo attrezzo : this.attrezzi)
			if (attrezzo.getNome().equals(nomeAttrezzo))
				a = attrezzo;

		return a;
	}
	
	public int getPeso() {
		int pesoTotale = 0;
		for(Attrezzo a : this.attrezzi)
		pesoTotale += a.getPeso();
		return pesoTotale;
	}
	
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		Iterator<Attrezzo> iteratore =this.attrezzi.iterator();
		while (iteratore.hasNext()) {
			a = iteratore.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				iteratore.remove();
				return a;
		}
		}
		return null;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (Attrezzo attrezzo:this.attrezzi)
				s.append(attrezzo.getNome().toString()+" ");
		}
		else
			s.append("Borsa vuota\n");
		return s.toString();
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		comparatoreAttrezziPeso cap= new comparatoreAttrezziPeso();
		SortedSet <Attrezzo> s =new TreeSet<Attrezzo>(cap);
		s.addAll(this.attrezzi);
		return s;
	}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi);
		Collections.sort(l,new comparatoreAttrezziPeso());
		return l;
		
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> s = new TreeSet<>();
		s.addAll(this.attrezzi);
		return s;
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> m=new TreeMap<>();
		for(Attrezzo a:this.attrezzi) {
			if(m.containsKey(a.getPeso()))
				m.get(a.getPeso()).add(a);
			else {
				Set<Attrezzo> s= new TreeSet<>();
				s.add(a);
				m.put(a.getPeso(), s);
			}
		}
		return m;
	}
}