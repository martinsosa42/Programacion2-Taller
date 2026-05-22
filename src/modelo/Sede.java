import java.util.ArrayList;

public class Sede {

    private String ciudad;
    private Pais pais;
    private ArrayList<Estadio> estadios;

    // Constructor por defecto
    public Sede() {
        this.estadios = new ArrayList<Estadio>();
    }

    // Constructor parametrizado
    public Sede(String ciudad, Pais pais) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.estadios = new ArrayList<Estadio>();
    }

    public void agregarEstadio(Estadio e){
        estadios.add(e);
    }

    // Getters
    public String getCiudad() {
        return ciudad;
    }

    public Pais getPais() {
        return pais;
    }

    public ArrayList<Estadio> getEstadios(){
        return estadios;
    }

    // Setters
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setEstadios(ArrayList<Estadio>estadios){
        this.estadios = estadios;
    }

    // toString
    @Override
    public String toString() {

        return "Ciudad: " + ciudad +
                ", " + pais;
    }
}