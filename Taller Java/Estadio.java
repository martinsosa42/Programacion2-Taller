public class Estadio {

    private String nombre;
    private int capacidad;
    private Sede sede;

    // Constructor por defecto
    public Estadio() {
    }

    // Constructor parametrizado
    public Estadio(String nombre,
                    int capacidad,
                    Sede sede) {

        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
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

    // toString
    @Override
    public String toString() {

        return "Estadio: " + nombre +
                ", Capacidad: " + capacidad +
                ", " + sede;
    }
}