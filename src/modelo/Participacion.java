public class Participacion {

    // ATRIBUTOS

    private int puntos;

    private int partidosGanados;

    private int partidosEmpatados;

    private int partidosPerdidos;

    private int golesFavor;

    private int golesContra;

    // ENUM

    private NombreFase faseAlcanzada;

    // RELACIONES

    private Seleccion seleccion;

    private Grupo grupo;

    // CONSTRUCTOR

    public Participacion(Seleccion seleccion,
                         Grupo grupo) {

        this.seleccion = seleccion;

        this.grupo = grupo;

        puntos = 0;

        partidosGanados = 0;

        partidosEmpatados = 0;

        partidosPerdidos = 0;

        golesFavor = 0;

        golesContra = 0;

        faseAlcanzada = NombreFase.GRUPOS;
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

    public int getGolesFavor() {
        return golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public NombreFase getFaseAlcanzada() {
        return faseAlcanzada;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    // SETTERS

    public void setFaseAlcanzada(NombreFase faseAlcanzada) {
        this.faseAlcanzada = faseAlcanzada;
    }

    // METODOS

    public void registrarVictoria(int golesFavor,
                                  int golesContra) {

        puntos += 3;

        partidosGanados++;

        this.golesFavor += golesFavor;

        this.golesContra += golesContra;
    }

    public void registrarEmpate(int golesFavor,
                                int golesContra) {

        puntos += 1;

        partidosEmpatados++;

        this.golesFavor += golesFavor;

        this.golesContra += golesContra;
    }

    public void registrarDerrota(int golesFavor,
                                 int golesContra) {

        partidosPerdidos++;

        this.golesFavor += golesFavor;

        this.golesContra += golesContra;
    }

    public int diferenciaGoles() {

        return golesFavor - golesContra;
    }

    public void mostrarResultados() {

        System.out.println(toString());
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Seleccion: "
                + seleccion.getNombreFederacion()

                + "\nPuntos: " + puntos

                + "\nGanados: "
                + partidosGanados

                + "\nEmpatados: "
                + partidosEmpatados

                + "\nPerdidos: "
                + partidosPerdidos

                + "\nGF: " + golesFavor

                + "\nGC: " + golesContra

                + "\nDG: " + diferenciaGoles()

                + "\nFase alcanzada: "
                + faseAlcanzada;
    }
}