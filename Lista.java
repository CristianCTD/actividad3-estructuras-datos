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

    public boolean contiene(Object dato) {
        return buscarDato(dato) != null;
    }

    public void limpiar() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

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
