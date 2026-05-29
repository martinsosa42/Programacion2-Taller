public class Jugador extends Persona {

    // ATRIBUTOS

    private int numero;

    private Posicion posicion;

    private double peso;

    private double altura;

    private int goles;

    private int tarjetasAmarillas;

    private int tarjetasRojas;

    // CONSTRUCTOR

    public Jugador(String nombre,
                    int fecNacimiento,
                    int numero,
                    Posicion posicion,
                    double peso,
                    double altura) {

        super(nombre, fecNacimiento);

        this.numero = numero;

        this.posicion = posicion;

        this.peso = peso;

        this.altura = altura;

        goles = 0;

        tarjetasAmarillas = 0;

        tarjetasRojas = 0;
    }

    // GETTERS

    public int getNumero() {
        return numero;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public int getGoles() {
        return goles;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    // SETTERS

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // METODOS

    public void sumarGol() {

        goles++;
    }

    public void sumarAmarilla() {

        tarjetasAmarillas++;
    }

    public void sumarRoja() {

        tarjetasRojas++;
    }

    // TOSTRING

    @Override
    public String toString() {

        return super.toString() +
                "\nNumero: " + numero +
                "\nPosicion: " + posicion +
                "\nGoles: " + goles +
                "\nAmarillas: " + tarjetasAmarillas +
                "\nRojas: " + tarjetasRojas;
    }
}