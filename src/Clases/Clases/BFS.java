package Clases;

import java.util.ArrayList;

public class BFS {

	public static ArrayList<Integer> gradoDeBFS(GrafoDinamic grafo, NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();
		visitarNodoBFS(origen, nodos);
		return nodos;
	}

	public static void visitarNodoBFS(NodoGrafo nodo, ArrayList<Integer> lista) {
		//Genero la adyacencia del nodo con el que entre en AUX
		NodoArista aux = nodo.lista;
		//Si no fue visitado el nodo con el que arranco (marcado en gris) lo marco en gris, y lo agrego a la lista.
		if (!nodo.Visitado) {
			nodo.Visitado = true;
			lista.add(nodo.valor);
		}
		//Si tengo adyacencias del nodo (linea 15)
		while (aux != null) {
			//Me fijo si esta visitado (marcado en gris).
			if (!aux.apunta.Visitado) {
				//Si no está visitado, lo marco.
				aux.apunta.Visitado = true;
				//Lo agrego a la lista
				lista.add(aux.apunta.valor);
				//Imprimo el nodo y el padre
				System.out.println("Del nodo: " + aux.apunta.valor + " - El padre es el: " + aux.origen + ". ");
				
			}
			//Me voy al siguiente de mi cola! (que es el auxiliar que usa BFS)
			aux = aux.sig;
		}
		//Entonces del siguiente vuelvo a generar la lista
		aux = nodo.lista;
		//Si tiene adyacencias vuelvo a entrar
		while (aux != null) {
			//Si no esta visitado, vuelvo a llamar al metodo
			if (!aux.Visitado) {
				aux.Visitado = true;
				visitarNodoBFS(aux.apunta, lista);
			}
			//Si fue visitado, llamo al siguiente
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