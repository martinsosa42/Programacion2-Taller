
import java.util.ArrayList;

public class Arbitro extends Persona {

    private int aniosExperiencia;

    // Relacion con Pais
    private Pais pais;
    
    // Relacion con la clase asociacion Arbitraje
    private ArrayList<Arbitraje> arbitrajes;
    
    //Constructor por defecto
    public Arbitro() {
        this.arbitrajes = new ArrayList<Arbitraje>();
    }
    
    //Constructor Parametrizado
    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
        this.arbitrajes = new ArrayList<Arbitraje>();
        // Vincula el arbitro con su país.
        if (pais != null) {
            pais.agregarArbitro(this);
        }
    }

    //Metodo agregar arbitraje
    public void agregarArbitraje(Arbitraje arbitraje) {
        if (!arbitrajes.contains(arbitraje)) {
            arbitrajes.add(arbitraje);
        }
    }

    //Getters
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public Pais getPais() {
        return pais;
    }

    public ArrayList<Arbitraje> getArbitrajes() {
        return arbitrajes;
    }

    //Setters
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setArbitrajes(ArrayList<Arbitraje> arbitrajes) {
        this.arbitrajes = arbitrajes;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ", Años experiencia: " + aniosExperiencia;
    }
}
