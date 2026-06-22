
public class DirectorTecnico extends Persona {

    //Atributo
    private int fechaNombramiento;

    //Constructor por defecto
    public DirectorTecnico() {
    }
    
    //Constructor Parametrizado
    public DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    //Getters
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    //Setters
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ", Fecha nombramiento: " + fechaNombramiento;
    }
}
