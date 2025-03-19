package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }


    //Ordenar ascendente
    public void ordenarAscendente() {
        if (primero == null || primero.enlace == null) return;
        boolean swapped;
        do {
            swapped = false;
            Nodo actual = primero;
            while (actual.enlace != null) {
                if (actual.dato > actual.enlace.dato) {
                    int temp = actual.dato;
                    actual.dato = actual.enlace.dato;
                    actual.enlace.dato = temp;
                    swapped = true;
                }
                actual = actual.enlace;
            }
        } while (swapped);
    }


    //Metodo para unir dos listas enlazadas
    public void unirListas(Lista otra){
        if (primero == null) {
            primero = otra.primero;
        }else {
            Nodo actual = primero;
            while (actual.enlace != null) {
                actual = actual.enlace;
            }
            actual.enlace = otra.primero;
        }
    }

    //Metodo separar pares e impares
    public void separarParesImpares(Lista pares, Lista impares) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.dato % 2 == 0) {
                pares.insertarCabezaLista(actual.dato);
            } else {
                impares.insertarCabezaLista(actual.dato);
            }
            actual = actual.enlace;
        }
    }

    /*** Crear los metodos que se solicitan ***/

    //1 - Método para invertir la lista enlazada
    public void invertirLista() {
        Nodo actual = primero, previo = null, siguiente;
        while (actual != null){
            siguiente = actual.enlace;
            actual.enlace = previo;
            previo = actual;
            actual = siguiente;
        }
        primero = previo;
    }

    //* 2 - Método para obtener el elemento en la posición n desde el final
    public Nodo obtenerDesdeFinal(int n){
        Nodo mainPtr = primero;
        Nodo refPtr = primero;
        int count = 0;
        while (count < n) {
            if (refPtr == null) return null;
            refPtr = refPtr.enlace;
            count++;            
        }
        while (refPtr != null) {
            mainPtr = mainPtr.enlace;
            refPtr = refPtr.enlace;
        }
        return mainPtr;
    }

    //* 3 - Método para eliminar duplicados en una lista enlazada
	public void eliminarDuplicados(){
        Nodo actual = primero;
        while (actual != null && actual.enlace != null){
            Nodo temp = actual;
            while (temp.enlace != null){
                if (actual.dato == temp.enlace.dato){
                    temp.enlace = temp.enlace.enlace;
                }else{
                    temp = temp.enlace;
                }
            }
            actual = actual.enlace;
        }
    }

    //* 4 - Método para obtener el tamaño de la lista enlazada
    public int obtenerTamano(){
        int count = 0;
        Nodo actual = primero;
        while (actual != null){
            count++;
            actual = actual.enlace;
        } 
        return count;
    }
    
    /*** finaliza metodos que se solicitados ***/
    
}
