public class EventoJugadorNoParticipaException extends ReglaNegocioMundialException {
 
    public EventoJugadorNoParticipaException(Jugador jugador) {
        super("El jugador " + jugador.getNombre()
                + " no participa en este partido; no se le pueden asignar eventos.");
    }
}
