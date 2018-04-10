
public class ListaDoblementeVinculada extends Lista {

	public ListaDoblementeVinculada() {
		super();
	}

	//Inserta un nuevo nodo/objeto al principio de la lista
	public void insert(Object o) {
		Nodo tmp = new Nodo(o, null);
		tmp.setNext(first);
		//Si el siguiente no es nulo, le asigno un puntero apuntando al nuevo nodo (Osea atras)
		if(tmp.getNext() != null) {
			tmp.getNext().setPrev(tmp);
		}
		//Como el nodo es insertado al principio seteo que su referencia previa es null
		tmp.setPrev(null);
		first = tmp;
		size++;
	}

	//Inserta un elemento al final de la lista
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
			tmp.setPrev(last);
			last = tmp;
			size++;
		}
	}

	//Retorna el objeto del primer nodo y lo elimina
	public Object extract() {
		Object retorno = this.first.getInfo();
		this.first = this.first.getNext();
		if(this.first != null) {
			this.first.setPrev(null);
		}
		size--;
		return retorno;
	}

	//Inserta un Integer ordenado en la lista
	public boolean sortInsert(Integer i) {
		Nodo aux = this.first;
		Nodo nuevo = new Nodo(i, null);

		//Si el primer nodo es nulo (lista vacia) o el primer valor es mayor al nuevo, lo inserto al principio 
		if(aux == null || (Integer)aux.getInfo()>(Integer)nuevo.getInfo()) {
			//			System.out.println(i);
			this.insert(i);
			return true;
		}

		//Mientras el puntero actual apune a un espacio no-nulo sigo preguntando
		while(aux != null) {
			//Pregunto si mi siguiente es nulo o mayor al nuevo parametro
			if(aux.getNext() == null || (Integer)aux.getNext().getInfo() > (Integer)nuevo.getInfo()) {
				//Realizó el debido intercambio de punteros
//				System.out.println(i);
				nuevo.setNext(aux.getNext());
				//Me aseguro que el siguiente de aux no sea nulo, lo que puede llegar a ocurrir en el caso de que el elemento se inserte al final
				if(aux.getNext() != null) {
					aux.getNext().setPrev(nuevo);
				}
				aux.setNext(nuevo);
				nuevo.setPrev(aux);
				size++;
				return true;
			}
			aux = aux.getNext();
		}
		return false;
	}
}
