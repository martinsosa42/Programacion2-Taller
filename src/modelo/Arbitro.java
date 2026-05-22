import java.util.ArrayList;

public class Arbitro extends Persona {
    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje>arbitrajes;

    // Constructor por defecto
    public Arbitro() {
        this.arbitrajes = new ArrayList<Arbitraje>();
    }

    // Constructor parametrizado
    public Arbitro(String nombre,
                    int fecNacimiento,
                    int aniosExperiencia,
                    Pais pais) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitrajes = new ArrayList<Arbitraje>();
    }

    public void agregarArbitraje(Arbitraje a){
        arbitrajes.add(a);
    }

    // Getter
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public Pais getPais(){
        return pais;
    }

    public ArrayList<Arbitraje>getArbitrajes(){
        return arbitrajes;
    }

    // Setter
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public void setPais(Pais pais){
        this.pais = pais;
    }

    public void setArbitrajes(ArrayList<Arbitraje>arbitrajes){
        this.arbitrajes = arbitrajes;
    }

    // toString
    @Override
    public String toString() {
        return super.toString() +
                ", Años experiencia: " + aniosExperiencia;
    }
}