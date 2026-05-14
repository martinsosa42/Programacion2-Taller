public class Sede {

    private String ciudad;
    private Pais pais;

    // Constructor por defecto
    public Sede() {
    }

    // Constructor parametrizado
    public Sede(String ciudad, Pais pais) {

        this.ciudad = ciudad;
        this.pais = pais;
    }

    // Getters
    public String getCiudad() {
        return ciudad;
    }

    public Pais getPais() {
        return pais;
    }

    // Setters
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    // toString
    @Override
    public String toString() {

        return "Ciudad: " + ciudad +
                ", " + pais;
    }
}