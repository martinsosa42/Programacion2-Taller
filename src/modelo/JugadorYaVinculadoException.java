
public class JugadorYaVinculadoException extends ReglaNegocioMundialException {
 
    public JugadorYaVinculadoException(Jugador jugador, Seleccion seleccionActual) {
        super("El jugador " + jugador.getNombre()
                + " ya está vinculado a la selección " + seleccionActual.getNombreFederacion()
                + " y no puede vincularse a otra.");
    }
}
