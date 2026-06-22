
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

    public int obtenerPuntos(Seleccion s) {
        int puntos = 0;

        // Validamos que la selección no sea nula y que pertenezca a este grupo
        if (s == null || !this.selecciones.contains(s)) {
            return 0;
        }

        // Navegamos a la fase para obtener los partidos programados
        if (this.fase != null && this.fase.getPartidos() != null) {
        
        // Recorremos todos los partidos de la fase
        for (Partido partido : this.fase.getPartidos()) {
            // Verificamos si la selección participó en este partido (ya sea como local o visitante)
            boolean esLocal = (partido.getSeleccionLocal() != null && partido.getSeleccionLocal().equals(s));
            boolean esVisitante = (partido.getSeleccionVisitante() != null && partido.getSeleccionVisitante().equals(s));

            if (esLocal || esVisitante) {
                int golesLocal = partido.getGolesLocal();
                int golesVisitante = partido.getGolesVisitante();

                if (esLocal) {
                    // Lógica si la selección jugó en condición de LOCAL
                    if (golesLocal > golesVisitante) {
                        puntos += 3; // Victoria local
                    } else if (golesLocal == golesVisitante) {
                        puntos += 1; // Empate
                    }
                    // Si pierde, suma 0 puntos
                } else {
                    // Lógica si la selección jugó en condición de VISITANTE
                    if (golesVisitante > golesLocal) {
                        puntos += 3; // Victoria visitante
                    } else if (golesVisitante == golesLocal) {
                        puntos += 1; // Empate
                    }
                    // Si pierde, suma 0 puntos
                }
            }
        }
    }
    
    return puntos;
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
