import java.util.ArrayList;

public class Pais {

    private String nombre;
    private String continente;
    private ArrayList <Sede> sedes;
    private ArrayList<Arbitro> arbitros;
    private Seleccion seleccion; 


    // Constructor por defecto
    public Pais() {
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
    }

    // Constructor parametrizado
    public Pais(String nombre, String continente, Seleccion seleccion) {
        this.nombre = nombre;
        this.continente = continente;
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
        this.seleccion = seleccion;
    }

    public void agregarSede(Sede s){
        sedes.add(s);
    }

    public void agregarArbitro(Arbitro a){
        arbitros.add(a);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getContinente() {
        return continente;
    }

    public Seleccion getSeleccion(){
        return seleccion;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public void setSedes(ArrayList<Sede>sedes){
        this.sedes = sedes;
    }

    public void setArbistros(ArrayList<Arbitro>arbitros){
        this.arbitros = arbitros;
    }

    public void setSeleccion(Seleccion seleccion){
        this.seleccion = seleccion;
    }

    // toString
    @Override
    public String toString() {

        return "Pais: " + nombre +
                ", Continente: " + continente;
    }
}