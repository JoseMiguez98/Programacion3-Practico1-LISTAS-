
public class Simple extends Lista {

	public Simple() {
		super();
	}

	public void insert(Object o) {
		Nodo tmp = new Nodo(o, null);
		tmp.setNext(first);
		first = tmp;
		size++;
	}
	
	public void insertFinal(Object o) {
		//Seteo un puntero apuntando al final de la lista
		this.setLast();
		//Si el last es nulo inserto el elemento de una
		if(this.last == null) {
			this.insert(o);
		}
		
		//Si no lo inserto al final de la lista
		else {
			Nodo tmp = new Nodo(o, null);
			this.last.setNext(tmp);
			last = tmp;
			size++;
		}
	}

	public Object extract() {
		Object retorno = this.first.getInfo();
		this.first = this.first.getNext();
		size--;
		return retorno;
	}
	
	//Hacer refactor para que inserte Object ordenado en lugar de solo Integer
	public boolean sortInsert(Integer i) {
		Nodo aux = this.first;
		Nodo nuevo = new Nodo(i, null);

		//Si el primer nodo es nulo (lista vacia) o el primer valor es mayor al nuevo, lo inserto al principio 
		if(aux == null || (Integer)aux.getInfo()>(Integer)nuevo.getInfo()) {
			this.insert(i);
			return true;
		}

		//Mientras el puntero actual apune a un espacio no-nulo sigo preguntando
		while(aux != null) {
			//Pregunto si mi siguiente es nulo o mayor al nuevo parametro
			if(aux.getNext() == null || (Integer)aux.getNext().getInfo() > (Integer)nuevo.getInfo()) {
				//Realizó el debido intercambio de punteros
				nuevo.setNext(aux.getNext());
				aux.setNext(nuevo);
				size++;
				return true;
			}
			aux = aux.getNext();
		}
		return false;
	}
	
	//Setea un puntero al final de la lista
}
