public abstract class Lista {

	protected Nodo first;
	protected Nodo last;
	protected Integer size;

	public Lista() {
		size = 0;
		first = null;
		last = null;
	}

	//Inserta un nuevo nodo/objeto al principio de la lista
	public abstract void insert(Object o);

	//Inserta un nuevo nodo/objeto al final de lista
	public abstract void insertFinal(Object o);

	//Retorna el objeto del primer nodo y lo elimina
	public abstract Object extract();

	//Inserto un Integer ordeado en la lista
	public abstract boolean sortInsert(Integer i);

	//Imprime un entero pasado por parametro
	public void print(int n) {
		System.out.print(n);
	}

	//Retorna true si la lista esta vacia o false en caso contrario
	public boolean isEmpty() { 
		return this.first.getInfo().equals(null);
	}

	//Retorna el tamaño de la lista;
	public int size () {
		return this.size;
	}

	//Retorna true si existe el objeto dado o false en caso contrario
	public boolean contains(Object o) {
		Nodo aux = this.first;
		//Mientras el auxiliar sea distinto de null voy a seguir preguntando
		while(aux != null) {
			//Si encuentro el objeto retorno true
			if(aux.getInfo().equals(o)) {
				return true;
			}
			//Si no, auxiliar apunta al siguiente nodo
			aux = aux.getNext();
		}
		//Retorno false en caso de que el objeto no exista en la lista
		return false;
	}

	public Integer findMaxPosition() {
		//Declaro las variables locales/auxiliares
		Integer pos = 1;
		Integer pos_actual = 1;
		Nodo aux = this.first;
		//Inicializo max con el valor del primer nodo para comenzar a comparar
		Integer max = (Integer)this.first.getInfo();

		//Mientras auxiliar sea distinto de null sigo preguntando por el mayor
		while(aux != null) {
			//Pregunto si el valor del nodo actual es mayor que el maximo
			if((Integer)aux.getInfo() > max) {
				//En caso de ser TRUE igualo max al valor del nodo actual
				max = (Integer)aux.getInfo();
				//Almaceno la posicion
				pos = pos_actual;;
			}
			//Aumento la posicion actual
			pos_actual++;
			//Igualo auxiliar al next asi apunta al siguiente nodo
			aux = aux.getNext();
		}

		//Retorno la posición del mayor elemento
		return pos;
	}

	
	//Setea un puntero apuntando al ultimo nodo de la lista
	public void setLast() {
		Nodo aux = new Nodo();
		aux = first;

		while (aux != null && aux.getNext() != null) {
			aux = aux.getNext();
		}

		this.last = aux;
	}
	
	//Retorna TRUE si la lista esta ordenada
	public boolean isOrdered(){
		Nodo aux = new Nodo();
		aux = first;
		
		if(aux == null) {
			return true;
		}
		
		while(aux.getNext() != null) {
			if((Integer)aux.getInfo() > (Integer)aux.getNext().getInfo()) {
				return false;
			}
			aux = aux.getNext();
		}
		
		return true;
	}
}