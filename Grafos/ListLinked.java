package Grafos;

public class ListLinked <T> {
	
	public Node<T> first;
	
	public ListLinked() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	
	public void insertToBegin(T x) {
		this.first = new Node<T>(x, this.first);
	}
	
	public T search(T x) {
		Node<T> aux = this.first;
		while(aux != null && !aux.data.equals(x))
			aux = aux.getNext();
		if(aux != null)
				return aux.data;
		return null;
	}
	
	
	public T remove(T x) {
		T temp = null;
		Node<T> aux = this.first;
		if(this.first != null && this.first.data.equals(x)) {
			temp = this.first.data;
			this.first = this.first.next;
		}
		else {
			while(aux.next != null && aux.next.data.equals(x))
				aux = aux.getNext();
			if(aux.getNext() != null)
				temp = aux.next.data;
				aux.next = aux.next.next;
		}
		return temp;
		
	}
	
	public String toString() {
		String str ="";
		Node<T> aux = this.first;
		while(aux != null) {
			str+="" + aux.getData().toString();
			aux = aux.getNext();
		}
		return str;
	}
}
