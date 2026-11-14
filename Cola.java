/**
 * Clase Cola: Implementacion de una Cola FIFO (First-In, First-Out) personalizada.
 * Los elementos se encolan al final y se atienden o desencolan por el frente.
 * 
 * Asignatura: Estructuras de Datos
 * Docente: John Carlos Arrieta Arrieta
 * Estudiante: Cristian Torres
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;
    private int tamanio;

    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamanio = 0;
    }

    public boolean esVacia() {
        return frente == null;
    }

    public int tamanio() {
        return tamanio;
    }

    /**
     * Inserta un nuevo elemento al final de la cola (encolar)
     */
    public void encolar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tamanio++;
    }

    /**
     * Extrae y retorna el elemento al frente de la cola (desencolar)
     */
    public Object desencolar() {
        if (esVacia()) {
            return null;
        }
        Object dato = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamanio--;
        return dato;
    }

    /**
     * Consulta el elemento al frente sin extraerlo
     */
    public Object peek() {
        if (esVacia()) {
            return null;
        }
        return frente.getDato();
    }

    /**
     * Verifica si un elemento se encuentra en la cola sin modificarla
     */
    public boolean contiene(Object dato) {
        if (esVacia() || dato == null) {
            return false;
        }
        Nodo actual = frente;
        while (actual != null) {
            if (dato.equals(actual.getDato())) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Limpia la cola
     */
    public void limpiar() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    /**
     * Muestra todos los elementos en orden de llegada (desde el frente hacia el fin)
     */
    public void mostrar() {
        if (esVacia()) {
            System.out.println("   [Cola vacia - No hay elementos pendientes]");
            return;
        }
        Nodo actual = frente;
        int turno = 1;
        while (actual != null) {
            System.out.println("   Turno " + turno + " -> " + actual.getDato());
            actual = actual.getSiguiente();
            turno++;
        }
    }
}
