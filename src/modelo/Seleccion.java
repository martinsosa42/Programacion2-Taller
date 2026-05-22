public class Seleccion {

    // ATRIBUTOS
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;

    // RELACIONES
    private Pais pais;

    private DirectorTecnico directorTecnico;

    private Jugador[] jugadores;

    private CuerpoTecnico[] cuerpoTecnico;

    // CONSTRUCTOR
    public Seleccion(String nombreFederacion,
                     String camisetaPrincipal,
                     String camisetaSecundaria,
                     boolean cabezaGrupo,
                     int rankingFIFA,
                     Pais pais,
                     DirectorTecnico directorTecnico) {

        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;

        this.pais = pais;
        this.directorTecnico = directorTecnico;
    }

    // GETTERS

    public String getNombreFederacion() {
        return nombreFederacion;
    }

    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    public boolean isCabezaGrupo() {
        return cabezaGrupo;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public Pais getPais() {
        return pais;
    }

    public DirectorTecnico getDirectorTecnico() {
        return directorTecnico;
    }

    // SETTERS

    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }

    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setDirectorTecnico(DirectorTecnico directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    // TOSTRING

    @Override
    public String toString() {

        String texto = "";

        texto += "Federacion: " + nombreFederacion + "\n";
        texto += "Pais: " + pais + "\n";
        texto += "Camiseta principal: " + camisetaPrincipal + "\n";
        texto += "Camiseta secundaria: " + camisetaSecundaria + "\n";
        texto += "Cabeza de grupo: " + cabezaGrupo + "\n";
        texto += "Ranking FIFA: " + rankingFIFA + "\n";

        texto += "\nDirector Tecnico:\n";
        texto += directorTecnico + "\n";

        texto += "\nJugadores:\n";

        for (Jugador j : jugadores) {
            texto += j + "\n";
        }

        texto += "\nCuerpo Tecnico:\n";

        for (CuerpoTecnico ct : cuerpoTecnico) {
            texto += ct + "\n";
        }

        return texto;
    }
}