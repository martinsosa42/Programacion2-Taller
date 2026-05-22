public class Evento {

    // ATRIBUTO
    private int minuto;

    // ENUM
    private TipoEvento tipo;

    // RELACIONES
    private Jugador jugador;

    // CONSTRUCTOR
    public Evento(TipoEvento tipo,
                  int minuto,
                  Jugador jugador) {
        this.minuto = minuto;
        this.tipo = tipo;
        this.jugador = jugador;
    }

    // GETTERS

    public int getMinuto() {
        return minuto;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    // SETTERS

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Minuto: " + minuto +
                ", Evento: " + tipo +
                ", Jugador: " + jugador.getNombre();
    }
}