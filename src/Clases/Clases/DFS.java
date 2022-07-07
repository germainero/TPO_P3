package Clases;

import java.util.ArrayList;

public class DFS {

	public static ArrayList<Integer> gradoDeDFS(GrafoDinamic grafo, NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();
		visitarNodoDFS(origen, nodos);
		return nodos;
	}

	public static void visitarNodoDFS(NodoGrafo nodo, ArrayList<Integer> lista) {
		//Lo marco en gris
		nodo.Visitado = true;
		//En aux guardo los adyacentes del nodo con el que convoque al metodo
		NodoArista aux = nodo.lista;

		//Mientras no me quede sin adyacentes
		while (aux != null) {
			if (!aux.apunta.Visitado) {
				//Imprimo el nodo que visito y el que voy a visitar.
				System.out.println("De: "+ aux.origen + " - Voy a: " + aux.apunta.valor);
				//Hago recursiva con el nodo al que apunto.
				visitarNodoDFS(aux.apunta, lista);
			} else {
				aux = aux.sig;
			}
		}
		//Agrego a la salida al nodo (marcar en negro).
		lista.add(nodo.valor);
	}

	public static void main(String[] args) {
		GrafoDinamic grafoDFS = new GrafoDinamic();

		grafoDFS.agregarVertice(1);
		grafoDFS.agregarVertice(2);
		grafoDFS.agregarVertice(3);
		grafoDFS.agregarVertice(4);
		grafoDFS.agregarVertice(5);
		grafoDFS.agregarVertice(6);

		grafoDFS.agregarArista(1, 2, 0);
		grafoDFS.agregarArista(1, 3, 0);
		grafoDFS.agregarArista(3, 4, 0);
		grafoDFS.agregarArista(4, 6, 0);
		grafoDFS.agregarArista(4, 5, 0);

		NodoGrafo origen = grafoDFS.encontrarNodo(1);
		
		System.out.println("¡Esto es DFS!");
		System.out.println("Arranco con: " + origen.valor);
		//Voy a imprimir
		gradoDeDFS(grafoDFS, origen);

	}
}