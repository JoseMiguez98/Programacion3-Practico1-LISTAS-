import java.util.LinkedList;

public class Sistema {
	public static void main(String[] args) {
		////////////////////////////////////////////////
		//-Ejercicio 2
		/////////////////////////////////////////////
		//		Object[] miarreglo = new Object[20];
		//		long tiempo_total;
		//		long tiempo_inicio = System.nanoTime();

		//Comparación de tiempo en insertar un elemento en lista y un array

		//		tiempo_total = System.nanoTime() - tiempo_inicio;
		//
		//		System.out.println("La inserción de un nuevo elemento en la lista tardo " + tiempo_total + " nano-segundos");
		//
		//		tiempo_inicio = System.nanoTime();
		//
		//		for(int i = 0; i<miarreglo.length ; i++) {
		//			miarreglo[i] = i;	
		//		}
		//		tiempo_total = System.nanoTime() - tiempo_inicio;
		//
		//		System.out.println("La inserción de un nuevo elemento en el arreglo tardo " + tiempo_total + " nano-segundos");
		//
		//		///////////////////////////////////////////////////////////////////////
		//		//Compara tiempo de busqueda de un elemento en lista y array

		//		tiempo_inicio = System.nanoTime();
		//		
		//		milista.contains("hola");
		//		
		//		tiempo_total = System.nanoTime() - tiempo_inicio;
		//		
		//		System.out.println("La busqueda del elemento en la lista tardo " + tiempo_total + " nano-segundos");
		//		
		//		tiempo_inicio = System.nanoTime();
		//		
		//		arrayContains(miarreglo, 2);
		//		
		//		tiempo_total = System.nanoTime() - tiempo_inicio;
		//		
		//		System.out.println("La busqueda del elemento en el array tardo " + tiempo_total + " nano-segundos");
		//		
		//		///////////////////////////////////////////////////////////////////////////////////////////////////
		//		//Compara tiempo que tarda en obtener la cantidad de elementos de lista y array
		//		
		//		tiempo_inicio = System.nanoTime();
		//		
		//		milista.size();
		//		
		//		tiempo_total = System.nanoTime() - tiempo_inicio;
		//		
		//		System.out.println("Determinar la cantidad de elementos en la lista tardo " + tiempo_total + " nano-segundos");
		//		
		//		tiempo_inicio = System.nanoTime();
		//		
		//		int tamanio = miarreglo.length;
		//		
		//		tiempo_total = System.nanoTime() - tiempo_inicio;
		//		
		//		System.out.println("Determinar la cantidad de elementos en el array tardo " + tiempo_total + " nano-segundos");
		
		Lista milista = new ListaDoblementeVinculada();
		Lista milista2 = new ListaDoblementeVinculada();

		milista.insertFinal(22);
		milista.insertFinal(44);
		milista.insertFinal(54);
		milista.insertFinal(66);
		milista.insertFinal(93);
		milista.insertFinal(94);
		milista.insertFinal(105);
		milista.insertFinal(111);
		milista.insertFinal(116);
		milista.insertFinal(128);
		milista.insertFinal(139);
		
		milista2.insertFinal(44);
		milista2.insertFinal(63);
		milista2.insertFinal(94);
		milista2.insertFinal(95);
		milista2.insertFinal(111);
		milista2.insertFinal(128);
		milista2.insertFinal(133);
		milista2.insertFinal(136);
		milista2.insertFinal(157);
		milista2.insertFinal(204);
		
		Lista milistacomun = getSortedListCommonElements(milista, milista2);

		Integer size = milistacomun.size();
		
//		System.out.println(size);
		
		for(int i = 0 ; i<size ; i++) {
			System.out.println(milistacomun.extract());
		}
	}

	//Retorna true si el objeto existe en un array dado o false en caso contrario
	public static boolean arrayContains(Object[]a, Object o) {
		for(int i = 0 ; i<a.length ; i++) {
			if(a[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	//Dada 2 listas retorna 1 con los elementos en comun ordenados
	public static Lista getSortedListCommonElements(Lista _l1, Lista _l2) {
		Lista retorno = new ListaDoblementeVinculada();
		Integer size = _l1.size();
		Object o = null;
		//Utilizo un filtro (Strategy) para determinar que algoritmo de insercion utilizar dependiendo si la lista esa o no ordenada
		filtroInsercion filtro = null;
		
		//Seteo el filtro
		if(_l1.isOrdered()) {
			filtro = new finalInsertion();
		}
		
		else {
			filtro = new orderedInsertion();
		}

			//Paso los elementos en comun hacia otra lista nueva
			for(int i = 0; i<size ; i++) {
				o = _l1.extract();
				if(_l2.contains(o)) {
					//Le digo al filtro que inserte la el elemento en la lista
					filtro.insert(retorno, o);
				}
			}
		//Ordeno los elementos y retorno la lista
		return retorno;
	}

	//Dada 2 listas retorna una nueva con los elementos que estan en la primera pero no en la segunda
	public static Lista getElementsFirstNoSecond(Lista _l1, Lista _l2) {
		Object o = null;
		Lista retorno = new Simple();
		//El size es del tamaño de la primera lista ya que es la que necesito recorrer completa
		Integer aux_size = _l1.size();

		for(int i = 0 ; i<aux_size ; i++) {
			o = _l1.extract();
			//Si la segunda lista no contiene el Object o, lo agrego a la lista de retorno
			if(!_l2.contains(o)) {
				retorno.insert(o);
			}
		}

		return retorno;
	}

	//Dada 2 listas retorna una nueva con los elementos que estan en la primera pero no en la segunda JAVA-LinkedList
	public static LinkedList<Object> getElementsFirstNoSecondJAVA(LinkedList<Object> _l1, LinkedList<Object> _l2) {
		Object o = null;
		LinkedList<Object> retorno = new LinkedList<Object>();
		//El size es del tamaño de la primera lista ya que es la que necesito recorrer completa
		Integer aux_size = _l1.size();

		for(int i = 0 ; i<aux_size ; i++) {
			o = _l1.poll();
			//Si la segunda lista no contiene el Object o, lo agrego a la lista de retorno
			if(!_l2.contains(o)) {
				retorno.add(o);
			}
		}

		return retorno;
	}

	public static boolean esPalindroma(String _s) {
		//Convierto la cadena de texto a minusculas para que no haya errores en la comparacaíon de caracteres
		String word = _s.toLowerCase();
		//Incicializo un indice al principio(i) y otro al final de la cadena(j)
		Integer i = 0;
		Integer j = word.length()-1;

		//Mientras j no se cruze con i sigo preguntando
		while (j>i) {
			//Si alguna comparación retorna FALSE, corto la busqueda y retorno FALSE
			if(word.charAt(i) != word.charAt(j)) {
				return false;
			}
			//Muevo los indices
			i++;
			j--;
		}
		//Retorno TRUE en caso de que todas las comparaciones hayan sido TRUE
		return true;
	}
}