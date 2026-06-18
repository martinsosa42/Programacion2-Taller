public class Participacion {
    
    //Atributos
    private boolean esLocal;

    // Clase asociacion entre Seleccion y Partido
    private Seleccion seleccion;
    private Partido partido;
    
    //Constructor por defecto
    public Participacion() {
    }
    
    //Constructor Parametrizado
    public Participacion(boolean esLocal, Seleccion seleccion, Partido partido) {
        this.esLocal = esLocal;
        this.seleccion = seleccion;
        this.partido = partido;
    }

    public int cantidadGoles() {
    int goles = 0;
    if (this.partido != null && this.partido.getEventos() != null && this.seleccion != null) {
        for (Evento e : this.partido.getEventos()) {
            // Verificamos si el evento es un gol o penal convertido
            if (e.getTipo() == TipoEvento.GOL || e.getTipo() == TipoEvento.PENAL_CONVERTIDO) {
                // Verificamos si el jugador que hizo el gol pertenece a ESTA selección
                if (this.seleccion.getJugadores().contains(e.getJugador())) {
                    goles++;
                }
            }
        }
    }
    return goles;
    }

    public int cantidadTarjAmarillas() {
        int amarillas = 0;
        if (this.partido != null && this.partido.getEventos() != null && this.seleccion != null) {
            for (Evento e : this.partido.getEventos()) {
                if (e.getTipo() == TipoEvento.TARJETA_AMARILLA) {
                    if (this.seleccion.getJugadores().contains(e.getJugador())) {
                        amarillas++;
                    }
                }
            }
        }
        return amarillas;
    }

    public int cantidadTarjRojas() {
        int rojas = 0;
        if (this.partido != null && this.partido.getEventos() != null && this.seleccion != null) {
            for (Evento e : this.partido.getEventos()) {
                if (e.getTipo() == TipoEvento.TARJETA_ROJA || e.getTipo() == TipoEvento.DOBLE_AMARILLA) {
                    if (this.seleccion.getJugadores().contains(e.getJugador())) {
                        rojas++;
                    }
                }
            }
        }
        return rojas;
    }
    
    //Getters
    public boolean isEsLocal() {
        return esLocal;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public Partido getPartido() {
        return partido;
    }
    //Setters
    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    //toString
    @Override
    public String toString() {
        return "Seleccion: " + seleccion.getNombreFederacion() +
                ", Local: " + esLocal;
    }
}
