
public class Evento {

    //Evento de campo. Es composicion de partido, porque se crea dentro de un partido
    private TipoEvento tipo;
    private int minuto;
    
    //Relacion:
    private Jugador jugador;
    
    //Constructor por defecto
    public Evento() {
    }
    
    //Constructor Parametrizado
    public Evento(TipoEvento tipo, int minuto, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }
    
    //Getters
    public TipoEvento getTipo() {
        return tipo;
    }

    public int getMinuto() {
        return minuto;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    //Setters
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    //toString
    @Override
    public String toString() {
        return "Minuto: " + minuto + ", Evento: " + tipo + ", Jugador: " + jugador.getNombre();
    }
}
