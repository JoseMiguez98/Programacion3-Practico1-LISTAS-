public class Nodo {
	private Object info;
	private Nodo next;
	private Nodo prev;
	
	public Nodo() {
		info = null;
		next = null;
		prev = null;
	}
	
	public Nodo(Object o, Nodo n) {
		setInfo(o);
		setNext(n);
	}
	public void setInfo(Object o) {
		info = o;
	}
	
	public void setPrev(Nodo n) {
		prev = n;
	}
	
	public void setNext(Nodo n) {
		next = n;
	}
	public Object getInfo() {
		return info;
	}
	public Nodo getNext() {
		return next;
	}
	public Nodo getPrev() {
		return prev;
	}
}