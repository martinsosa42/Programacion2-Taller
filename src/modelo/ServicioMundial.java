
import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 

public class ServicioMundial {
    // ==========================================================
    // ATRIBUTOS Y COLECCIONES (Agregados para sincronizar con Main)
    // ==========================================================
    private Mundial mundial; 
    private List<Pais> paises;
    private List<Seleccion> selecciones;
    private List<Fase> fases;
    private List<Grupo> grupos;
    private List<Partido> partidos;

    // ==========================================================
    // CONSTRUCTORES
    // ==========================================================
    public ServicioMundial() {
        this.paises = new ArrayList<>();
        this.selecciones = new ArrayList<>();
        this.fases = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public ServicioMundial(Mundial mundial) {
        this();
        this.mundial = mundial; 
    }   

    /**
     * Constructor requerido por el Main.java (línea 504)
     * Ejemplo: gestion = new ServicioMundial(2026, "La'eeb", 20260610, 20260710);
     */
    public ServicioMundial(int anio, String mascota, int fechaInicio, int fechaFin) {
        this.mundial = new Mundial(anio, mascota, fechaInicio, fechaFin);
        this.paises = new ArrayList<>();
        this.selecciones = new ArrayList<>();
        this.fases = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    // ==========================================================
    // GETTERS GENERALES (Requeridos por Main)
    // ==========================================================
    public Mundial getMundial() {
        return this.mundial;
    }

    public List<Pais> getPaises() {
        return this.paises;
    }

    public List<Seleccion> getSelecciones() {
        return this.selecciones;
    }

    public List<Fase> getFases() {
        return this.fases;
    }

    public List<Grupo> getGrupos() {
        return this.grupos;
    }

    public List<Partido> getPartidos() {
        return this.partidos;
    }

    /**
     * Requerido por informeDisciplinarioJugador() en Main.java (línea 439)
     * Junta y devuelve todos los jugadores del mundial.
     */
    public List<Jugador> getJugadores() {
        List<Jugador> todos = new ArrayList<>();
        for (Seleccion sel : selecciones) {
            if (sel.getJugadores() != null) {
                todos.addAll(sel.getJugadores());
            }
        }
        return todos;
    }

    // ==========================================================
    // MÉTODOS DE REGISTRO / ALTAS (Requeridos por Main)
    // ==========================================================
    public void agregarPais(Pais pais) {
        if (pais != null && !paises.contains(pais)) {
            this.paises.add(pais);
        }
    }

    public void agregarSede(Sede sede) {
        if (sede != null) {
            // Se añade a la lista interna del mundial administrado
            this.mundial.agregarSede(sede);
        }
    }

    public void agregarSeleccion(Seleccion seleccion) {
        if (seleccion != null && !selecciones.contains(seleccion)) {
            this.selecciones.add(seleccion);
        }
    }

    public void agregarFase(Fase fase) {
        if (fase != null && !fases.contains(fase)) {
            this.fases.add(fase);
        }
    }

    public void agregarGrupo(Grupo grupo) {
        if (grupo != null && !grupos.contains(grupo)) {
            this.grupos.add(grupo);
        }
    }

    /**
     * Vincula un jugador a una selección. Requerido por Main.java (línea 164)
     * Lanza excepción si el jugador ya está en otra selección.
     */
    public void agregarJugadorASeleccion(Jugador jugador, Seleccion seleccion) throws JugadorYaVinculadoException {
        for (Seleccion sel : selecciones) {
            if (sel.getJugadores() != null && sel.getJugadores().contains(jugador)) {
                // Le pasamos las variables 'jugador' y 'sel' que tenés en tu bucle for
                throw new JugadorYaVinculadoException(jugador, sel);
            }
        }
        seleccion.agregarJugador(jugador);
    }

    /**
     * Registra un partido verificado en el sistema. Requerido por Main.java (línea 313)
     */
    public void registrarPartido(Partido partido) throws ArbitrajeInvalidoException {
        if (partido == null) return;
        
        // Validación básica de seguridad del equipo de árbitros
        if (partido.getArbitrajes() == null || partido.getArbitrajes().size() < 6) {
            throw new ArbitrajeInvalidoException("El partido no posee el equipo arbitral completo (6 categorías).");
        }
        
        if (!partidos.contains(partido)) {
            this.partidos.add(partido);
        }
    }


    // ==========================================================
    // TUS MÉTODOS ORIGINALES DE INFORMES (CONSERVADOS)
    // ==========================================================

    public List<Jugador> obtenerRankingGoleadores() {
        List<Jugador> goleadores = new ArrayList<>();

        if (mundial.getSedes() != null) {
            for (Sede s : mundial.getSedes()) {
                Pais p = s.getPais();
                if (p != null && p.getSeleccion() != null && p.getSeleccion().getJugadores() != null) {
                    for (Jugador j : p.getSeleccion().getJugadores()) {
                        if (j.calcularGoles() > 0) {
                            if (!goleadores.contains(j)) {
                                goleadores.add(j);
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(goleadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                return Integer.compare(j2.calcularGoles(), j1.calcularGoles());
            }
        });

        return goleadores;
    }

    public List<Seleccion> obtenerTablaPosiciones(Grupo grupo) {
        if (grupo == null || grupo.getSelecciones() == null) {
            return new ArrayList<>();
        }
        
        List<Seleccion> clasificacion = new ArrayList<>(grupo.getSelecciones());
        
        Collections.sort(clasificacion, new Comparator<Seleccion>() {
            @Override
            public int compare(Seleccion s1, Seleccion s2) {
                int puntos1 = grupo.obtenerPuntos(s1);
                int puntos2 = grupo.obtenerPuntos(s2);
                
                if (puntos1 != puntos2) {
                    return Integer.compare(puntos2, puntos1);
                }
                return Integer.compare(calcularDiferenciaDeGol(s2, grupo), calcularDiferenciaDeGol(s1, grupo));
            }
        });
        
        return clasificacion;
    }

    private int calcularDiferenciaDeGol(Seleccion s, Grupo g) {
        int golesAFavor = 0;
        int golesEnContra = 0;

        if (g.getFase() == null || g.getFase().getPartidos() == null){
            return 0;
        }

        for (Partido p : g.getFase().getPartidos()) {
            if (p.getSeleccionLocal() != null && p.getSeleccionLocal().equals(s)) {
                golesAFavor += p.getGolesLocal();
                golesEnContra += p.getGolesVisitante();
            } else if (p.getSeleccionVisitante() != null && p.getSeleccionVisitante().equals(s)) {
                golesAFavor += p.getGolesVisitante();
                golesEnContra += p.getGolesLocal();
            }
        }
        return golesAFavor - golesEnContra;
    }

    public String obtenerResultadosPorSeleccion(Seleccion seleccion) {
        if (seleccion == null) {
            return "Selección no válida.";
        }

        String reporte = "TABLA DE RESULTADOS PARA: " + seleccion.getNombreFederacion() + "\n";
    
        if (seleccion.getGrupo() != null) {
            int puntos = seleccion.getGrupo().obtenerPuntos(seleccion);
            reporte += "- Fase de Grupos (" + seleccion.getGrupo().getIdentificacion() + "): " + puntos + " Puntos.\n";
        }
    
        reporte += "- Partidos Jugados:\n";
    
        for (Participacion p : seleccion.getParticipaciones()) {
            Partido partido = p.getPartido();
        
            reporte += "  * Instancia: " + partido.getFase() + " -> "
                + partido.getSeleccionLocal().getNombreFederacion() + " " 
                + partido.getGolesLocal() + " - "
                + partido.getGolesVisitante() + " " 
                + partido.getSeleccionVisitante().getNombreFederacion() + "\n";
        }
        return reporte;
    }

    public String generarInformeDisciplinarioPorSeleccion(List<Seleccion> selecciones) {
        if (selecciones == null || selecciones.isEmpty()){
            return "No hay selecciones registradas para el informe.";
        }
    
        String reporte = " INFORME DISCIPLINARIO POR SELECCIÓN \n";
    
        for (Seleccion sel : selecciones) {
            int totalAmarillas = 0;
            int totalRojas = 0;
    
            for (Participacion p : sel.getParticipaciones()) {
                totalAmarillas += p.cantidadTarjAmarillas();
                totalRojas += p.cantidadTarjRojas();
            }
        
            reporte += " Selección: " + sel.getNombreFederacion() + "\n"
                + "Total Tarjetas Amarillas: " + totalAmarillas + "\n"
                + "Total Tarjetas Rojas: " + totalRojas + "\n";
            }
        return reporte;
    }

    public String generarInformeDisciplinarioPorJugador(List<Jugador> jugadores) {
        if (jugadores == null || jugadores.isEmpty()) {
            return "No hay jugadores registrados para el informe.";
        }
    
        String reporte = "INFORME DISCIPLINARIO INDIVIDUAL POR JUGADOR \n";
    
        for (Jugador j : jugadores) {
            int amarillas = 0;
            int rojas = 0;
        
            for (Evento e : j.getEventos()) {
                if (e.getTipo() == TipoEvento.TARJETA_AMARILLA) {
                    amarillas++;
                } else if (e.getTipo() == TipoEvento.TARJETA_ROJA || e.getTipo() == TipoEvento.DOBLE_AMARILLA) {
                    rojas++;
                }
            }

            reporte += j.getNombre() + " (" + j.getPosicion() + ")\n"
                    +"Tarjetas Amarillas: " + amarillas + "\n"
                    +"Tarjetas Rojas: " + rojas + "\n";
        }
        return reporte;
    }

    public String generarFichaTecnicaPartido(Partido partido) {
        if (partido == null){ 
            return "Partido inexistente.";
        }

        String ficha = "FICHA TÉCNICA DEL PARTIDO\n"
                     + "=========================================\n"
                     + "Estadio: " + partido.getEstadio().getNombre() 
                     + " (" + partido.getEstadio().getSede().getCiudad() + ")\n"
                     + "Fecha: " + partido.getFecha() + " | Hora: " + partido.getHora() + "\n"
                     + "Fase: " + partido.getFase() + "\n"
                     + "-----------------------------------------\n"
                     + "RESULTADO: " + partido.getSeleccionLocal().getNombreFederacion() + " " 
                     + partido.getGolesLocal() + " - " + partido.getGolesVisitante() + " " 
                     + partido.getSeleccionVisitante().getNombreFederacion() + "\n"
                     + "-----------------------------------------\n"
                     + "ALINEACIONES:\n";
    
        ficha += " Local (" + partido.getSeleccionLocal().getNombreFederacion() + "):\n";
        for (Jugador j : partido.getSeleccionLocal().getJugadores()) {
            ficha += "   [#" + j.getDorsal() + "] " + j.getNombre() + " (" + j.getPosicion() + ")\n";
        }
    
        ficha += " Visitante (" + partido.getSeleccionVisitante().getNombreFederacion() + "):\n";
        for (Jugador j : partido.getSeleccionVisitante().getJugadores()) {
            ficha += "   [#" + j.getDorsal() + "] " + j.getNombre() + " (" + j.getPosicion() + ")\n";
        }
    
        ficha += "-----------------------------------------\n"
               + "EVENTOS:\n";
    
        if (partido.getEventos().isEmpty()) {
            ficha += " No se registraron eventos.\n";
        } else {
            for (Evento e : partido.getEventos()) {
                ficha += " Minuto " + e.getMinuto() + " | " + e.getTipo() 
                      + " -> " + e.getJugador().getNombre() + "\n";
            }
        }
        return ficha;
    }
}