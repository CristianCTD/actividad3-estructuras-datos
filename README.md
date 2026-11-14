# Sistema de Gestión de Secretaría Académica (Lista, Cola y Pila)

**Asignatura:** Estructuras de Datos  
**Unidad:** Unidad 3 - Estructuras de Datos Lineales Dinámicas  
**Actividad:** Actividad de Aprendizaje Unidad 3  
**Programa:** Ingeniería de Software  
**IES:** Universidad de Cartagena (Centro Tutorial Cereté)  
**Tutor:** John Carlos Arrieta Arrieta  
**Estudiante:** Cristian Torres  
**Ejercicio Asignado:** N.º 30 - Secretaría Académica (`TramiteAcademico` / `numeroRadicado`)

---

## 1. Descripción del Proyecto
Aplicación Java de consola que implementa desde cero tres estructuras de datos dinámicas lineales basadas en nodos enlazados:
1. **Lista Doblemente Enlazada (`Lista.java`):** Registro maestro de todos los trámites académicos con inserción, eliminación y recorridos bidireccionales (`mostrarAdelante` y `mostrarAtras`).
2. **Cola FIFO (`Cola.java`):** Gestión de trámites académicos pendientes por procesar según estricto orden de llegada. La cancelación de pendientes se realiza mediante una cola auxiliar.
3. **Pila LIFO (`Pila.java`):** Historial cronológico inverso de trámites procesados y soporte para revertir / deshacer operaciones (`desapilar` y re-encolar).

---

## 2. Compilación y Ejecución

### Compilación:
```bash
javac *.java
```

### Ejecución:
```bash
java SistemaTramiteAcademico
```
