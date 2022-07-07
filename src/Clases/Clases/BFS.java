package Clases;

import java.util.ArrayList;

public class BFS {

	public static ArrayList<Integer> gradoDeBFS(GrafoDinamic grafo, NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();
		visitarNodoBFS(origen, nodos);
		return nodos;
	}

	public static void visitarNodoBFS(NodoGrafo nodo, ArrayList<Integer> lista) {
		NodoArista aux = nodo.lista;
		if (!nodo.Visitado) {
			nodo.Visitado = true;
			lista.add(nodo.valor);
		} 
		while (aux != null) {
			if (!aux.apunta.Visitado) {
				aux.apunta.Visitado = true;
				lista.add(aux.apunta.valor);
				//Imprimo el nodo y el padre
				System.out.println("Del nodo: " + aux.apunta.valor + " - El padre es el: " + aux.origen + ". ");
				
			} 
			aux = aux.sig;
		} 
		aux = nodo.lista;
		while (aux != null) {
			if (!aux.Visitado) {
				aux.Visitado = true;
				visitarNodoBFS(aux.apunta, lista);
			}
			aux = aux.sig; 
		}

	}

	public static void main(String[] args) {
		GrafoDinamic grafoBFS = new GrafoDinamic();

		//Hago un ejemplo con 4 nodos, bien simple para ver si funciona. Son ida y vuelta! O no tienen dirección.

		grafoBFS.agregarVertice(1); //S es 1, W es 2, R es 3 y V es 4
		grafoBFS.agregarVertice(2);
		grafoBFS.agregarVertice(3);
		grafoBFS.agregarVertice(4);

		grafoBFS.agregarArista(1, 2, 0);
		grafoBFS.agregarArista(2, 1, 0);

		grafoBFS.agregarArista(1, 3, 0);
		grafoBFS.agregarArista(3, 1, 0);

		grafoBFS.agregarArista(3, 4, 0);
		grafoBFS.agregarArista(4, 3, 0);

		grafoBFS.agregarArista(2, 4, 0);
		grafoBFS.agregarArista(4, 2, 0);

		NodoGrafo origen = grafoBFS.encontrarNodo(1);

		System.out.println("¡Esto es BFS!");
		System.out.println("Origen de BFS: " + origen.valor);
		gradoDeBFS(grafoBFS, origen);
	}
}