/**
 * Clase Pila: Implementacion de una Pila LIFO (Last-In, First-Out) personalizada.
 * Los elementos se apilan y desapilan por la cima.
 * 
 * Asignatura: Estructuras de Datos
 * Docente: John Carlos Arrieta Arrieta
 * Estudiante: Cristian Torres
 */
public class Pila {
    private Nodo cima;
    private int tamanio;

    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public int tamanio() {
        return tamanio;
    }

    /**
     * Inserta un elemento en el tope de la pila (apilar / push)
     */
    public void apilar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamanio++;
    }

    /**
     * Extrae y retorna el elemento en el tope de la pila (desapilar / pop)
     */
    public Object desapilar() {
        if (esVacia()) {
            return null;
        }
        Object dato = cima.getDato();
        cima = cima.getSiguiente();
        tamanio--;
        return dato;
    }

    /**
     * Consulta el elemento en la cima sin desapilarlo (peek)
     */
    public Object peek() {
        if (esVacia()) {
            return null;
        }
        return cima.getDato();
    }

    /**
     * Verifica si un elemento se encuentra en la pila
     */
    public boolean contiene(Object dato) {
        return buscar(dato) != null;
    }

    /**
     * Busca un objeto en la pila y retorna su instancia si existe
     */
    public Object buscar(Object dato) {
        if (esVacia() || dato == null) {
            return null;
        }
        Nodo actual = cima;
        while (actual != null) {
            if (dato.equals(actual.getDato())) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Limpia la pila
     */
    public void limpiar() {
        cima = null;
        tamanio = 0;
    }

    /**
     * Muestra los elementos desde la cima hacia la base (del mas reciente al mas antiguo)
     */
    public void mostrar() {
        if (esVacia()) {
            System.out.println("   [Pila vacia - No hay elementos procesados en historial]");
            return;
        }
        Nodo actual = cima;
        int posicion = 1;
        while (actual != null) {
            System.out.println("   Tope " + posicion + " -> " + actual.getDato());
            actual = actual.getSiguiente();
            posicion++;
        }
    }
}
