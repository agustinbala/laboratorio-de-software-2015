package ejercicio3b;

import java.util.Collection;
import java.util.HashSet;

public class HashSetAgregados<E> {
	
	private int cantidadAgregados = 0;
    private HashSet<E> hashSet;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashSetAgregados(HashSet hashSet) {
		this.hashSet = new HashSet(hashSet);
	}

	public void add(E e) {
		cantidadAgregados++;
		hashSet.add(e);
	}


	public void addAll(Collection<? extends E> c) {
		cantidadAgregados += c.size();
		hashSet.addAll(c);
	}

	public int getCantidadAgregados() {
		return cantidadAgregados;
	}


}
