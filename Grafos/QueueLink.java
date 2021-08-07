package Grafos;

public class QueueLink<E>{
	
	private Node<E> front;
	private Node<E> back;
	
	public QueueLink() {
		this.front = this.back = null;
	}
	public boolean isEmpty() {
		return this.front == null;
	}
	public void enqueue(E x) {
		Node<E> temp = new Node<E>(x);
		if (this.back == null) { 
			this.front = this.back = temp;
		}
		else {
			this.back.setNext(temp);
			this.back = temp;
		}
			
	}
	public E dequeue(){
		if(this.isEmpty())
			System.out.println("Error cola vacia...");
		E aux = this.front.getData();
		this.front = this.front.getNext();
		return aux;
		
	}
	public E front(){
		if(this.isEmpty())
			System.out.println("Error cola vacia...");
		return this.front.getData();
		
	}
	public E back() {
		if(this.isEmpty())
			System.out.println("Error cola vacia...");
		return this.back.getData();
	}
	
	public String toString() {
		Node<E> aux = this.front;
		String str = "Front: " + this.front +"\nBack: " + this.back +"\n";
		for(; aux != null; aux = aux.getNext()) {
			str += aux.getData() + " ";
		}
		return str;
	}

}