import java.util.ArrayList;

public class Grupo {

    //Atributos
    private String identificacion;
    private String descripcion;

    //Relaciones: un grupo se agrupa con selecciones y puede incluir fases
    private ArrayList<Seleccion> selecciones;

    //Relacion 
    private Fase fase;
    
    //Constructor por defecto
    public Grupo() {
        this.selecciones = new ArrayList<Seleccion>();
    }

    //Constructor Parametrizado
    public Grupo(String identificacion, String descripcion,Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
        this.selecciones = new ArrayList<Seleccion>();
    }
    
    //Metodo agregar seleccion
    public void agregarSeleccion(Seleccion seleccion) {
        if (!selecciones.contains(seleccion)) {
            selecciones.add(seleccion);
        }
    }
    
    //Getters
    public String getIdentificacion() {
        return identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Fase getFase() {
        return fase;
    }


    public ArrayList<Seleccion> getSelecciones() {
        return selecciones;
    }

    //Setters
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void setSelecciones(ArrayList<Seleccion> selecciones) {
        this.selecciones = selecciones;
    }

    //toString
    @Override
    public String toString() {
        String texto = "Grupo: " + identificacion + "\n";
        texto += "Descripcion: " + descripcion + "\n";
        texto += "Selecciones:\n";
        for (Seleccion s : selecciones) {
            texto += "- " + s.getNombreFederacion() + "\n";
        }
        return texto;
    }
}
