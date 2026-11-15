import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SistemaTramiteAcademico {

    private Lista listaGeneral;
    private Cola colaPendientes;
    private Pila historialProcesados;
    private Scanner scanner;

    public SistemaTramiteAcademico() {
        this.listaGeneral = new Lista();
        this.colaPendientes = new Cola();
        this.historialProcesados = new Pila();
        this.scanner = new Scanner(System.in);
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        TramiteAcademico t1 = new TramiteAcademico(
            "RAD-2026-001", "Cristian Torres", "1067890123",
            "Ingenieria de Software", "Certificado de Notas",
            "2026-11-14", "PENDIENTE", "Solicitud para convocatoria de becas"
        );
        TramiteAcademico t2 = new TramiteAcademico(
            "RAD-2026-002", "Maria Paula Gomez", "1045678901",
            "Ingenieria de Software", "Homologacion de Asignatura",
            "2026-11-14", "PENDIENTE", "Homologacion de Calculo Integral"
        );
        TramiteAcademico t3 = new TramiteAcademico(
            "RAD-2026-003", "Andres Felipe Ramos", "1098765432",
            "Ingenieria de Software", "Cancelacion de Semestre",
            "2026-11-14", "PENDIENTE", "Motivos laborales y viaje temporal"
        );

        listaGeneral.agregar(t1);
        colaPendientes.encolar(t1);

        listaGeneral.agregar(t2);
        colaPendientes.encolar(t2);

        listaGeneral.agregar(t3);
        colaPendientes.encolar(t3);
    }

    public void iniciar() {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion (1-10): ");
            System.out.println();
            switch (opcion) {
                case 1:
                    registrarElemento();
                    break;
                case 2:
                    verTodosLosElementos();
                    break;
                case 3:
                    verElementosPendientes();
                    break;
                case 4:
                    procesarSiguienteElemento();
                    break;
                case 5:
                    verHistorialProcesados();
                    break;
                case 6:
                    buscarElementoPorCodigo();
                    break;
                case 7:
                    cancelarElementoPendiente();
                    break;
                case 8:
                    deshacerUltimoProcesamiento();
                    break;
                case 9:
                    verCantidadElementos();
                    break;
                case 10:
                    System.out.println("===============================================================");
                    System.out.println(" Gracias por utilizar el Sistema de Secretaria Academica.");
                    System.out.println(" Universidad de Cartagena - Ingenieria de Software.");
                    System.out.println("===============================================================");
                    break;
                default:
                    System.out.println("[Error] Opcion invalida. Ingrese un numero entre 1 y 10.");
            }
            if (opcion != 10) {
                System.out.println("\nPresione ENTER para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 10);
    }

    private void mostrarMenu() {
        System.out.println("\n===============================================================");
        System.out.println(" SISTEMA DE SECRETARIA ACADEMICA - GESTION CON LISTA, COLA Y PILA");
        System.out.println(" Caso N. 30: TramiteAcademico | Estudiante: Cristian Torres");
        System.out.println("===============================================================");
        System.out.println(" 1. Registrar elemento");
        System.out.println(" 2. Ver todos los elementos registrados (Lista)");
        System.out.println(" 3. Ver elementos pendientes (Cola)");
        System.out.println(" 4. Procesar siguiente elemento (Cola -> Pila)");
        System.out.println(" 5. Ver historial de elementos procesados (Pila)");
        System.out.println(" 6. Buscar elemento por codigo");
        System.out.println(" 7. Cancelar elemento pendiente (Uso de Cola Auxiliar)");
        System.out.println(" 8. Deshacer ultimo procesamiento (Pila -> Cola)");
        System.out.println(" 9. Ver cantidad de elementos");
        System.out.println(" 10. Salir");
        System.out.println("===============================================================");
    }

    private void registrarElemento() {
        System.out.println("--- [1] REGISTRAR NUEVO TRAMITE ACADEMICO ---");
        System.out.print("Ingrese numero de radicado (ej. RAD-2026-004): ");
        String radicado = scanner.nextLine().trim();

        TramiteAcademico dummy = new TramiteAcademico();
        dummy.setNumeroRadicado(radicado);
        if (listaGeneral.contiene(dummy)) {
            System.out.println("[Error] Ya existe un tramite registrado con el radicado: " + radicado);
            return;
        }

        System.out.print("Nombre completo del estudiante: ");
        String estudiante = scanner.nextLine().trim();

        System.out.print("Documento de identidad: ");
        String doc = scanner.nextLine().trim();

        System.out.print("Programa academico [Ingenieria de Software]: ");
        String programa = scanner.nextLine().trim();
        if (programa.isEmpty()) programa = "Ingenieria de Software";

        System.out.print("Tipo de tramite (Certificado/Homologacion/Cancelacion/Grado): ");
        String tipo = scanner.nextLine().trim();

        System.out.print("Descripcion o motivo: ");
        String descripcion = scanner.nextLine().trim();

        String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        TramiteAcademico nuevo = new TramiteAcademico(
            radicado, estudiante, doc, programa, tipo, fechaActual, "PENDIENTE", descripcion
        );

        listaGeneral.agregar(nuevo);
        colaPendientes.encolar(nuevo);

        System.out.println("[Exito] Tramite " + radicado + " registrado en la lista y encolado como pendiente.");
    }

    private void verTodosLosElementos() {
        System.out.println("--- [2] TODOS LOS ELEMENTOS REGISTRADOS (LISTA GENERAL) ---");
        System.out.println("Total en sistema: " + listaGeneral.cuentaElementos() + " tramites.");
        listaGeneral.mostrarAdelante();
    }

    private void verElementosPendientes() {
        System.out.println("--- [3] ELEMENTOS PENDIENTES POR ATENDER (COLA FIFO) ---");
        System.out.println("Total pendientes: " + colaPendientes.tamanio() + " tramites.");
        colaPendientes.mostrar();
    }

    private void procesarSiguienteElemento() {
        System.out.println("--- [4] PROCESAR SIGUIENTE ELEMENTO PENDIENTE ---");
        if (colaPendientes.esVacia()) {
            System.out.println("[Aviso] No hay tramites pendientes por procesar en la cola.");
            return;
        }

        TramiteAcademico procesado = (TramiteAcademico) colaPendientes.desencolar();
        procesado.setEstado("PROCESADO");
        historialProcesados.apilar(procesado);

        System.out.println("[Exito] Tramite procesado satisfactoriamente:");
        System.out.println("   " + procesado);
        System.out.println("El tramite paso del frente de la Cola al tope de la Pila de historial.");
    }

    private void verHistorialProcesados() {
        System.out.println("--- [5] HISTORIAL DE ELEMENTOS PROCESADOS (PILA LIFO) ---");
        System.out.println("Total procesados: " + historialProcesados.tamanio() + " tramites.");
        historialProcesados.mostrar();
    }

    private void buscarElementoPorCodigo() {
        System.out.println("--- [6] BUSCAR TRAMITE POR NUMERO DE RADICADO ---");
        System.out.print("Ingrese el numero de radicado a buscar: ");
        String radicado = scanner.nextLine().trim();

        TramiteAcademico dummy = new TramiteAcademico();
        dummy.setNumeroRadicado(radicado);

        Object resultado = listaGeneral.buscarDato(dummy);
        if (resultado != null) {
            TramiteAcademico encontrado = (TramiteAcademico) resultado;
            System.out.println("[Encontrado en Lista General]:");
            System.out.println("   Radicado: " + encontrado.getNumeroRadicado());
            System.out.println("   Estudiante: " + encontrado.getEstudiante() + " (Doc: " + encontrado.getDocumentoEstudiante() + ")");
            System.out.println("   Programa: " + encontrado.getProgramaAcademico());
            System.out.println("   Tipo Tramite: " + encontrado.getTipoTramite());
            System.out.println("   Fecha Solicitud: " + encontrado.getFechaSolicitud());
            System.out.println("   Estado actual: [" + encontrado.getEstado() + "]");
            System.out.println("   Descripcion: " + encontrado.getDescripcion());
        } else {
            System.out.println("[No encontrado] No existe ningun tramite con el radicado: " + radicado);
        }
    }

    private void cancelarElementoPendiente() {
        System.out.println("--- [7] CANCELAR ELEMENTO PENDIENTE (COLA AUXILIAR) ---");
        if (colaPendientes.esVacia()) {
            System.out.println("[Aviso] No hay tramites en la cola de pendientes.");
            return;
        }

        System.out.print("Ingrese el numero de radicado del tramite a cancelar: ");
        String radicado = scanner.nextLine().trim();

        Cola colaAuxiliar = new Cola();
        boolean encontrado = false;
        TramiteAcademico cancelado = null;

        while (!colaPendientes.esVacia()) {
            TramiteAcademico actual = (TramiteAcademico) colaPendientes.desencolar();
            if (actual.getNumeroRadicado().equalsIgnoreCase(radicado) && !encontrado) {
                encontrado = true;
                actual.setEstado("CANCELADO");
                cancelado = actual;

            } else {
                colaAuxiliar.encolar(actual);
            }
        }

        while (!colaAuxiliar.esVacia()) {
            colaPendientes.encolar(colaAuxiliar.desencolar());
        }

        if (encontrado) {
            System.out.println("[Exito] El tramite " + radicado + " fue cancelado y retirado de la cola de pendientes.");
            System.out.println("Detalle: " + cancelado);
        } else {
            System.out.println("[Aviso] El tramite " + radicado + " no fue encontrado en la cola de pendientes (puede que ya este procesado o no exista).");
        }
    }

    private void deshacerUltimoProcesamiento() {
        System.out.println("--- [8] DESHACER ULTIMO PROCESAMIENTO ---");
        if (historialProcesados.esVacia()) {
            System.out.println("[Aviso] No hay procesamientos para deshacer en el historial.");
            return;
        }

        TramiteAcademico ultimo = (TramiteAcademico) historialProcesados.desapilar();
        ultimo.setEstado("PENDIENTE");
        colaPendientes.encolar(ultimo);

        System.out.println("[Exito] Deshecho el ultimo procesamiento:");
        System.out.println("   " + ultimo);
        System.out.println("El tramite fue desapilado del historial y reincorporado a la Cola de pendientes.");
    }

    private void verCantidadElementos() {
        System.out.println("--- [9] RESUMEN DE CANTIDAD DE ELEMENTOS ---");
        System.out.println(" - Total registrados en Lista General: " + listaGeneral.cuentaElementos());
        System.out.println(" - Total pendientes en Cola (FIFO):    " + colaPendientes.tamanio());
        System.out.println(" - Total procesados en Pila (LIFO):    " + historialProcesados.tamanio());
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine().trim();
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("[Error] Entrada no valida. Ingrese un numero entero.");
            }
        }
    }

    public static void main(String[] args) {
        SistemaTramiteAcademico app = new SistemaTramiteAcademico();
        app.iniciar();
    }
}
