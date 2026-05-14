public class Persona {

    protected String nombre;
    protected int fecNacimiento;

    // Constructor por defecto
    public Persona() {
    }

    // Constructor parametrizado
    public Persona(String nombre, int fecNacimiento) {

        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getFecNacimiento() {
        return fecNacimiento;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    // toString
    @Override
    public String toString() {

        return "Nombre: " + nombre +
                ", Fecha nacimiento: " + fecNacimiento;
    }
}