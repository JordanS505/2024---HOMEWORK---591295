package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		Borsa b= new Borsa();
		Attrezzo a=new Attrezzo("tv",5);
		b.addAttrezzo(a);
		Attrezzo d=new Attrezzo("bastone",2);
		b.addAttrezzo(d);
		Attrezzo e= new Attrezzo("tavolo",10);
		b.addAttrezzo(e);
		Attrezzo o= new Attrezzo("osso",3);
		b.addAttrezzo(o);
		Attrezzo k = new Attrezzo("key",1);
		b.addAttrezzo(k);
		SortedSet<Attrezzo> c=new TreeSet<>();
		c=b.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> i= c.iterator();
		assertSame(k,i.next());
		assertSame(d,i.next());
		assertSame(o,i.next());
		assertSame(a,i.next());
		assertSame(e,i.next());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		Borsa b= new Borsa();
		Attrezzo a=new Attrezzo("tv",5);
		b.addAttrezzo(a);
		Attrezzo d=new Attrezzo("bastone",2);
		b.addAttrezzo(d);
		Attrezzo e= new Attrezzo("tavolo",10);
		b.addAttrezzo(e);
		Attrezzo o= new Attrezzo("osso",3);
		b.addAttrezzo(o);
		Attrezzo k = new Attrezzo("key",1);
		b.addAttrezzo(k);
		List<Attrezzo> c=new ArrayList<>();
		c=b.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> i= c.iterator();
		assertSame(k,i.next());
		assertSame(d,i.next());
		assertSame(o,i.next());
		assertSame(a,i.next());
		assertSame(e,i.next());
	}

	@Test
	public void testGetContenutoOrdinatoPerNome() {
		Borsa b= new Borsa();
		Attrezzo a=new Attrezzo("tv",5);
		b.addAttrezzo(a);
		Attrezzo d=new Attrezzo("bastone",2);
		b.addAttrezzo(d);
		Attrezzo e= new Attrezzo("tavolo",10);
		b.addAttrezzo(e);
		Attrezzo o= new Attrezzo("osso",3);
		b.addAttrezzo(o);
		Attrezzo k = new Attrezzo("key",1);
		b.addAttrezzo(k);
		SortedSet<Attrezzo> c=new TreeSet<>();
		c=b.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> i= c.iterator();
		assertSame(d,i.next());
		assertSame(k,i.next());
		assertSame(o,i.next());
		assertSame(e,i.next());
		assertSame(a,i.next());
	}

	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Borsa b= new Borsa();
		Attrezzo a=new Attrezzo("tv",5);
		b.addAttrezzo(a);
		Attrezzo d=new Attrezzo("bastone",2);
		b.addAttrezzo(d);
		Attrezzo e= new Attrezzo("tavolo",10);
		b.addAttrezzo(e);
		Attrezzo o= new Attrezzo("osso",2);
		b.addAttrezzo(o);
		Attrezzo k = new Attrezzo("key",1);
		b.addAttrezzo(k);
		Map<Integer,Set<Attrezzo>> c=new TreeMap<>();
		c=b.getContenutoRaggruppatoPerPeso();
		for(Integer p : c.keySet()) {
			System.out.println(p +" "+ c.get(p));
		}
	}

}
