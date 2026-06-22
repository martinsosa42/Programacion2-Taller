
import java.util.ArrayList;
import java.util.List;

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

    /* Solo se puede registrar un Evento si el jugador pertenece a la selección local
    o a la visitante de ESTE partido (regla del enunciado: "los eventos solo pueden
    asignarse a jugadores que estén participando en dicho partido").
    */
    public void agregarEvento(Evento evento) throws EventoJugadorNoParticipaException {
        if (evento == null || evento.getJugador() == null) {
            return;
        }
        if (!esJugadorParticipante(evento.getJugador())) {
            throw new EventoJugadorNoParticipaException(evento.getJugador());
        }

        eventos.add(evento);
        // VINCULACIÓN AUTOMÁTICA: Guarda el evento en la lista propia del jugador
        evento.getJugador().getEventos().add(evento);
    }

    // Un jugador "participa" en el partido si juega para el local o el visitante.
    public boolean esJugadorParticipante(Jugador jugador) {
        if (jugador == null) {
            return false;
        }
        boolean enLocal = seleccionLocal != null && seleccionLocal.getJugadores().contains(jugador);
        boolean enVisitante = seleccionVisitante != null && seleccionVisitante.getJugadores().contains(jugador);
        return enLocal || enVisitante;
    }

    // Evita asignar dos árbitros con la misma categoría (ej. dos "PRINCIPAL") al mismo partido.
    public void agregarArbitraje(Arbitraje arbitraje) throws ArbitrajeInvalidoException {
        if (arbitraje == null) {
            return;
        }
        for (Arbitraje a : arbitrajes) {
            if (a.getCategoria() == arbitraje.getCategoria()) {
                throw new ArbitrajeInvalidoException(
                        "Ya hay un árbitro asignado con categoría " + arbitraje.getCategoria()
                        + "; no se puede repetir esa categoría en el mismo partido.");
            }
        }
        arbitrajes.add(arbitraje);
    }

    // Regla del enunciado: "Un Partido debe tener asignado un equipo de Arbitraje válido".
    // Un equipo válido cubre TODAS las categorías del enum CategoriaArbitro
    // (PRINCIPAL, ASISTENTE1, ASISTENTE2, CUARTO_ARBITRO, VAR_PRINCIPAL, VAR_ASISTENTE).
    public boolean tieneArbitrajeValido() {
        return categoriasFaltantes().isEmpty();
    }

    // Devuelve la lista de categorías de CategoriaArbitro que todavía no tienen
    // un árbitro asignado en este partido.
    public List<CategoriaArbitro> categoriasFaltantes() {
        List<CategoriaArbitro> faltantes = new ArrayList<>();
        for (CategoriaArbitro categoria : CategoriaArbitro.values()) {
            boolean cubierta = false;
            for (Arbitraje a : arbitrajes) {
                if (a.getCategoria() == categoria) {
                    cubierta = true;
                    break;
                }
            }
            if (!cubierta) {
                faltantes.add(categoria);
            }
        }
        return faltantes;
    }

    // Punto de control que usa ServicioMundial antes de dar el partido por registrado.
    public void validarArbitrajeCompleto() throws ArbitrajeInvalidoException {
        List<CategoriaArbitro> faltantes = categoriasFaltantes();
        if (!faltantes.isEmpty()) {
            throw new ArbitrajeInvalidoException("El equipo de arbitraje está incompleto; faltan las categorías: " + faltantes
                    + ". Un partido necesita un árbitro asignado en cada categoría.");
        }
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