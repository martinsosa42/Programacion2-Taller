import java.util.ArrayList;
public class Mundial {

    // ATRIBUTOS
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;

    // Agregacion
    private ArrayList<Sede> sedes;    

    // CONSTRUCTOR POR DEFECTO
    public Mundial() {
        this.sedes = new ArrayList<Sede>();
    }

    public Mundial(int anio, 
                    String mascota,
                    int fechaDesde, 
                    int fechaHasta){
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<Sede>();
    }
    
    public void agregarSede(Sede s){
        sedes.add(s);
    }

    // GETTERS
    public int getAnio() {
        return anio;
    }

    public String getMascota() {
        return mascota;
    }

    public int getFechaDesde() {
        return fechaDesde;
    }

    public int getFechaHasta() {
        return fechaHasta;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }
    
    // SETTERS
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public void setFechaDesde(int fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
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