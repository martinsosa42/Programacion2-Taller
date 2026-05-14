public class Arbitro extends Persona {

    private int aniosExperiencia;

    // Constructor por defecto
    public Arbitro() {
    }

    // Constructor parametrizado
    public Arbitro(String nombre,
                    int fecNacimiento,
                    int aniosExperiencia) {

        super(nombre, fecNacimiento);

        this.aniosExperiencia = aniosExperiencia;
    }

    // Getter
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    // Setter
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    // toString
    @Override
    public String toString() {

        return super.toString() +
                ", Años experiencia: " + aniosExperiencia;
    }
}