package Grafos;

public class Arista<T> {
	
	protected Vertice<T> refDestino;
	protected int peso;
	protected int label; //0=inexplorada, 1=descubierta, 2=back v cross
	
	public Arista(Vertice<T> refDestino) {
		this(refDestino,-1);
	}
	
	public Arista(Vertice<T> refDestino, int peso) {
		this.refDestino = refDestino;
		this.peso = peso;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Vertice<?>) {
			Arista<T> v = (Arista<T>) obj;
			return this.refDestino.equals(v.refDestino);
		}
		return false;
	}
	
	public String toString() {
		if(this.peso > -1) return this.refDestino.data + "[" + this.peso + "], ";
		else return refDestino.data + ", ";
	}

}
