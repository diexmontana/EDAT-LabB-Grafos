package Grafos;

public class GraphLink<T> {
	
	protected ListLinked<Vertice<T>> listVertice;
	
	public GraphLink() {
		this.listVertice = new ListLinked<Vertice<T>>();
	}
	
	public void insertVertice(T data) {
		//Encapsulamos el dato en un vertice
		Vertice<T> nuevo = new Vertice<T>(data);
		if (this.listVertice.search(nuevo) != null) {
			System.out.println("Vertice ya fue insertado anteriormente...");
			return;
		}
		this.listVertice.insertToBegin(nuevo);
	}
	
	
	public void insertArista(T verOrigen, T verDestino) {
		//Encapsulamos los datos en vertices
		Vertice<T> refOrigen = this.listVertice.search(new Vertice<T>(verOrigen));
		Vertice<T> refDestino = this.listVertice.search(new Vertice<T>(verDestino));
		
		if(refOrigen == null || refDestino == null) {
			System.out.println("Vertice origen y/o destino no existen...");
			return;
		}
		if(refOrigen.listAdy.search(new Arista<T>(refDestino)) != null) {
			System.out.println("Arista ya fue insertada anteriormente");
		}
		refOrigen.listAdy.insertToBegin(new Arista<T>(refDestino));
		refDestino.listAdy.insertToBegin(new Arista<T>(refOrigen));
	}
	
	public String toString() {
		return this.listVertice.toString();
	}
	
	private void initLabel() {
		Node<Vertice<T>> auxNodeV = this.listVertice.first;
		for(; auxNodeV != null; auxNodeV = auxNodeV.getNext()) {
			auxNodeV.data.label = 0;//Se inicializa vertices
			Node<Arista<T>> auxNodeAr = auxNodeV.data.listAdy.first;
			for(; auxNodeAr != null; auxNodeAr = auxNodeAr.getNext())
				auxNodeAr.data.label = 0;// Se inicializa aristas
		}
	}
	
	public void DFS(T data) {
		Vertice<T> vertV = this.listVertice.search(new Vertice<T>(data));
		if(vertV == null) {
			System.out.println("Vertice no existe para hacer DFS");
			return;
		}
		initLabel();
		DFSRec(vertV);
	}
	
	private void DFSRec(Vertice<T> vertV) {
		vertV.label = 1;//El vertice enviado se marca como visitado
		System.out.print(vertV.data + ", ");
		Node<Arista<T>> nodeAr = vertV.listAdy.first;
		for(; nodeAr != null; nodeAr = nodeAr.getNext()) {
			if(nodeAr.data.label == 0) {
				Vertice<T> vertW = nodeAr.data.refDestino;//opuesto
				if(vertW.label == 0) {
					nodeAr.data.label = 1;//La arista se marca como descubierta
					DFSRec(vertW);
				}
				else
					nodeAr.data.label = 2;
			}
		}
	}
	
	public void BFS(T data) {
		Vertice<T> vertV = this.listVertice.search(new Vertice<T>(data));
		if(vertV == null) {
			System.out.println("Vertice no existe para hacer DFS");
			return;
		}
		initLabel();
		BFS(vertV);
	}
	
	
	//metodo incompleto
	private void BFS(Vertice<T> vertV) {
		QueueLink<Vertice<T>> cola = new QueueLink<Vertice<T>>();
		cola.enqueue(vertV);
		vertV.label = 1;//El vertice enviado se marca como visitado
		System.out.print(vertV.data + ", ");

		while(!cola.isEmpty()) {//tendria que iterar entre colas
			Vertice<T> auxV = cola.dequeue();
			Node<Arista<T>> nodeAr = auxV.listAdy.first;
			for(; nodeAr != null; nodeAr = nodeAr.getNext()) {
				Vertice<T> vertW = nodeAr.data.refDestino;//opuesto
				if(vertW.label == 0) {
					nodeAr.data.label = 1;//La arista se marca como descubierta
					auxV.label = 1;
					//tendria que insertar en un nueva cola
				}
				else
					nodeAr.data.label = 2;
			}
		}
	}
	

}
