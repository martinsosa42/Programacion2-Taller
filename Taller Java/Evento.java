public class Evento {

    // ATRIBUTO
    private int minuto;

    // ENUM
    private TipoEvento tipoEvento;

    // RELACIONES
    private Jugador jugador;

    private Partido partido;

    // CONSTRUCTOR
    public Evento(int minuto,
                  TipoEvento tipoEvento,
                  Jugador jugador,
                  Partido partido) {

        this.minuto = minuto;
        this.tipoEvento = tipoEvento;

        this.jugador = jugador;

        this.partido = partido;
    }

    // GETTERS

    public int getMinuto() {
        return minuto;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Partido getPartido() {
        return partido;
    }

    // SETTERS

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Minuto: " + minuto +
                ", Evento: " + tipoEvento +
                ", Jugador: " + jugador.getNombre();
    }
}