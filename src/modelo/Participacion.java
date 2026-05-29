public class Participacion {
    
    //Atributos
    private boolean esLocal;

    // Clase asociacion entre Seleccion y Partido
    private Seleccion seleccion;
    private Partido partido;
    
    //Constructor por defecto
    public Participacion() {
    }
    
    //Constructor Parametrizado
    public Participacion(boolean esLocal, Seleccion seleccion, Partido partido) {
        this.esLocal = esLocal;
        this.seleccion = seleccion;
        this.partido = partido;
    }
    
    //Getters
    public boolean isEsLocal() {
        return esLocal;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public Partido getPartido() {
        return partido;
    }
    //Setters
    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    //toString
    @Override
    public String toString() {
        return "Seleccion: " + seleccion.getNombreFederacion() +
                ", Local: " + esLocal;
    }
}
