import java.util.ArrayList;

public class Jugador extends Persona {

    //Atributos
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos;

    //Constructor por defecto
    public Jugador() {
        this.eventos = new ArrayList<Evento>();
    }

    //Constructor Parametrizado
    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos = new ArrayList<Evento>();
    }
    // Motetodo ranking de goleadores 
    public int calcularGoles() {
    int goles = 0;
        for (Evento e : eventos) {

            if (e.getTipo() == TipoEvento.GOL || e.getTipo() == TipoEvento.PENAL_CONVERTIDO) {
             goles++;
            }
        }
        return goles;
    }
    
        //Getters
    public int getDorsal() {
        return dorsal;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    //Setters
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() +
                ", Dorsal: " + dorsal +
                ", Posicion: " + posicion +
                ", Peso: " + peso +
                ", Altura: " + altura;
    }
    
}

