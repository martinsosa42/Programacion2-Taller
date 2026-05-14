public class DirectorTecnico extends Persona {

    private int fechaNombramiento;

    // Constructor por defecto
    public DirectorTecnico() {
    }

    // Constructor parametrizado
    public DirectorTecnico(String nombre,
                            int fecNacimiento,
                            int fechaNombramiento) {

        super(nombre, fecNacimiento);

        this.fechaNombramiento = fechaNombramiento;
    }

    // Getter
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    // Setter
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }

    // toString
    @Override
    public String toString() {

        return super.toString() +
                ", Fecha nombramiento: " + fechaNombramiento;
    }
}