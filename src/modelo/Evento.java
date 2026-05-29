public class Evento {

    // ATRIBUTOS

    private int minuto;

    // ENUM

    private TipoEvento tipoEvento;

    // RELACIONES

    private Jugador jugador;

    // CONSTRUCTOR

    public Evento(int minuto,
                  TipoEvento tipoEvento,
                  Jugador jugador) {

        this.minuto = minuto;

        this.tipoEvento = tipoEvento;

        this.jugador = jugador;

        // ACTUALIZAR ESTADISTICAS

        if(tipoEvento == TipoEvento.GOL) {

            jugador.sumarGol();
        }

        if(tipoEvento == TipoEvento.TARJETA_AMARILLA) {

            jugador.sumarAmarilla();
        }

        if(tipoEvento == TipoEvento.TARJETA_ROJA) {

            jugador.sumarRoja();
        }
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

    // TOSTRING

    @Override
    public String toString() {

        return "Minuto: " + minuto +
                " | Evento: " + tipoEvento +
                " | Jugador: " + jugador.getNombre();
    }
}