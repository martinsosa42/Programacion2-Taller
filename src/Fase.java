
import java.util.ArrayList;

public class Fase {

    //Atributo
    private NombreFase nombre;

    // Relaciones: una fase puede corresponder a un grupo y tiene partidos
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    //Constructor por defecto
    public Fase() {
        this.partidos = new ArrayList<Partido>();
        this.grupos = new ArrayList<Grupo>();
    }

    //Constructor Parametrizado
    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.partidos = new ArrayList<Partido>();
        this.grupos = new ArrayList<Grupo>();
    }

    //Metodo agregar grupo
    public void agregarGrupo(Grupo grupo) {
        if (!grupos.contains(grupo)) {
            grupos.add(grupo);
        }
    }

    //Metodo agregar partido 
    public void agregarPartido(Partido partido) {
        if (!partidos.contains(partido)) {
            partidos.add(partido);
        }
    }

    //Getters
    public NombreFase getNombre() {
        return nombre;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    //Setters
    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
    //toString
    @Override
    public String toString() {
        return "Fase: " + nombre + ", Cantidad de partidos: " + partidos.size();
    }
}
