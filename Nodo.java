/**
 * Clase Nodo: Componente base para estructuras lineales enlazadas.
 * Implementa referencias bidireccionales (siguiente/anterior o derecha/izquierda)
 * para dar soporte a Listas Doblemente Enlazadas, Colas y Pilas.
 * 
 * Asignatura: Estructuras de Datos
 * Docente: John Carlos Arrieta Arrieta
 * Estudiante: Cristian Torres
 */
public class Nodo {
    private Object dato;
    private Nodo siguiente; // Referencia hacia adelante / derecha
    private Nodo anterior;  // Referencia hacia atras / izquierda

    /**
     * Constructor del Nodo
     * @param dato Objeto de informacion almacenado en el nodo
     */
    public Nodo(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getters y Setters estandar
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

    // Nomenclatura alternativa requerida por la rubrica (derecha / izquierda)
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
