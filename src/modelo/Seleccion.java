import java.util.ArrayList;

public class Seleccion {

    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;

    private Pais pais;
    private DirectorTecnico directorTecnico;

    private ArrayList<Jugador> jugadores;
    private ArrayList<CuerpoTecnico> cuerpoTecnico;

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

        jugadores = new ArrayList<>();
        cuerpoTecnico = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {

        jugadores.add(jugador);
    }

    public void agregarCuerpoTecnico(CuerpoTecnico ct) {

        cuerpoTecnico.add(ct);
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

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    @Override
    public String toString() {

        String texto = "";

        texto += "Federacion: " + nombreFederacion + "\n";
        texto += "Ranking FIFA: " + rankingFIFA + "\n";
        texto += "Pais: " + pais.getNombre() + "\n";

        texto += "\nJUGADORES\n";

        for (Jugador j : jugadores) {

            texto += j + "\n";
        }
        return texto;
    }
}