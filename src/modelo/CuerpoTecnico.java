public class CuerpoTecnico extends Persona {

    private Rol rol;

    // Constructor por defecto
    public CuerpoTecnico() {
    }

    // Constructor parametrizado
    public CuerpoTecnico(String nombre,
                            int fecNacimiento,
                            Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }

    // Getter
    public Rol getRol() {
        return rol;
    }

    // Setter
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // toString
    @Override
    public String toString() {

        return super.toString() +
                ", Rol: " + rol;
    }
}