public class Grupo {

    
    private String nombre;

    // RELACION
    private Seleccion[] selecciones;

    // CONSTRUCTOR
    public Grupo(String nombre, Seleccion[] selecciones) {

        this.nombre = nombre;
        this.selecciones = selecciones;
    }

    // GETTERS

    public String getNombre() {
        return nombre;
    }

    public Seleccion[] getSelecciones() {
        return selecciones;
    }

    // SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSelecciones(Seleccion[] selecciones) {
        this.selecciones = selecciones;
    }

    // TOSTRING

    @Override
    public String toString() {

        String texto = "";

        texto += "Grupo: " + nombre + "\n";

        texto += "\nSelecciones:\n";

        for (Seleccion s : selecciones) {

            texto += s.getNombreFederacion() + "\n";
        }

        return texto;
    }
}