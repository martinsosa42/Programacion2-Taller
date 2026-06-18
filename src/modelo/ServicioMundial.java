import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
public class ServicioMundial {
    private Mundial mundial; 

    public ServicioMundial() {

    }
   public ServicioMundial(Mundial mundial) {
       this.mundial = mundial; 
   }   

    public List<Jugador> obtenerRankingGoleadores() {
    List<Jugador> goleadores = new ArrayList<>();

    // 1. Controlamos que la lista de sedes del mundial no esté vacía
    if (mundial.getSedes() != null) {

        for (Sede s : mundial.getSedes()) {

            Pais p = s.getPais();

            // 4. Validamos que el país tenga una selección y que esa selección tenga jugadores
            if (p != null && p.getSeleccion() != null && p.getSeleccion().getJugadores() != null) {
                // 5. Recorremos los jugadores de la selección
                for (Jugador j : p.getSeleccion().getJugadores()) {
                    // Filtramos solo a los que anotaron para armar el ranking
                    if (j.calcularGoles() > 0) {

                        if (!goleadores.contains(j)) {
                            goleadores.add(j);
                        }
                    }
                }
            }
        }
    }

    // Ordenamos descendentemente por goles
    Collections.sort(goleadores, new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            return Integer.compare(j2.calcularGoles(), j1.calcularGoles());
        }
    });

    return goleadores;
   }

   // 1.1 Tabla de Posiciones por Grupo (Ordenada por puntos y diferencia de gol)
    public List<Seleccion> obtenerTablaPosiciones(Grupo grupo) {
        if (grupo == null || grupo.getSelecciones() == null) {
            return new ArrayList<>();
        }
        
        List<Seleccion> clasificacion = new ArrayList<>(grupo.getSelecciones());
        
        // Ordenamos de mayor a menor puntaje utilizando el método del grupo
        Collections.sort(clasificacion, new Comparator<Seleccion>() {
            @Override
            public int compare(Seleccion s1, Seleccion s2) {
                int puntos1 = grupo.obtenerPuntos(s1);
                int puntos2 = grupo.obtenerPuntos(s2);
                
                if (puntos1 != puntos2) {
                    return Integer.compare(puntos2, puntos1);
                }
                // Criterio secundario: Diferencia de goles
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
    
        // 1. Mostrar puntos si tiene un grupo asignado
        if (seleccion.getGrupo() != null) {
            int puntos = seleccion.getGrupo().obtenerPuntos(seleccion);
            reporte += "- Fase de Grupos (" + seleccion.getGrupo().getIdentificacion() + "): " + puntos + " Puntos.\n";
        }
    
        reporte += "- Partidos Jugados:\n";
    
        // 2. Recorrido en sus participaciones para listar los partidos
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
    
        // Alineación Local
        ficha += " Local (" + partido.getSeleccionLocal().getNombreFederacion() + "):\n";
        for (Jugador j : partido.getSeleccionLocal().getJugadores()) {
            ficha += "   [#" + j.getDorsal() + "] " + j.getNombre() + " (" + j.getPosicion() + ")\n";
        }
    
        // Alineación Visitante
        ficha += " Visitante (" + partido.getSeleccionVisitante().getNombreFederacion() + "):\n";
        for (Jugador j : partido.getSeleccionVisitante().getJugadores()) {
            ficha += "   [#" + j.getDorsal() + "] " + j.getNombre() + " (" + j.getPosicion() + ")\n";
        }
    
        ficha += "-----------------------------------------\n"
           + "EVENTOS:\n";
    
        // Cronología de eventos del partido
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