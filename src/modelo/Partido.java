public class Partido {

    // ATRIBUTOS
    private String fecha;
    private String hora;

    // ENUM
    private NombreFase fase;

    // RELACIONES
    private Estadio estadio;

    private Seleccion seleccionLocal;

    private Seleccion seleccionVisitante;

    private Arbitraje[] arbitrajes;

    private Evento[] eventos;

    // CONSTRUCTOR
    public Partido(String fecha,
                   String hora,
                   NombreFase fase,
                   Estadio estadio,
                   Seleccion seleccionLocal,
                   Seleccion seleccionVisitante,
                   Arbitraje[] arbitrajes,
                   Evento[] eventos) {

        this.fecha = fecha;
        this.hora = hora;
        this.fase = fase;

        this.estadio = estadio;

        this.seleccionLocal = seleccionLocal;
        this.seleccionVisitante = seleccionVisitante;

        this.arbitrajes = arbitrajes;

        this.eventos = eventos;
    }

    // GETTERS

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
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

    public Arbitraje[] getArbitrajes() {
        return arbitrajes;
    }

    public Evento[] getEventos() {
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

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public void setSeleccionLocal(Seleccion seleccionLocal) {
        this.seleccionLocal = seleccionLocal;
    }

    public void setSeleccionVisitante(Seleccion seleccionVisitante) {
        this.seleccionVisitante = seleccionVisitante;
    }

    public void setArbitrajes(Arbitraje[] arbitrajes) {
        this.arbitrajes = arbitrajes;
    }

    public void setEventos(Evento[] eventos) {
        this.eventos = eventos;
    }

    // TOSTRING

    @Override
    public String toString() {

        String texto = "";

        texto += "PARTIDO\n";
        texto += "Fecha: " + fecha + "\n";
        texto += "Hora: " + hora + "\n";
        texto += "Fase: " + fase + "\n";

        texto += "\nESTADIO\n";
        texto += estadio + "\n";

        texto += "\nSELECCIONES\n";
        texto += seleccionLocal.getNombreFederacion()
                + " VS "
                + seleccionVisitante.getNombreFederacion()
                + "\n";

        texto += "\nARBITRAJES\n";

        for (Arbitraje a : arbitrajes) {

            texto += a + "\n";
        }

        texto += "\nEVENTOS\n";

        for (Evento e : eventos) {

            texto += e + "\n";
        }

        return texto;
    }
}