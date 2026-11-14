/**
 * Clase Lista: Implementacion de una Lista Doblemente Enlazada personalizada.
 * Permite inserciones al inicio, final y en posicion arbitraria,
 * asi como recorridos bidireccionales (hacia adelante y hacia atras).
 * 
 * Asignatura: Estructuras de Datos
 * Docente: John Carlos Arrieta Arrieta
 * Estudiante: Cristian Torres
 */
public class Lista {
    private Nodo cabeza;
    private Nodo cola;
    private int tamanio;

    public Lista() {
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    public boolean esVacia() {
        return cabeza == null;
    }

    public int cuentaElementos() {
        return tamanio;
    }

    /**
     * Agrega un elemento al final de la lista
     */
    public void agregar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamanio++;
    }

    /**
     * Agrega un elemento al inicio de la lista
     */
    public void agregarAlInicio(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        tamanio++;
    }

    /**
     * Agrega un elemento en una posicion especifica (0-based)
     */
    public boolean agregarEnPosicion(int indice, Object dato) {
        if (indice < 0 || indice > tamanio) {
            System.out.println("[Error] Indice fuera de rango: " + indice);
            return false;
        }
        if (indice == 0) {
            agregarAlInicio(dato);
            return true;
        }
        if (indice == tamanio) {
            agregar(dato);
            return true;
        }

        Nodo nuevo = new Nodo(dato);
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        Nodo previo = actual.getAnterior();
        previo.setSiguiente(nuevo);
        nuevo.setAnterior(previo);
        nuevo.setSiguiente(actual);
        actual.setAnterior(nuevo);
        tamanio++;
        return true;
    }

    /**
     * Elimina el primer elemento de la lista y lo retorna
     */
    public Object eliminarPrimero() {
        if (esVacia()) {
            return null;
        }
        Object dato = cabeza.getDato();
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }

    /**
     * Elimina el ultimo elemento de la lista y lo retorna
     */
    public Object eliminarUltimo() {
        if (esVacia()) {
            return null;
        }
        Object dato = cola.getDato();
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return dato;
    }

    /**
     * Elimina el elemento en una posicion especifica
     */
    public Object eliminarEnPosicion(int indice) {
        if (indice < 0 || indice >= tamanio || esVacia()) {
            return null;
        }
        if (indice == 0) {
            return eliminarPrimero();
        }
        if (indice == tamanio - 1) {
            return eliminarUltimo();
        }

        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }

        Object dato = actual.getDato();
        Nodo previo = actual.getAnterior();
        Nodo posterior = actual.getSiguiente();

        previo.setSiguiente(posterior);
        posterior.setAnterior(previo);
        tamanio--;
        return dato;
    }

    /**
     * Busca y retorna el dato segun su posicion o indice
     */
    public Object buscarDato(int indice) {
        if (indice < 0 || indice >= tamanio || esVacia()) {
            return null;
        }
        Nodo actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    /**
     * Busca y retorna el dato que sea igual (equals) al dato buscado
     */
    public Object buscarDato(Object dato) {
        if (esVacia() || dato == null) {
            return null;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            if (dato.equals(actual.getDato())) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Comprueba si el elemento existe en la lista
     */
    public boolean contiene(Object dato) {
        return buscarDato(dato) != null;
    }

    /**
     * Vacia la lista
     */
    public void limpiar() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    /**
     * Recorre e imprime la lista desde la cabeza hasta la cola (adelante)
     */
    public void mostrarAdelante() {
        if (esVacia()) {
            System.out.println("   [Lista vacia]");
            return;
        }
        Nodo actual = cabeza;
        int i = 1;
        while (actual != null) {
            System.out.println("   " + i + ". " + actual.getDato());
            actual = actual.getSiguiente();
            i++;
        }
    }

    /**
     * Recorre e imprime la lista desde la cola hasta la cabeza (atras)
     */
    public void mostrarAtras() {
        if (esVacia()) {
            System.out.println("   [Lista vacia]");
            return;
        }
        Nodo actual = cola;
        int i = tamanio;
        while (actual != null) {
            System.out.println("   " + i + ". " + actual.getDato());
            actual = actual.getAnterior();
            i--;
        }
    }
}
