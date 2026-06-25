
import java.util.ArrayList;

public class Mundial {

    //Atributos
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;

    //Relaciones
    private ArrayList<Sede> sedes;

    //Constructor por defecto
    public Mundial() {
        this.sedes = new ArrayList<Sede>();
    }

    //Constructor Parametrizado
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<Sede>();
    }
    //Metodo agregar sede
    public void agregarSede(Sede sede) {
        if (!sedes.contains(sede)) {
            sedes.add(sede);
        }
    }

    //Getters
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

    //Setters
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

    //toString
    @Override
    public String toString() {
        String texto = "MUNDIAL " + anio + "\n";
        texto += "Mascota: " + mascota + "\n";
        texto += "Fecha desde: " + fechaDesde + "\n";
        texto += "Fecha hasta: " + fechaHasta + "\n";

        texto += "\nSEDES\n";
        for (Sede s : sedes) {
            texto += s + "\n";
        }
        return texto;
    }
}
