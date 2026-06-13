import java.util.ArrayList;

public class Partido {

    // ATRIBUTOS
    private String fecha;
    private String hora;
    private int duracion;
    private int TiempoAdicional;
    private int golesLocal;
    private int golesVisitante;
    private NombreFase fase;
    private ArrayList<Participacion> participaciones;

    // RELACION
    private Seleccion seleccionLocal;
    private Seleccion seleccionVisitante;

    // RELACIONES
    private Estadio estadio;
    private ArrayList<Arbitraje> arbitrajes;
    private ArrayList<Evento> eventos;

    // CONSTRUCTOR POR DEFECTO
    public Partido() {
        this.arbitrajes = new ArrayList<Arbitraje>();
        this.eventos = new ArrayList<Evento>();
        this.participaciones = new ArrayList<Participacion>();
    }

    public Partido(String fecha,
                   String hora,
                   int duracion,
                   int TiempoAdicional,
                   NombreFase fase,
                   Estadio estadio) {
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.TiempoAdicional = TiempoAdicional;
        this.fase = fase;
        this.estadio = estadio;
        this.arbitrajes = new ArrayList<Arbitraje>();
        this.eventos = new ArrayList<Evento>();
        this.participaciones = new ArrayList<Participacion>();
    }
    


    // GETTERS
    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTiempoAdicional() {
        return TiempoAdicional;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public NombreFase getFase() {
        return fase;
    }

    public Seleccion getSeleccionLocal() {
        return seleccionLocal;
    }

    public Seleccion getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public ArrayList<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }

    // SETTERS
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setTiempoAdicional(int tiempoAdicional) {
        TiempoAdicional = tiempoAdicional;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public void setFase(NombreFase fase) {
        this.fase = fase;
    }

    public void setSeleccionLocal(Seleccion seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public void setSeleccionVisitante(Seleccion seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public void setArbitrajes(ArrayList<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public void setParticipaciones(ArrayList<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    // METODOS
    public void registrarResultado(int golesLocal,
                                   int golesVisitante) {
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public void agregarEvento(Evento evento) {
    if (evento != null) {
        eventos.add(evento);

        // VINCULACIÓN AUTOMÁTICA: Guarda el evento en la lista propia del jugador
        if (evento.getJugador() != null) {
            evento.getJugador().getEventos().add(evento);
        }
    }
}

    public void agregarArbitraje(Arbitraje arbitraje) {
        arbitrajes.add(arbitraje);
    }

    public void agregarParticipaciones(Participacion p){
        participaciones.add(p);
    }

    // TOSTRING
    @Override
    public String toString() {
        String texto = "";
        texto += "\n===== PARTIDO =====\n";
        texto += seleccionLocal.getNombreFederacion()
                + " "
                + golesLocal
                + " - "
                + golesVisitante
                + " "
                + seleccionVisitante.getNombreFederacion();
        texto += "\nFecha: " + fecha;
        texto += "\nHora: " + hora;
        texto += "\nFase: " + fase;
        texto += "\nEstadio: "
                + estadio.getNombre();
        texto += "\n\n===== EVENTOS =====\n";
        for(Evento e : eventos) {
            texto += e + "\n";
        }
        return texto;
    }
}