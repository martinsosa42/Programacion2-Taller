public class Mundial {

    // ATRIBUTOS
    private String nombre;

    private int anio;

    // RELACIONES
    private Grupo[] grupos;

    private Partido[] partidos;

    private Sede[] sedes;

    private Participacion[] participaciones;

    // CONSTRUCTOR
    public Mundial(String nombre,
                   int anio,
                   Grupo[] grupos,
                   Partido[] partidos,
                   Sede[] sedes,
                   Participacion[] participaciones) {

        this.nombre = nombre;
        this.anio = anio;

        this.grupos = grupos;

        this.partidos = partidos;

        this.sedes = sedes;

        this.participaciones = participaciones;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public Grupo[] getGrupos() {
        return grupos;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public Sede[] getSedes() {
        return sedes;
    }

    public Participacion[] getParticipaciones() {
        return participaciones;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setGrupos(Grupo[] grupos) {
        this.grupos = grupos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }

    public void setSedes(Sede[] sedes) {
        this.sedes = sedes;
    }

    public void setParticipaciones(Participacion[] participaciones) {
        this.participaciones = participaciones;
    }

    // TOSTRING

    @Override
    public String toString() {

        String texto = "";

        texto += "MUNDIAL " + nombre + "\n";
        texto += "Año: " + anio + "\n";

        texto += "\nGRUPOS\n";

        for (Grupo g : grupos) {

            texto += g + "\n";
        }

        texto += "\nPARTIDOS\n";

        for (Partido p : partidos) {

            texto += p + "\n";
        }

        return texto;
    }
}