import java.util.ArrayList;

public class Partido {

    // ATRIBUTOS

    private String fecha;

    private String hora;

    private int golesLocal;

    private int golesVisitante;

    // ENUM

    private NombreFase fase;

    // RELACIONES

    private Estadio estadio;

    private Seleccion seleccionLocal;

    private Seleccion seleccionVisitante;

    private ArrayList<Arbitraje> arbitrajes;

    private ArrayList<Evento> eventos;

    // CONSTRUCTOR

    public Partido(String fecha,
                   String hora,
                   NombreFase fase,
                   Estadio estadio,
                   Seleccion seleccionLocal,
                   Seleccion seleccionVisitante) {

        this.fecha = fecha;

        this.hora = hora;

        this.fase = fase;

        this.estadio = estadio;

        this.seleccionLocal = seleccionLocal;

        this.seleccionVisitante = seleccionVisitante;

        golesLocal = 0;

        golesVisitante = 0;

        arbitrajes = new ArrayList<>();

        eventos = new ArrayList<>();
    }

    // GETTERS

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
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

    public Estadio getEstadio() {
        return estadio;
    }

    public Seleccion getSeleccionLocal() {
        return seleccionLocal;
    }

    public Seleccion getSeleccionVisitante() {
        return seleccionVisitante;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    // SETTERS

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFase(NombreFase fase) {
        this.fase = fase;
    }

    // METODOS

    public void registrarResultado(int golesLocal,
                                   int golesVisitante) {

        this.golesLocal = golesLocal;

        this.golesVisitante = golesVisitante;
    }

    public void agregarEvento(Evento evento) {

        eventos.add(evento);
    }

    public void agregarArbitraje(Arbitraje arbitraje) {

        arbitrajes.add(arbitraje);
    }

    public void mostrarEventos() {

        for(Evento e : eventos) {

            System.out.println(e);
        }
    }

    public void mostrarTarjetas() {

        for(Evento e : eventos) {

            if(e.getTipoEvento()
                    == TipoEvento.TARJETA_AMARILLA ||

               e.getTipoEvento()
                    == TipoEvento.TARJETA_ROJA) {

                System.out.println(e);
            }
        }
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