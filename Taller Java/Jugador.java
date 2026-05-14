public class Jugador extends Persona {

    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;

    // Constructor por defecto
    public Jugador() {
    }

    // Constructor parametrizado
    public Jugador(String nombre,
                    int fecNacimiento,
                    int dorsal,
                    Posicion posicion,
                    float peso,
                    float altura) {

        // Constructor padre
        super(nombre, fecNacimiento);

        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
    }

    // Getters
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

    // Setters
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

    // toString
    @Override
    public String toString() {

        return super.toString() +
                ", Dorsal: " + dorsal +
                ", Posición: " + posicion +
                ", Peso: " + peso +
                ", Altura: " + altura;
    }
}