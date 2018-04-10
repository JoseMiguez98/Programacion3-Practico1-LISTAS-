
public class orderedInsertion implements filtroInsercion {

	public Lista insert(Lista _l, Object o) {
		Lista retorno = _l;
		retorno.sortInsert((Integer)o);
		return retorno;
	}
}
