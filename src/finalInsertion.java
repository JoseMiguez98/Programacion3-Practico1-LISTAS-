
public class finalInsertion implements filtroInsercion {
	
	public Lista insert(Lista _l, Object o) {
		Lista retorno = _l;
		retorno.insertFinal(o);
		return retorno;
	}
}
