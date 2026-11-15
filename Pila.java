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

    public void apilar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamanio++;
    }

    public Object desapilar() {
        if (esVacia()) {
            return null;
        }
        Object dato = cima.getDato();
        cima = cima.getSiguiente();
        tamanio--;
        return dato;
    }

    public Object peek() {
        if (esVacia()) {
            return null;
        }
        return cima.getDato();
    }

    public boolean contiene(Object dato) {
        return buscar(dato) != null;
    }

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

    public void limpiar() {
        cima = null;
        tamanio = 0;
    }

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
