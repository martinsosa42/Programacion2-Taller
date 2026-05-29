import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private ArrayList<Seleccion> selecciones;

    public Grupo(String nombre) {

        this.nombre = nombre;

        selecciones = new ArrayList<>();
    }

    public void agregarSeleccion(Seleccion seleccion) {

        selecciones.add(seleccion);
    }
    public String getNombre() {
        return nombre; 
    }
    public void setnombre(String nombre) {
        this.nombre = nombre; 
    }
}