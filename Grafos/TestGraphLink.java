package Grafos;

public class TestGraphLink {

	public static void main(String[] args) {
		
		GraphLink<String> grafo = new GraphLink<String>();
		
		grafo.insertVertice("F");
		grafo.insertVertice("E");
		grafo.insertVertice("D");
		grafo.insertVertice("C");
		grafo.insertVertice("B");
		grafo.insertVertice("A");
		
		grafo.insertArista("F", "D");
		grafo.insertArista("F", "C");
		grafo.insertArista("E", "C");
		grafo.insertArista("E", "B");
		grafo.insertArista("D", "C");
		grafo.insertArista("D", "A");
		grafo.insertArista("C", "B");
		grafo.insertArista("C", "A");
		grafo.insertArista("B", "A");
		
		System.out.println(grafo);
		
		grafo.DFS("A");
	}

}
