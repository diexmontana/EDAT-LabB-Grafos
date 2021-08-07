package Grafos;

public class Vertice<T> {
	
	protected T data;
	protected ListLinked<Arista<T>> listAdy;
	protected int label; //0=no visitado, 1=visitado
	
	public Vertice(T data) {
		this.data = data;
		this.listAdy = new ListLinked<Arista<T>>();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vertice<?>) {
			Vertice<T> v = (Vertice<T>) obj;
			return this.data.equals(v.data);
		}
		return false;
	}
	
	public String toString() {
		return this.data + "-->" + this.listAdy.toString() + "\n";
 	}

}
