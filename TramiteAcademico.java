import java.util.Objects;

public class TramiteAcademico {
    private String numeroRadicado;
    private String estudiante;
    private String documentoEstudiante;
    private String programaAcademico;
    private String tipoTramite;
    private String fechaSolicitud;
    private String estado;
    private String descripcion;

    public TramiteAcademico() {
    }

    public TramiteAcademico(String numeroRadicado, String estudiante, String documentoEstudiante,
                            String programaAcademico, String tipoTramite, String fechaSolicitud,
                            String estado, String descripcion) {
        this.numeroRadicado = numeroRadicado;
        this.estudiante = estudiante;
        this.documentoEstudiante = documentoEstudiante;
        this.programaAcademico = programaAcademico;
        this.tipoTramite = tipoTramite;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
        this.descripcion = descripcion;
    }

    public String getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getDocumentoEstudiante() {
        return documentoEstudiante;
    }

    public void setDocumentoEstudiante(String documentoEstudiante) {
        this.documentoEstudiante = documentoEstudiante;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TramiteAcademico that = (TramiteAcademico) o;
        return Objects.equals(numeroRadicado, that.numeroRadicado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroRadicado);
    }

    @Override
    public String toString() {
        return "[" + numeroRadicado + "] " + tipoTramite + " | Estudiante: " + estudiante +
               " (" + documentoEstudiante + ") | Programa: " + programaAcademico +
               " | Fecha: " + fechaSolicitud + " | Estado: [" + estado + "] | Detalle: " + descripcion;
    }
}
