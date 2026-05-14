public class Pais {

    private String nombre;
    private String continente;

    // Constructor por defecto
    public Pais() {
    }

    // Constructor parametrizado
    public Pais(String nombre, String continente) {

        this.nombre = nombre;
        this.continente = continente;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    // toString
    @Override
    public String toString() {

        return "Pais: " + nombre +
                ", Continente: " + continente;
    }
}