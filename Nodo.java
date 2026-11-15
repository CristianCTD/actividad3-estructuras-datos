public class Nodo {
    private Object dato;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getDerecha() {
        return siguiente;
    }

    public void setDerecha(Nodo derecha) {
        this.siguiente = derecha;
    }

    public Nodo getIzquierda() {
        return anterior;
    }

    public void setIzquierda(Nodo izquierda) {
        this.anterior = izquierda;
    }
}
