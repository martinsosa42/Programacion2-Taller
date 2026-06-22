
import java.util.ArrayList;

public class Pais {

    //Atributos
    private String nombre;
    private String bandera;

    //Relaciones: un país puede tener sedes, arbitros y una seleccion que lo representa
    private ArrayList<Sede> sedes;
    private ArrayList<Arbitro> arbitros;
    private Seleccion seleccion;
    
    //Constructor por defecto
    public Pais() {
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
    }

    //Constructor Parametrizado
    public Pais(String nombre, String bandera, Seleccion seleccion) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.seleccion = seleccion;
        this.sedes = new ArrayList<Sede>();
        this.arbitros = new ArrayList<Arbitro>();
    }

    //Metodos agregar sedes
    public void agregarSede(Sede sede) {
        if (!sedes.contains(sede)) {
            sedes.add(sede);
        }
    }

    //Metodo agregar arbitro
    public void agregarArbitro(Arbitro arbitro) {
        if (!arbitros.contains(arbitro)) {
            arbitros.add(arbitro);
        }
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getBandera() {
        return bandera;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    public void setArbitros(ArrayList<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
    
    //toString
    @Override
    public String toString() {
        return "Pais: " + nombre + ", Bandera: " + bandera;
    }
}
