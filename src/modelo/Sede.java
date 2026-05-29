import java.util.ArrayList;

public class Sede {

    //Atributos
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;

    //Relacion: una sede pertenece a un pais
    private Pais pais;

    //Relacion: una sede tiene uno o varios estadios
    private ArrayList<Estadio> estadios;
    
    //Constructor por defecto
    public Sede() {
        this.estadios = new ArrayList<Estadio>();
    }
    
    //Constructor Parametrizado
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = new ArrayList<Estadio>();
        
        // Vincula la sede con su país.
        if (pais != null) {
            pais.agregarSede(this);
        }
    }
    
    //Metodo agregar estadio
    public void agregarEstadio(Estadio estadio) {
        if (!estadios.contains(estadio)) {
            estadios.add(estadio);
        }
    }
    
    //Getters
    public String getCiudad() {
        return ciudad;
    }

    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public String getClima() {
        return clima;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public Pais getPais() {
        return pais;
    }

    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }

    //Setters
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setEstadios(ArrayList<Estadio> estadios) {
        this.estadios = estadios;
    }
    //toString
    @Override
    public String toString() {
        return "Ciudad: " + ciudad +
                ", Altura nivel mar: " + alturaNivelMar +
                ", Clima: " + clima +
                ", Zona horaria: " + zonaHoraria +
                ", Pais: " + pais.getNombre();
    }
}
