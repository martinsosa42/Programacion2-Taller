import java.util.ArrayList;

public class Seleccion {

    //Atributos
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;

    // Relaciones
    private Pais pais;
    private Grupo grupo;
    private ArrayList<DirectorTecnico>directorTecnico;
    private ArrayList<Jugador> jugadores;
    private ArrayList<CuerpoTecnico> cuerpoTecnico;
    private ArrayList<Participacion> participaciones;
    
    //Constructor por defecto
    public Seleccion() {
        this.jugadores = new ArrayList<Jugador>();
        this.cuerpoTecnico = new ArrayList<CuerpoTecnico>();
        this.participaciones = new ArrayList<Participacion>();
        this.directorTecnico = new ArrayList<DirectorTecnico>();
    }
    
    //Constructor Parametrizado
    public Seleccion(String nombreFederacion, String camisetaPrincipal, 
                        String camisetaSecundaria,  boolean cabezaGrupo, 
                        int rankingFIFA, Pais pais, Grupo grupo) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.pais = pais;
        this.grupo = grupo;
        this.directorTecnico = new ArrayList<DirectorTecnico>();
        this.jugadores = new ArrayList<Jugador>();
        this.cuerpoTecnico = new ArrayList<CuerpoTecnico>();
        this.participaciones = new ArrayList<Participacion>();

        if (pais != null) {
            pais.setSeleccion(this);
        }
        if (directorTecnico != null) {
            directorTecnico.setSeleccion(this);
        }
    }

    public void agregarDirectorTecnico(DirectorTecnico directorTecnico) {
        if (!this.directorTecnico.contains(directorTecnico)) {
            this.directorTecnico.add(directorTecnico);
        }
    }

    public void agregarJugador(Jugador jugador) {
        if (!jugadores.contains(jugador)) {
            jugadores.add(jugador);
        }
    }

    public void agregarCuerpoTecnico(CuerpoTecnico cuerpoTecnico) {
        if (!this.cuerpoTecnico.contains(cuerpoTecnico)) {
            this.cuerpoTecnico.add(cuerpoTecnico);
        }
    }

    public void agregarParticipacion(Participacion participacion) {
        if (!participaciones.contains(participacion)) {
            participaciones.add(participacion);
        }
    }

    //Getters
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

    public Grupo getGrupo() {
        return grupo;
    }

    public ArrayList<DirectorTecnico> getDirectorTecnico() {
        return directorTecnico;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<CuerpoTecnico> getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }

    //Setters
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

    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setDirectorTecnico(ArrayList<DirectorTecnico> directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setCuerpoTecnico(ArrayList<CuerpoTecnico> cuerpoTecnico) {
        this.cuerpoTecnico = cuerpoTecnico;
    }

    public void setParticipaciones(ArrayList<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
    
    //toString
    @Override
    public String toString() {
        String texto = "";
        texto += "Federacion: " + nombreFederacion + "\n";
        texto += "Pais: " + pais.getNombre() + "\n";
        texto += "Camiseta principal: " + camisetaPrincipal + "\n";
        texto += "Camiseta secundaria: " + camisetaSecundaria + "\n";
        texto += "Cabeza de grupo: " + cabezaGrupo + "\n";
        texto += "Ranking FIFA: " + rankingFIFA + "\n";
        texto += "Director Tecnico: " + directorTecnico + "\n";
        texto += "Jugadores:\n";
        for (Jugador j : jugadores) {
            texto += "- " + j + "\n";
        }
        texto += "Cuerpo Tecnico:\n";
        for (CuerpoTecnico ct : cuerpoTecnico) {
            texto += "- " + ct + "\n";
        }
        return texto;
    }
}
