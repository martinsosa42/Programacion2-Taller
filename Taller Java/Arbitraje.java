public class Arbitraje {

    // RELACION
    private Arbitro arbitro;

    // ENUM
    private CategoriaArbitro categoria;

    // CONSTRUCTOR
    public Arbitraje(Arbitro arbitro,
                     CategoriaArbitro categoria) {

        this.arbitro = arbitro;
        this.categoria = categoria;
    }

    // GETTERS

    public Arbitro getArbitro() {
        return arbitro;
    }

    public CategoriaArbitro getCategoria() {
        return categoria;
    }

    // SETTERS

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public void setCategoria(CategoriaArbitro categoria) {
        this.categoria = categoria;
    }

    // TOSTRING

    @Override
    public String toString() {

        return "Categoria: " + categoria +
                ", Arbitro: " + arbitro.getNombre();
    }
}