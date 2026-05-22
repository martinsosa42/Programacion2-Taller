import java.util.ArrayList;

public class Estadio {

    private String nombre;
    private int capacidad;
    private Sede sede;
    private ArrayList<Partido> partidos;

    // Constructor por defecto
    public Estadio() {
        this.partidos = new ArrayList<Partido>();
    }

    // Constructor parametrizado
    public Estadio(String nombre,
                    int capacidad,
                    Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partidos = new ArrayList<Partido>();
    }

    public void agregarPartido(Partido p){
        partidos.add(p);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Sede getSede() {
        return sede;
    }

    public ArrayList<Partido> getPartidos(){
        return partidos;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public void setPartidos(ArrayList<Partido>partidos){
        this.partidos = partidos;
    }

    // toString
    @Override
    public String toString() {

        return "Estadio: " + nombre +
                ", Capacidad: " + capacidad +
                ", " + sede;
    }
}