public class Arbitraje {
    private CategoriaArbitro rol;
    // RELACION
    private Arbitro arbitro;
    private Partido partido;

    // CONSTRUCTOR
    public Arbitraje(CategoriaArbitro rol,
                        Arbitro arbitro,
                        Partido partido) {
        this.rol = rol;
        this.arbitro = arbitro;
        this.partido = partido;
    }

    // GETTERS
    public CategoriaArbitro getRol() {
        return rol;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public Partido getPartido() {
        return partido;
    }

    // SETTERS
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public void setRol(CategoriaArbitro rol) {
        this.rol = rol;
    }

    public void setPartido(Partido partido){
        this.partido = partido;
    }

    // TOSTRING
    @Override
    public String toString() {

        return "Categoria: " + rol +
                ", Arbitro: " + arbitro.getNombre();
    }
}