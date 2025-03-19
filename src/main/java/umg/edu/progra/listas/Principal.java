package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
        
        lista.visualizar();        
        
        
        System.out.println("\n");
        System.out.println("primero: " + lista.leerPrimero());
        
        
        
        lista.eliminar(3);
        System.out.println("lista: " + lista);
        
        System.out.println("\n");
        
        Nodo dato = lista.buscarLista(4);  
        System.out.println("dato: " + dato);
        
        lista.insertarLista(dato, 10);
        System.out.println("lista " + lista);
        
        dato = lista.buscarLista(5);        
        System.out.println("dato " + dato);
        lista.insertarLista(dato, 600);
        
        System.out.println("lista " + lista);
        
        lista.visualizar();
 
        /** Resolver lo que se solicita a continuacion **/

        //* Ejercicio 1: Ordernar la lista de forma ascendente
        lista.ordenarAscendente();
        System.out.println("Lista ordenada");
        lista.visualizar();
        System.out.println("\n");
        
        
        // * Ejercicio 2: Unir dos listas enlazadas
        // crear la segunda lista (otra) que recibe como parametro el metodo
        Lista lista2 = new Lista();
        lista2.insertarCabezaLista(20);
        lista2.insertarCabezaLista(43);
        lista2.insertarCabezaLista(50);
        lista2.insertarCabezaLista(60);

        lista.unirListas(lista2);
        System.out.println("lista despues de unirla con otra lista");
        lista.visualizar();
        System.out.println("\n");


        //* Ejercicio 3: Separa numeros pares e impares en dos listas enlazadas diferentes
        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();
        lista.separarParesImpares(listaPares, listaImpares);
        
        System.out.println("Lista de pares:");
        listaPares.visualizar();
        System.out.println("\nLista de impares:");
        listaImpares.visualizar();
        System.out.println("\n");

        
        /*** Fin de los ejercicios ***/
        
        
        // de forma ascendente
        System.out.println("\nLista invertida");
        lista.invertirLista();
        System.out.println("\nResultado de la lista invertida:");
        lista.visualizar();
    }

}
