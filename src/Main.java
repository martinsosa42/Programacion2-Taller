import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static ServicioMundial servicio = new ServicioMundial();
    private static Scanner scanner = new Scanner(System.in);

    // Referencias globales para poder usarlas desde el menú
    private static Grupo grupoA;
    private static Grupo grupoB;
    private static Seleccion selArgentina;
    private static Seleccion selFrancia;
    private static Seleccion selBrasil;
    private static Seleccion selAlemania;
    private static Partido partido1;
    private static Partido partido2;

    public static void main(String[] args) {
        cargarDatosDePrueba();

        int opcion = -1;
        do {
            System.out.println("\n===========================================");
            System.out.println("     SISTEMA DE GESTIÓN - MUNDIAL 2026");
            System.out.println("===========================================");
            System.out.println("1. Consultas e informes");
            System.out.println("2. Gestión del Mundial");
            System.out.println("3. Gestión de partidos");
            System.out.println("0. Salir");
            System.out.println("===========================================");
            System.out.print("Opción: ");

            try {
                String entrada = scanner.nextLine().trim();
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1:
                        menuConsultas();
                        break;
                    case 2:
                        menuGestionMundial();
                        break;
                    case 3:
                        menuGestionPartidos();
                        break;
                    case 0:
                        System.out.println("\n¡Hasta luego!");
                        break;
                    default:
                        System.out.println("\n Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n Ingresá un número válido.");
                opcion = -1;
            }
        } while (opcion != 0);
    }

    // ==========================================================
    // SUBMENÚ: CONSULTAS E INFORMES
    // ==========================================================
    private static void menuConsultas() {
        int opcion = -1;
        do {
            System.out.println("\n--- CONSULTAS E INFORMES ---");
            System.out.println("1. Datos generales del Mundial");
            System.out.println("2. Tabla de posiciones por grupo");
            System.out.println("3. Resultados por selección");
            System.out.println("4. Ranking de goleadores");
            System.out.println("5. Informe disciplinario por selección");
            System.out.println("6. Informe disciplinario por jugador");
            System.out.println("7. Ficha técnica de partido");
            System.out.println("8. Estadísticas de estadio/sede");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                switch (opcion) {
                    case 1: mostrarDatosGenerales(); break;
                    case 2: mostrarTablaPosiciones(); break;
                    case 3: mostrarResultadosPorSeleccion(); break;
                    case 4: mostrarRankingGoleadores(); break;
                    case 5: System.out.println(servicio.generarInformeDisciplinarioPorSeleccion(servicio.getSelecciones())); break;
                    case 6: System.out.println(servicio.generarInformeDisciplinarioPorJugador(servicio.getJugadores())); break;
                    case 7: mostrarFichaTecnica(); break;
                    case 8: mostrarEstadisticasSede(); break;
                    case 0: break;
                    default: System.out.println("\n Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n Ingresá un número válido.");
                opcion = -1;
            }
        } while (opcion != 0);
    }

    // ==========================================================
    // SUBMENÚ: GESTIÓN DEL MUNDIAL (países, sedes, selecciones, etc.)
    // ==========================================================
    private static void menuGestionMundial() {
        int opcion = -1;
        do {
            System.out.println("\n--- GESTIÓN DEL MUNDIAL ---");
            System.out.println("1. Crear nuevo mundial");
            System.out.println("--- Infraestructura ---");
            System.out.println("2. Agregar país");
            System.out.println("3. Agregar sede");
            System.out.println("4. Agregar estadio");
            System.out.println("--- Equipos ---");
            System.out.println("5. Agregar grupo");
            System.out.println("6. Agregar selección a un país");
            System.out.println("7. Agregar jugador a una selección");
            System.out.println("--- Arbitraje ---");
            System.out.println("8. Agregar árbitro");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                switch (opcion) {
                    case 1: crearMundialInteractivo(); break;
                    case 2: agregarPaisInteractivo(); break;
                    case 3: agregarSedeInteractivo(); break;
                    case 4: agregarEstadioInteractivo(); break;
                    case 5: agregarGrupoInteractivo(); break;
                    case 6: agregarSeleccionInteractivo(); break;
                    case 7: agregarJugadorInteractivo(); break;
                    case 8: agregarArbitroInteractivo(); break;
                    case 0: break;
                    default: System.out.println("\n Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n Ingresá un número válido.");
                opcion = -1;
            }
        } while (opcion != 0);
    }

    // ==========================================================
    // SUBMENÚ: GESTIÓN DE PARTIDOS
    // ==========================================================
    private static void menuGestionPartidos() {
        int opcion = -1;
        do {
            System.out.println("\n--- GESTIÓN DE PARTIDOS ---");
            System.out.println("1. Registrar partido");
            System.out.println("2. Registrar evento en un partido");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
                switch (opcion) {
                    case 1: registrarPartidoInteractivo(); break;
                    case 2: registrarEventoInteractivo(); break;
                    case 0: break;
                    default: System.out.println("\n Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n Ingresá un número válido.");
                opcion = -1;
            }
        } while (opcion != 0);
    }

    // ==========================================================
    // CARGA DE DATOS DE PRUEBA
    // ==========================================================
    private static void cargarDatosDePrueba() {
        System.out.println("Cargando datos de prueba...");

        // --- MUNDIAL ---
        Mundial mundial = new Mundial(2026, "Tazuni", 20260611, 20260719);

        // --- PAÍSES ---
        Pais pArgentina = new Pais("Argentina", "Celeste y Blanco", null);
        Pais pFrancia   = new Pais("Francia",   "Azul, Blanco y Rojo", null);
        Pais pBrasil    = new Pais("Brasil",     "Verde y Amarillo", null);
        Pais pAlemania  = new Pais("Alemania",   "Negro, Rojo y Amarillo", null);
        Pais pEspaña    = new Pais("España",     "Rojo y Amarillo", null); // país anfitrión de sedes

        servicio = new ServicioMundial(mundial);
        servicio.agregarPais(pArgentina);
        servicio.agregarPais(pFrancia);
        servicio.agregarPais(pBrasil);
        servicio.agregarPais(pAlemania);
        servicio.agregarPais(pEspaña);

        // --- SEDES Y ESTADIOS ---
        Sede sedeMadrid    = new Sede("Madrid",    667, "Templado", "CET", pEspaña);
        Sede sedeBarcelona = new Sede("Barcelona", 12,  "Mediterráneo", "CET", pEspaña);

        Estadio estadioBernabeu  = new Estadio("Santiago Bernabéu", 81044, sedeMadrid);
        Estadio estadioCampNou   = new Estadio("Camp Nou",          99354, sedeBarcelona);

        servicio.agregarSede(sedeMadrid);
        servicio.agregarSede(sedeBarcelona);

        // --- FASES ---
        Fase faseGrupos = new Fase(NombreFase.GRUPOS);
        Fase faseOctavos = new Fase(NombreFase.OCTAVOS);
        servicio.agregarFase(faseGrupos);
        servicio.agregarFase(faseOctavos);

        // --- GRUPOS ---
        grupoA = new Grupo("A", "Grupo A del Mundial 2026", faseGrupos);
        grupoB = new Grupo("B", "Grupo B del Mundial 2026", faseGrupos);
        faseGrupos.agregarGrupo(grupoA);
        faseGrupos.agregarGrupo(grupoB);
        servicio.agregarGrupo(grupoA);
        servicio.agregarGrupo(grupoB);

        // --- SELECCIONES ---
        selArgentina = new Seleccion("Argentina", "Celeste y Blanca", "Azul oscuro", true,  1, pArgentina, grupoA);
        selFrancia   = new Seleccion("Francia",   "Azul",            "Blanca",       false, 2, pFrancia,   grupoA);
        selBrasil    = new Seleccion("Brasil",     "Amarilla",        "Azul",         true,  3, pBrasil,    grupoB);
        selAlemania  = new Seleccion("Alemania",   "Blanca",          "Negra",        false, 4, pAlemania,  grupoB);

        grupoA.agregarSeleccion(selArgentina);
        grupoA.agregarSeleccion(selFrancia);
        grupoB.agregarSeleccion(selBrasil);
        grupoB.agregarSeleccion(selAlemania);

        servicio.agregarSeleccion(selArgentina);
        servicio.agregarSeleccion(selFrancia);
        servicio.agregarSeleccion(selBrasil);
        servicio.agregarSeleccion(selAlemania);

        // --- DIRECTORES TÉCNICOS ---
        DirectorTecnico dtArgentina = new DirectorTecnico("Lionel Scaloni", 1978, 20231101);
        DirectorTecnico dtFrancia   = new DirectorTecnico("Didier Deschamps", 1968, 20121008);
        DirectorTecnico dtBrasil    = new DirectorTecnico("Dorival Junior",   1961, 20240111);
        DirectorTecnico dtAlemania  = new DirectorTecnico("Julian Nagelsmann", 1987, 20230923);

        selArgentina.agregarDirectorTecnico(dtArgentina);
        selFrancia.agregarDirectorTecnico(dtFrancia);
        selBrasil.agregarDirectorTecnico(dtBrasil);
        selAlemania.agregarDirectorTecnico(dtAlemania);

        // --- CUERPO TÉCNICO ---
        selArgentina.agregarCuerpoTecnico(new CuerpoTecnico("Walter Samuel", 1978, Rol.AYUDANTE_CAMPO));
        selArgentina.agregarCuerpoTecnico(new CuerpoTecnico("Luis Martín",   1975, Rol.PREPARADOR_FISICO));
        selFrancia.agregarCuerpoTecnico(new CuerpoTecnico("Franck Raviot",   1974, Rol.ENTRENADOR_ARQUEROS));

        // --- JUGADORES ARGENTINA ---
        Jugador messi    = new Jugador("Lionel Messi",   1987, 10, Posicion.DELANTERO,     72.0f, 1.70f);
        Jugador diMaria  = new Jugador("Ángel Di María", 1988, 11, Posicion.MEDIOCAMPISTA,  75.0f, 1.78f);
        Jugador martinez = new Jugador("Lautaro Martínez", 1997, 22, Posicion.DELANTERO,   78.0f, 1.74f);
        Jugador romero   = new Jugador("Cristian Romero", 1998, 13, Posicion.DEFENSOR,      85.0f, 1.85f);
        Jugador dibuMartinez = new Jugador("Emiliano Martínez", 1992, 23, Posicion.ARQUERO, 90.0f, 1.95f);

        selArgentina.agregarJugador(messi);
        selArgentina.agregarJugador(diMaria);
        selArgentina.agregarJugador(martinez);
        selArgentina.agregarJugador(romero);
        selArgentina.agregarJugador(dibuMartinez);

        // --- JUGADORES FRANCIA ---
        Jugador mbappe   = new Jugador("Kylian Mbappé",  1977, 10, Posicion.DELANTERO,    78.0f, 1.78f);
        Jugador griezmann= new Jugador("Antoine Griezmann", 1991, 7, Posicion.MEDIOCAMPISTA,    73.0f, 1.76f);
        Jugador pogba    = new Jugador("Aurélien Tchouaméni", 2000, 8, Posicion.MEDIOCAMPISTA,  80.0f, 1.87f);
        Jugador varane   = new Jugador("Raphaël Varane", 1993, 4, Posicion.DEFENSOR,            91.0f, 1.91f);
        Jugador lloris   = new Jugador("Mike Maignan",   1995, 16, Posicion.ARQUERO,            85.0f, 1.91f);

        selFrancia.agregarJugador(mbappe);
        selFrancia.agregarJugador(griezmann);
        selFrancia.agregarJugador(pogba);
        selFrancia.agregarJugador(varane);
        selFrancia.agregarJugador(lloris);

        // --- JUGADORES BRASIL ---
        Jugador vinicius = new Jugador("Vinícius Jr.",   2000, 7,  Posicion.DELANTERO,     73.0f, 1.76f);
        Jugador rodrygo  = new Jugador("Rodrygo",        2001, 11, Posicion.DELANTERO,      72.0f, 1.74f);
        Jugador casemiro = new Jugador("Casemiro",       1992, 5,  Posicion.MEDIOCAMPISTA,  84.0f, 1.85f);
        Jugador militao  = new Jugador("Éder Militão",   1998, 3,  Posicion.DEFENSOR,       83.0f, 1.86f);
        Jugador alisson  = new Jugador("Alisson Becker", 1992, 1,  Posicion.ARQUERO,        91.0f, 1.93f);

        selBrasil.agregarJugador(vinicius);
        selBrasil.agregarJugador(rodrygo);
        selBrasil.agregarJugador(casemiro);
        selBrasil.agregarJugador(militao);
        selBrasil.agregarJugador(alisson);

        // --- JUGADORES ALEMANIA ---
        Jugador kane     = new Jugador("Harry Kane",     1993, 9,  Posicion.DELANTERO,     86.0f, 1.88f);
        Jugador musiala  = new Jugador("Jamal Musiala",  2003, 10, Posicion.MEDIOCAMPISTA, 70.0f, 1.80f);
        Jugador kroos    = new Jugador("Florian Wirtz",  2003, 17, Posicion.MEDIOCAMPISTA, 68.0f, 1.80f);
        Jugador rudiger  = new Jugador("Antonio Rüdiger",1993, 2,  Posicion.DEFENSOR,      85.0f, 1.90f);
        Jugador neuer    = new Jugador("Manuel Neuer",   1986, 1,  Posicion.ARQUERO,       92.0f, 1.93f);

        selAlemania.agregarJugador(kane);
        selAlemania.agregarJugador(musiala);
        selAlemania.agregarJugador(kroos);
        selAlemania.agregarJugador(rudiger);
        selAlemania.agregarJugador(neuer);

        // --- ÁRBITROS ---
        Arbitro arbPrincipal = new Arbitro("Szymon Marciniak", 1981, 12, pEspaña);
        Arbitro arbAsis1     = new Arbitro("Tomasz Listkiewicz", 1983, 10, pEspaña);
        Arbitro arbAsis2     = new Arbitro("Adam Kupsik",       1985, 8,  pEspaña);
        Arbitro arbCuarto    = new Arbitro("Carlos Padilla",    1979, 9,  pEspaña);
        Arbitro arbVarP      = new Arbitro("Ivan Bebek",        1980, 11, pEspaña);
        Arbitro arbVarA      = new Arbitro("José Navas",        1982, 7,  pEspaña);

        // --- PARTIDO 1: Argentina vs Francia (Grupo A) ---
        partido1 = new Partido("15/06/2026", "20:00", 90, 5, NombreFase.GRUPOS, estadioBernabeu);
        partido1.setSeleccionLocal(selArgentina);
        partido1.setSeleccionVisitante(selFrancia);

        try {
            partido1.agregarArbitraje(new Arbitraje(arbPrincipal, CategoriaArbitro.PRINCIPAL));
            partido1.agregarArbitraje(new Arbitraje(arbAsis1,     CategoriaArbitro.ASISTENTE1));
            partido1.agregarArbitraje(new Arbitraje(arbAsis2,     CategoriaArbitro.ASISTENTE2));
            partido1.agregarArbitraje(new Arbitraje(arbCuarto,    CategoriaArbitro.CUARTO_ARBITRO));
            partido1.agregarArbitraje(new Arbitraje(arbVarP,      CategoriaArbitro.VAR_PRINCIPAL));
            partido1.agregarArbitraje(new Arbitraje(arbVarA,      CategoriaArbitro.VAR_ASISTENTE));
        } catch (ArbitrajeInvalidoException e) {
            System.out.println("Error arbitraje partido 1: " + e.getMessage());
        }

        // Registrar resultado 2-1 Argentina
        partido1.registrarResultado(2, 1);

        // Eventos partido 1
        try {
            Evento gol1 = new Evento(TipoEvento.GOL, 23, messi);
            Evento gol2 = new Evento(TipoEvento.GOL, 67, martinez);
            Evento gol3 = new Evento(TipoEvento.GOL, 79, mbappe);
            Evento tarj1 = new Evento(TipoEvento.TARJETA_AMARILLA, 55, romero);
            Evento tarj2 = new Evento(TipoEvento.TARJETA_AMARILLA, 88, varane);
            partido1.agregarEvento(gol1);
            partido1.agregarEvento(gol2);
            partido1.agregarEvento(gol3);
            partido1.agregarEvento(tarj1);
            partido1.agregarEvento(tarj2);
        } catch (EventoJugadorNoParticipaException e) {
            System.out.println("Error evento partido 1: " + e.getMessage());
        }

        // Participaciones partido 1
        Participacion part1Local    = new Participacion(true,  selArgentina, partido1);
        Participacion part1Visitante= new Participacion(false, selFrancia,   partido1);
        selArgentina.agregarParticipacion(part1Local);
        selFrancia.agregarParticipacion(part1Visitante);
        partido1.agregarParticipaciones(part1Local);
        partido1.agregarParticipaciones(part1Visitante);
        faseGrupos.agregarPartido(partido1);
        estadioBernabeu.agregarPartido(partido1);

        // --- PARTIDO 2: Brasil vs Alemania (Grupo B) ---
        partido2 = new Partido("16/06/2026", "18:00", 90, 3, NombreFase.GRUPOS, estadioCampNou);
        partido2.setSeleccionLocal(selBrasil);
        partido2.setSeleccionVisitante(selAlemania);

        try {
            partido2.agregarArbitraje(new Arbitraje(arbPrincipal, CategoriaArbitro.PRINCIPAL));
            partido2.agregarArbitraje(new Arbitraje(arbAsis1,     CategoriaArbitro.ASISTENTE1));
            partido2.agregarArbitraje(new Arbitraje(arbAsis2,     CategoriaArbitro.ASISTENTE2));
            partido2.agregarArbitraje(new Arbitraje(arbCuarto,    CategoriaArbitro.CUARTO_ARBITRO));
            partido2.agregarArbitraje(new Arbitraje(arbVarP,      CategoriaArbitro.VAR_PRINCIPAL));
            partido2.agregarArbitraje(new Arbitraje(arbVarA,      CategoriaArbitro.VAR_ASISTENTE));
        } catch (ArbitrajeInvalidoException e) {
            System.out.println("Error arbitraje partido 2: " + e.getMessage());
        }

        partido2.registrarResultado(1, 2);

        // Eventos partido 2
        try {
            Evento gol4  = new Evento(TipoEvento.GOL, 15, kane);
            Evento gol5  = new Evento(TipoEvento.PENAL_CONVERTIDO, 44, musiala);
            Evento gol6  = new Evento(TipoEvento.GOL, 70, vinicius);
            Evento tarj3 = new Evento(TipoEvento.TARJETA_ROJA, 80, casemiro);
            partido2.agregarEvento(gol4);
            partido2.agregarEvento(gol5);
            partido2.agregarEvento(gol6);
            partido2.agregarEvento(tarj3);
        } catch (EventoJugadorNoParticipaException e) {
            System.out.println("Error evento partido 2: " + e.getMessage());
        }

        // Participaciones partido 2
        Participacion part2Local     = new Participacion(true,  selBrasil,   partido2);
        Participacion part2Visitante = new Participacion(false, selAlemania, partido2);
        selBrasil.agregarParticipacion(part2Local);
        selAlemania.agregarParticipacion(part2Visitante);
        partido2.agregarParticipaciones(part2Local);
        partido2.agregarParticipaciones(part2Visitante);
        faseGrupos.agregarPartido(partido2);
        estadioCampNou.agregarPartido(partido2);

        // Registrar partidos en el servicio
        try {
            servicio.registrarPartido(partido1);
            servicio.registrarPartido(partido2);
        } catch (ArbitrajeInvalidoException e) {
            System.out.println("Error al registrar partido: " + e.getMessage());
        }

        System.out.println(" Datos de prueba cargados: 4 selecciones, 2 partidos, eventos registrados.\n");
    }

    // ==========================================================
    // OPCIONES DEL MENÚ
    // ==========================================================

    private static void mostrarDatosGenerales() {
        System.out.println("\n==========================================");
        System.out.println("          DATOS GENERALES DEL MUNDIAL");
        System.out.println("==========================================");
        System.out.println("Selecciones registradas: " + servicio.getSelecciones().size());
        for (Seleccion s : servicio.getSelecciones()) {
            System.out.println("  - " + s.getNombreFederacion() + " (Ranking FIFA: " + s.getRankingFIFA() + ")");
        }
        System.out.println("\nPartidos registrados: " + servicio.getPartidos().size());
        for (Partido p : servicio.getPartidos()) {
            System.out.println("  - " + p.getSeleccionLocal().getNombreFederacion()
                + " " + p.getGolesLocal() + " - " + p.getGolesVisitante()
                + " " + p.getSeleccionVisitante().getNombreFederacion()
                + " | " + p.getFecha());
        }
        System.out.println("\nGrupos:");
        for (Grupo g : servicio.getGrupos()) {
            List<Seleccion> sels = g.getSelecciones();
            if (sels.isEmpty()) {
                System.out.println("  Grupo " + g.getIdentificacion() + ": (sin selecciones)");
            } else {
                String integrantes = "";
                for (int i = 0; i < sels.size(); i++) {
                    if (i > 0) integrantes += " / ";
                    integrantes += sels.get(i).getNombreFederacion();
                }
                System.out.println("  Grupo " + g.getIdentificacion() + ": " + integrantes);
            }
        }
    }

    private static void mostrarTablaPosiciones() {
        System.out.println("\n==========================================");
        System.out.println("        TABLA DE POSICIONES POR GRUPO");
        System.out.println("==========================================");

        for (Grupo g : servicio.getGrupos()) {
            System.out.println("\n--- GRUPO " + g.getIdentificacion() + " ---");
            System.out.printf("%-20s %6s%n", "Selección", "Puntos");
            System.out.println("-----------------------------");
            List<Seleccion> tabla = servicio.obtenerTablaPosiciones(g);
            for (Seleccion s : tabla) {
                System.out.printf("%-20s %6d%n", s.getNombreFederacion(), g.obtenerPuntos(s));
            }
        }
    }

    private static void mostrarResultadosPorSeleccion() {
        List<Seleccion> lista = servicio.getSelecciones();
        if (lista.isEmpty()) {
            System.out.println(" No hay selecciones registradas.");
            return;
        }
        System.out.println("\nSelecciones disponibles:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).getNombreFederacion());
        }
        int idx = leerEnteroEnRango("Elegí un número (1-" + lista.size() + "): ", 1, lista.size()) - 1;
        System.out.println(servicio.obtenerResultadosPorSeleccion(lista.get(idx)));
    }

    private static void mostrarRankingGoleadores() {
        System.out.println("\n==========================================");
        System.out.println("          RANKING DE GOLEADORES");
        System.out.println("==========================================");

        List<Jugador> goleadores = servicio.obtenerRankingGoleadores();

        if (goleadores.isEmpty()) {
            System.out.println("Aún no hay goles registrados.");
        } else {
            int pos = 1;
            for (Jugador j : goleadores) {
                System.out.printf("%2d. %-25s  %d gol(es)%n", pos++, j.getNombre(), j.calcularGoles());
            }
        }
    }

    private static void mostrarFichaTecnica() {
        List<Partido> lista = servicio.getPartidos();
        if (lista.isEmpty()) {
            System.out.println(" No hay partidos registrados.");
            return;
        }
        System.out.println("\nPartidos disponibles:");
        for (int i = 0; i < lista.size(); i++) {
            Partido p = lista.get(i);
            System.out.println((i + 1) + ". " + p.getSeleccionLocal().getNombreFederacion()
                + " vs " + p.getSeleccionVisitante().getNombreFederacion()
                + " (" + p.getFecha() + ")");
        }
        int idx = leerEnteroEnRango("Elegí un número (1-" + lista.size() + "): ", 1, lista.size()) - 1;
        System.out.println(servicio.generarFichaTecnicaPartido(lista.get(idx)));
    }

    private static void mostrarEstadisticasSede() {
        System.out.println("\n==========================================");
        System.out.println("        ESTADÍSTICAS POR ESTADIO");
        System.out.println("==========================================");
        for (Partido p : servicio.getPartidos()) {
            Estadio est = p.getEstadio();
            System.out.println("Estadio: " + est.getNombre()
                + " (" + est.getSede().getCiudad() + ")"
                + " — Partidos jugados: " + est.getPartidos().size());
        }
        // Evitamos duplicados agrupando por estadio
        Set<Estadio> vistos = new HashSet<>();
        System.out.println("\nResumen único por estadio:");
        for (Partido p : servicio.getPartidos()) {
            Estadio est = p.getEstadio();
            if (vistos.add(est)) {
                System.out.println("  " + est.getNombre()
                    + " (" + est.getSede().getCiudad() + ")"
                    + " → " + est.getPartidos().size() + " partido(s), capacidad: " + est.getCapacidad());
            }
        }
    }

    private static void agregarPaisInteractivo() {
        System.out.println("\n--- AGREGAR PAÍS ---");

        // Validación: nombre del país (solo letras, tildes, espacios)
        String nombre = leerNombre("Nombre del país: ");

        // Validación: colores de la bandera no vacíos
        String bandera = leerStringNoVacio("Colores de la bandera (ej: Azul, Blanco, Amarillo): ");

        Pais nuevo = new Pais(nombre, bandera, null);
        servicio.agregarPais(nuevo);
        System.out.println(" País '" + nombre + "' agregado correctamente.");

        if (leerSiNo("\n¿Querés vincular una selección a este país ahora?")) {
            System.out.println("\n--- DATOS DE LA SELECCIÓN ---");

            // Validación: nombre federación (solo letras)
            String nombreFed = leerNombre("Nombre de la federación: ");

            // Validación: colores no vacíos
            String colorTitular  = leerStringNoVacio("Color camiseta titular: ");
            String colorSuplente = leerStringNoVacio("Color camiseta suplente: ");

            boolean esSede = leerSiNo("¿Es sede local?");

            // Validación: ranking FIFA entre 1 y 211
            int rankingFIFA = leerEnteroEnRango("Ranking FIFA (1-211): ", 1, 211);

            // Elegir grupo (opcional)
            List<Grupo> grupos = servicio.getGrupos();
            Grupo grupoElegido = null;
            if (!grupos.isEmpty()) {
                System.out.println("\nGrupos disponibles (Enter para omitir):");
                for (int i = 0; i < grupos.size(); i++) {
                    System.out.println((i + 1) + ". Grupo " + grupos.get(i).getIdentificacion());
                }
                System.out.print("Opción: ");
                String entradaGrupo = scanner.nextLine().trim();
                if (!entradaGrupo.isEmpty()) {
                    try {
                        int idxG = Integer.parseInt(entradaGrupo) - 1;
                        if (idxG >= 0 && idxG < grupos.size()) {
                            grupoElegido = grupos.get(idxG);
                        } else {
                            System.out.println(" Número fuera de rango. Se creará la selección sin grupo.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(" Entrada inválida. Se creará la selección sin grupo.");
                    }
                }
            }

            Seleccion nuevaSeleccion = new Seleccion(nombreFed, colorTitular, colorSuplente,
                    esSede, rankingFIFA, nuevo, grupoElegido);

            if (grupoElegido != null) {
                grupoElegido.agregarSeleccion(nuevaSeleccion);
            }
            servicio.agregarSeleccion(nuevaSeleccion);

            System.out.println(" Selección '" + nombreFed + "' creada y vinculada al país '" + nombre + "'.");
        }
    }

    private static void agregarJugadorInteractivo() {
        System.out.println("\n--- AGREGAR JUGADOR ---");

        // Validación: nombre (solo letras, tildes, espacios)
        String nombre = leerNombre("Nombre: ");

        // Validación: año de nacimiento (rango realista para un futbolista activo)
        int fec = leerEnteroEnRango("Año de nacimiento (1970-2010): ", 1970, 2010);

        // Validación: dorsal entre 1 y 99
        int dorsal = leerEnteroEnRango("Dorsal (1-99): ", 1, 99);

        // Validación: posición dentro de las opciones disponibles
        System.out.println("Posición: 1.ARQUERO  2.DEFENSOR  3.MEDIOCAMPISTA  4.DELANTERO");
        int opcPos = leerEnteroEnRango("Opción (1-4): ", 1, 4);
        Posicion[] posiciones = Posicion.values();
        Posicion pos = posiciones[opcPos - 1];

        // Validación: peso en kg (rango razonable)
        float peso = leerFloatEnRango("Peso en kg (40.0-150.0, ej: 75.5): ", 40.0f, 150.0f);

        // Validación: altura en metros (rango razonable)
        float altura = leerFloatEnRango("Altura en metros (1.50-2.20, ej: 1.82): ", 1.50f, 2.20f);

        Jugador nuevo = new Jugador(nombre, fec, dorsal, pos, peso, altura);

        System.out.println("\nSelección destino:");
        List<Seleccion> lista = servicio.getSelecciones();
        if (lista.isEmpty()) {
            System.out.println(" No hay selecciones registradas.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).getNombreFederacion());
        }
        int idxSel = leerEnteroEnRango("Opción (1-" + lista.size() + "): ", 1, lista.size()) - 1;
        try {
            servicio.agregarJugadorASeleccion(nuevo, lista.get(idxSel));
            System.out.println(" Jugador " + nombre + " agregado a " + lista.get(idxSel).getNombreFederacion());
        } catch (JugadorYaVinculadoException e) {
            System.out.println(" " + e.getMessage());
        }
    }

    private static void registrarEventoInteractivo() {
        System.out.println("\n--- REGISTRAR EVENTO ---");
        List<Partido> partidos = servicio.getPartidos();
        if (partidos.isEmpty()) {
            System.out.println(" No hay partidos registrados.");
            return;
        }
        for (int i = 0; i < partidos.size(); i++) {
            Partido p = partidos.get(i);
            System.out.println((i + 1) + ". " + p.getSeleccionLocal().getNombreFederacion()
                + " vs " + p.getSeleccionVisitante().getNombreFederacion());
        }
        // Validación: opción de partido dentro del rango
        int idxP = leerEnteroEnRango("Elegí partido (1-" + partidos.size() + "): ", 1, partidos.size()) - 1;
        Partido partSeleccionado = partidos.get(idxP);

        // Listar jugadores del partido
        System.out.println("Jugadores disponibles:");
        List<Jugador> jugadoresPartido = new ArrayList<>();
        jugadoresPartido.addAll(partSeleccionado.getSeleccionLocal().getJugadores());
        jugadoresPartido.addAll(partSeleccionado.getSeleccionVisitante().getJugadores());
        if (jugadoresPartido.isEmpty()) {
            System.out.println(" No hay jugadores en este partido.");
            return;
        }
        for (int i = 0; i < jugadoresPartido.size(); i++) {
            System.out.println((i + 1) + ". " + jugadoresPartido.get(i).getNombre());
        }
        // Validación: opción de jugador dentro del rango
        int idxJ = leerEnteroEnRango("Elegí jugador (1-" + jugadoresPartido.size() + "): ", 1, jugadoresPartido.size()) - 1;
        Jugador jugSeleccionado = jugadoresPartido.get(idxJ);

        System.out.println("Tipo de evento:");
        TipoEvento[] tipos = TipoEvento.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ". " + tipos[i]);
        }
        // Validación: opción de tipo dentro del rango
        int idxT = leerEnteroEnRango("Opción (1-" + tipos.length + "): ", 1, tipos.length) - 1;

        // Validación: minuto entre 1 y 120 (incluye tiempo adicional)
        int minuto = leerEnteroEnRango("Minuto del evento (1-120): ", 1, 120);

        Evento ev = new Evento(tipos[idxT], minuto, jugSeleccionado);
        try {
            partSeleccionado.agregarEvento(ev);
            System.out.println(" Evento registrado: " + tipos[idxT] + " de " + jugSeleccionado.getNombre() + " (min. " + minuto + ")");
        } catch (EventoJugadorNoParticipaException e) {
            System.out.println(" " + e.getMessage());
        }
    }

    private static void agregarSeleccionInteractivo() {
        System.out.println("\n--- AGREGAR SELECCIÓN ---");

        List<Pais> paises = servicio.getPaises();
        if (paises.isEmpty()) {
            System.out.println("No hay países registrados. Agregá un país primero.");
            return;
        }

        System.out.println("Elegí el país:");
        for (int i = 0; i < paises.size(); i++) {
            Pais p = paises.get(i);
            String estado = (p.getSeleccion() != null) ? " (ya tiene selección: " + p.getSeleccion().getNombreFederacion() + ")" : "";
            System.out.println((i + 1) + ". " + p.getNombre() + estado);
        }
        // Validación: opción de país dentro del rango
        int idxPais = leerEnteroEnRango("Opción (1-" + paises.size() + "): ", 1, paises.size()) - 1;
        Pais paisElegido = paises.get(idxPais);

        // Validación: nombre federación (solo letras)
        String nombreFed = leerNombre("Nombre de la federación: ");

        // Validación: colores no vacíos
        String camisetaPrincipal  = leerStringNoVacio("Camiseta principal (color): ");
        String camisetaSecundaria = leerStringNoVacio("Camiseta secundaria (color): ");

        boolean cabezaGrupo = leerSiNo("¿Es cabeza de grupo?");

        // Validación: ranking FIFA entre 1 y 211
        int ranking = leerEnteroEnRango("Ranking FIFA (1-211): ", 1, 211);

        List<Grupo> grupos = servicio.getGrupos();
        Grupo grupoElegido = null;
        if (!grupos.isEmpty()) {
            System.out.println("Elegí el grupo (0 para ninguno):");
            for (int i = 0; i < grupos.size(); i++) {
                System.out.println((i + 1) + ". " + grupos.get(i).getIdentificacion());
            }
            System.out.print("Opción: ");
            String entradaGrupo = scanner.nextLine().trim();
            if (!entradaGrupo.isEmpty() && !entradaGrupo.equals("0")) {
                try {
                    int idxGrupo = Integer.parseInt(entradaGrupo) - 1;
                    if (idxGrupo >= 0 && idxGrupo < grupos.size()) {
                        grupoElegido = grupos.get(idxGrupo);
                    } else {
                        System.out.println(" Número fuera de rango. Se creará sin grupo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(" Entrada inválida. Se creará sin grupo.");
                }
            }
        }

        Seleccion nueva = new Seleccion(nombreFed, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, ranking, paisElegido, grupoElegido);
        servicio.agregarSeleccion(nueva);
        if (grupoElegido != null) {
            grupoElegido.agregarSeleccion(nueva);
        }
        System.out.println(" Selección '" + nombreFed + "' agregada y vinculada a " + paisElegido.getNombre() + ".");
    }

    private static void agregarGrupoInteractivo() {
        System.out.println("\n--- AGREGAR GRUPO ---");

        // Validación: identificación no vacía (ej. "A", "B", "Grupo C")
        String identificacion = leerStringNoVacio("Identificación del grupo (ej. A): ");

        // Validación: descripción no vacía
        String descripcion = leerStringNoVacio("Descripción: ");

        List<Fase> fases = servicio.getFases();
        Fase faseElegida = null;
        if (!fases.isEmpty()) {
            System.out.println("Elegí la fase (0 para ninguna):");
            for (int i = 0; i < fases.size(); i++) {
                System.out.println((i + 1) + ". " + fases.get(i).getNombre());
            }
            System.out.print("Opción: ");
            String entradaFase = scanner.nextLine().trim();
            if (!entradaFase.isEmpty() && !entradaFase.equals("0")) {
                try {
                    int idxFase = Integer.parseInt(entradaFase) - 1;
                    if (idxFase >= 0 && idxFase < fases.size()) {
                        faseElegida = fases.get(idxFase);
                    } else {
                        System.out.println(" Número fuera de rango. Se creará el grupo sin fase.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(" Entrada inválida. Se creará el grupo sin fase.");
                }
            }
        } else {
            System.out.println("No hay fases registradas. El grupo se creará sin fase.");
        }

        Grupo nuevoGrupo = new Grupo(identificacion, descripcion, faseElegida);
        servicio.agregarGrupo(nuevoGrupo);
        System.out.println(" Grupo '" + identificacion + "' agregado correctamente.");
    }
    private static void crearMundialInteractivo() {
        System.out.println("\n--- CREAR NUEVO MUNDIAL ---");
        System.out.println("Atención: esto reemplaza el mundial actual y borra todos los datos.");

        if (!leerSiNo("¿Estás seguro?")) {
            System.out.println(" Operación cancelada.");
            return;
        }

        int anio = leerEnteroEnRango("Año del mundial (2026-2050): ", 2026, 2050);

        String mascota = leerStringNoVacio("Nombre de la mascota: ");

        System.out.println("Fecha de inicio (formato AAAAMMDD, ej: 20260611):");
        int fechaInicio = leerEnteroEnRango("Fecha inicio: ", 20000101, 20991231);

        System.out.println("Fecha de fin (formato AAAAMMDD, ej: 20260719):");
        int fechaFin = leerEnteroEnRango("Fecha fin: ", fechaInicio, 20991231);

        Mundial nuevoMundial = new Mundial(anio, mascota, fechaInicio, fechaFin);
        servicio = new ServicioMundial(nuevoMundial);

        System.out.println(" Mundial " + anio + " creado correctamente con mascota '" + mascota + "'.");
    }

    private static void agregarSedeInteractivo() {
        System.out.println("\n--- AGREGAR SEDE ---");

        if (servicio.getMundial() == null) {
            System.out.println(" Primero creá un mundial (opción 14).");
            return;
        }

        List<Pais> paises = servicio.getPaises();
        if (paises.isEmpty()) {
            System.out.println(" No hay países registrados. Agregá un país primero (opción 11).");
            return;
        }

        String ciudad = leerNombre("Ciudad de la sede: ");
        float altura = leerFloatEnRango("Altura sobre el nivel del mar en metros (0-5000): ", 0, 5000);
        String clima = leerStringNoVacio("Clima (ej: Templado, Tropical, Árido): ");
        String zonaHoraria = leerStringNoVacio("Zona horaria (ej: UTC-3, CET): ");

        System.out.println("\nElegí el país de la sede:");
        for (int i = 0; i < paises.size(); i++) {
            System.out.println((i + 1) + ". " + paises.get(i).getNombre());
        }
        int idxPais = leerEnteroEnRango("Opción (1-" + paises.size() + "): ", 1, paises.size()) - 1;
        Pais paisElegido = paises.get(idxPais);

        Sede nuevaSede = new Sede(ciudad, altura, clima, zonaHoraria, paisElegido);
        servicio.agregarSede(nuevaSede);

        System.out.println(" Sede '" + ciudad + "' agregada correctamente.");
    }

    private static void agregarEstadioInteractivo() {
        System.out.println("\n--- AGREGAR ESTADIO ---");

        List<Sede> sedes = servicio.getSedes();
        if (sedes.isEmpty()) {
            System.out.println(" No hay sedes registradas. Agregá una sede primero (opción 15).");
            return;
        }

        String nombre = leerStringNoVacio("Nombre del estadio: ");
        int capacidad = leerEnteroEnRango("Capacidad (1000-200000): ", 1000, 200000);

        System.out.println("\nElegí la sede del estadio:");
        for (int i = 0; i < sedes.size(); i++) {
            System.out.println((i + 1) + ". " + sedes.get(i).getCiudad());
        }
        int idxSede = leerEnteroEnRango("Opción (1-" + sedes.size() + "): ", 1, sedes.size()) - 1;
        Sede sedeElegida = sedes.get(idxSede);

        // El constructor de Estadio lo vincula automáticamente a la sede
        new Estadio(nombre, capacidad, sedeElegida);

        System.out.println(" Estadio '" + nombre + "' agregado en " + sedeElegida.getCiudad() + ".");
    }

    private static void agregarArbitroInteractivo() {
        System.out.println("\n--- AGREGAR ÁRBITRO ---");

        List<Pais> paises = servicio.getPaises();
        if (paises.isEmpty()) {
            System.out.println(" No hay países registrados. Agregá un país primero (opción 11).");
            return;
        }

        String nombre = leerNombre("Nombre del árbitro: ");
        int anioNacimiento = leerEnteroEnRango("Año de nacimiento (1950-2000): ", 1950, 2000);
        int experiencia = leerEnteroEnRango("Años de experiencia (0-40): ", 0, 40);

        System.out.println("\nElegí el país del árbitro:");
        for (int i = 0; i < paises.size(); i++) {
            System.out.println((i + 1) + ". " + paises.get(i).getNombre());
        }
        int idxPais = leerEnteroEnRango("Opción (1-" + paises.size() + "): ", 1, paises.size()) - 1;
        Pais paisElegido = paises.get(idxPais);

        // El constructor de Arbitro lo vincula automáticamente al país
        new Arbitro(nombre, anioNacimiento, experiencia, paisElegido);

        System.out.println(" Árbitro '" + nombre + "' agregado correctamente.");
    }

    private static void registrarPartidoInteractivo() {
        System.out.println("\n--- REGISTRAR PARTIDO ---");

        List<Seleccion> selecciones = servicio.getSelecciones();
        if (selecciones.size() < 2) {
            System.out.println(" Se necesitan al menos 2 selecciones registradas.");
            return;
        }

        List<Estadio> estadios = servicio.getEstadios();
        if (estadios.isEmpty()) {
            System.out.println(" No hay estadios registrados. Agregá un estadio primero (opción 16).");
            return;
        }

        List<Arbitro> arbitros = servicio.getArbitros();
        if (arbitros.size() < 6) {
            System.out.println(" Se necesitan al menos 6 árbitros registrados (uno por categoría).");
            System.out.println(" Árbitros actuales: " + arbitros.size() + ". Agregá más con la opción 17.");
            return;
        }

        // Fecha con formato DD/MM/AAAA
        String fecha;
        do {
            fecha = leerStringNoVacio("Fecha del partido (formato DD/MM/AAAA, ej: 15/06/2026): ");
            if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println(" Formato inválido. Usá DD/MM/AAAA (ej: 15/06/2026).");
                fecha = "";
            }
        } while (fecha.isEmpty());

        // Hora con formato HH:MM
        String hora;
        do {
            hora = leerStringNoVacio("Hora del partido (formato HH:MM, ej: 20:00): ");
            if (!hora.matches("\\d{2}:\\d{2}")) {
                System.out.println(" Formato inválido. Usá HH:MM (ej: 20:00).");
                hora = "";
            }
        } while (hora.isEmpty());

        // Fase
        NombreFase[] fases = NombreFase.values();
        System.out.println("\nFase del partido:");
        for (int i = 0; i < fases.length; i++) {
            System.out.println((i + 1) + ". " + fases[i]);
        }
        int idxFase = leerEnteroEnRango("Opción (1-" + fases.length + "): ", 1, fases.length) - 1;
        NombreFase faseElegida = fases[idxFase];

        // Estadio
        System.out.println("\nElegí el estadio:");
        for (int i = 0; i < estadios.size(); i++) {
            System.out.println((i + 1) + ". " + estadios.get(i).getNombre()
                + " (" + estadios.get(i).getSede().getCiudad() + ")");
        }
        int idxEstadio = leerEnteroEnRango("Opción (1-" + estadios.size() + "): ", 1, estadios.size()) - 1;
        Estadio estadioElegido = estadios.get(idxEstadio);

        // Selección local
        System.out.println("\nSelección LOCAL:");
        for (int i = 0; i < selecciones.size(); i++) {
            System.out.println((i + 1) + ". " + selecciones.get(i).getNombreFederacion());
        }
        int idxLocal = leerEnteroEnRango("Opción (1-" + selecciones.size() + "): ", 1, selecciones.size()) - 1;
        Seleccion local = selecciones.get(idxLocal);

        // Selección visitante (no puede ser la misma que la local)
        System.out.println("\nSelección VISITANTE:");
        for (int i = 0; i < selecciones.size(); i++) {
            if (i != idxLocal) {
                System.out.println((i + 1) + ". " + selecciones.get(i).getNombreFederacion());
            }
        }
        int idxVisitante;
        do {
            idxVisitante = leerEnteroEnRango("Opción (1-" + selecciones.size() + "): ", 1, selecciones.size()) - 1;
            if (idxVisitante == idxLocal) {
                System.out.println(" La selección visitante no puede ser la misma que la local.");
            }
        } while (idxVisitante == idxLocal);
        Seleccion visitante = selecciones.get(idxVisitante);

        // Crear el partido
        Partido nuevoPartido = new Partido(fecha, hora, 90, 5, faseElegida, estadioElegido);
        nuevoPartido.setSeleccionLocal(local);
        nuevoPartido.setSeleccionVisitante(visitante);

        // Asignar árbitros — uno por categoría
        System.out.println("\n--- ASIGNACIÓN DE ÁRBITROS ---");
        System.out.println("Hay " + arbitros.size() + " árbitros disponibles.");
        CategoriaArbitro[] categorias = CategoriaArbitro.values();
        for (CategoriaArbitro categoria : categorias) {
            System.out.println("\nÁrbitro para " + categoria + ":");
            for (int i = 0; i < arbitros.size(); i++) {
                System.out.println((i + 1) + ". " + arbitros.get(i).getNombre());
            }
            int idxArb = leerEnteroEnRango("Opción (1-" + arbitros.size() + "): ", 1, arbitros.size()) - 1;
            try {
                nuevoPartido.agregarArbitraje(new Arbitraje(arbitros.get(idxArb), categoria));
            } catch (ArbitrajeInvalidoException e) {
                System.out.println(" Error al asignar árbitro: " + e.getMessage());
                return;
            }
        }

        // Resultado
        System.out.println("\n--- RESULTADO ---");
        int golesLocal     = leerEnteroEnRango("Goles del local (0-20): ", 0, 20);
        int golesVisitante = leerEnteroEnRango("Goles del visitante (0-20): ", 0, 20);
        nuevoPartido.registrarResultado(golesLocal, golesVisitante);

        // Participaciones
        Participacion partLocal     = new Participacion(true,  local,     nuevoPartido);
        Participacion partVisitante = new Participacion(false, visitante, nuevoPartido);
        local.agregarParticipacion(partLocal);
        visitante.agregarParticipacion(partVisitante);
        nuevoPartido.agregarParticipaciones(partLocal);
        nuevoPartido.agregarParticipaciones(partVisitante);
        estadioElegido.agregarPartido(nuevoPartido);

        // Vincular a fase y grupo si corresponde
        for (Fase f : servicio.getFases()) {
            if (f.getNombre() == faseElegida) {
                f.agregarPartido(nuevoPartido);
                break;
            }
        }

        try {
            servicio.registrarPartido(nuevoPartido);
            System.out.println("\n Partido registrado: "
                + local.getNombreFederacion() + " " + golesLocal
                + " - " + golesVisitante + " "
                + visitante.getNombreFederacion());
        } catch (ArbitrajeInvalidoException e) {
            System.out.println(" Error al registrar el partido: " + e.getMessage());
        }
    }
        // ==========================================================
    // MÉTODOS DE VALIDACIÓN
    // ==========================================================

    private static String leerStringNoVacio(String prompt) {
        String valor;
        do {
            System.out.print(prompt);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println(" El campo no puede estar vacío. Ingresá un valor.");
            }
        } while (valor.isEmpty());
        return valor;
    }

    private static String leerNombre(String prompt) {
        String valor;
        do {
            System.out.print(prompt);
            valor = scanner.nextLine().trim();
            if (valor.isEmpty()) {
                System.out.println(" El nombre no puede estar vacío.");
            } else if (!valor.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s\\-\\.]+")) {
                System.out.println(" El nombre solo puede contener letras, espacios, tildes y guiones.");
                valor = "";
            }
        } while (valor.isEmpty());
        return valor;
    }

    private static int leerEnteroEnRango(String prompt, int min, int max) {
        int valor;
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(entrada);
                if (valor < min || valor > max) {
                    System.out.println(" Valor fuera de rango. Ingresá un número entre " + min + " y " + max + ".");
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Ingresá un número entero.");
            }
        }
    }

    private static float leerFloatEnRango(String prompt, float min, float max) {
        float valor;
        while (true) {
            System.out.print(prompt);
            String entrada = scanner.nextLine().trim().replace(",", ".");
            try {
                valor = Float.parseFloat(entrada);
                if (valor < min || valor > max) {
                    System.out.printf(" Valor fuera de rango. Ingresá un número entre %.2f y %.2f.%n", min, max);
                } else {
                    return valor;
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Ingresá un número decimal (ej: 75.5).");
            }
        }
    }

    private static boolean leerSiNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (s/n): ");
            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.equals("s")) return true;
            if (entrada.equals("n")) return false;
            System.out.println(" Ingresá 's' para sí o 'n' para no.");
        }
    }
}