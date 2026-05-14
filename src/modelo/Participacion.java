public class Participacion {

    // ATRIBUTOS
    private int puntos;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;

    // RELACIONES
    private Seleccion seleccion;

    private Grupo grupo;

    // CONSTRUCTOR
    public Participacion(int puntos,
                         int partidosGanados,
                         int partidosEmpatados,
                         int partidosPerdidos,
                         Seleccion seleccion,
                         Grupo grupo) {

        this.puntos = puntos;
        this.partidosGanados = partidosGanados;
        this.partidosEmpatados = partidosEmpatados;
        this.partidosPerdidos = partidosPerdidos;

        this.seleccion = seleccion;
        this.grupo = grupo;
    }

    // GETTERS

    public int getPuntos() {
        return puntos;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    // SETTERS

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Seleccion: "
                + seleccion.getNombreFederacion()
                + ", Grupo: "
                + grupo.getNombre()
                + ", Puntos: "
                + puntos;
    }
}