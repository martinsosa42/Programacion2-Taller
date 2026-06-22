
public class CuerpoTecnico extends Persona {

    //Rol que cumple dentro del cuerpo tecnico
    private Rol rol;

    //Contructor por defecto
    public CuerpoTecnico() {
    }
    
    //Constructor Parametrizado
    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }
    //Getters
    public Rol getRol() {
        return rol;
    }

    //Setters
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ", Rol: " + rol;
    }
}
