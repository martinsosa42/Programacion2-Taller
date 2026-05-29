public class Main {

    public static void main(String[] args) {

        // =========================
        // PAISES
        // =========================

        Pais argentina = new Pais(
                "Argentina",
                "America");

        Pais brasil = new Pais(
                "Brasil",
                "America");

        // =========================
        // SEDES
        // =========================

        Sede buenosAires = new Sede(
                "Buenos Aires",
                argentina);

        // =========================
        // ESTADIOS
        // =========================

        Estadio monumental = new Estadio(
                "Monumental",
                85000,
                buenosAires);

        // =========================
        // DIRECTORES TECNICOS
        // =========================

        DirectorTecnico scaloni =
                new DirectorTecnico(
                        "Lionel Scaloni",
                        1978,
                        2018);

        DirectorTecnico ancelotti =
                new DirectorTecnico(
                        "Carlo Ancelotti",
                        1959,
                        2024);

        // =========================
        // SELECCIONES
        // =========================

        Seleccion seleccionArgentina =
                new Seleccion(
                        "AFA",
                        "Celeste y Blanca",
                        "Morada",
                        true,
                        1,
                        argentina,
                        scaloni);

        Seleccion seleccionBrasil =
                new Seleccion(
                        "CBF",
                        "Amarilla",
                        "Azul",
                        true,
                        3,
                        brasil,
                        ancelotti);

        // =========================
        // JUGADORES ARGENTINA
        // =========================

        Jugador messi = new Jugador(
                "Lionel Messi",
                1987,
                10,
                Posicion.DELANTERO,
                72,
                1.70);

        Jugador dibu = new Jugador(
                "Emiliano Martinez",
                1992,
                23,
                Posicion.ARQUERO,
                88,
                1.95);

        seleccionArgentina.agregarJugador(messi);

        seleccionArgentina.agregarJugador(dibu);

        // =========================
        // JUGADORES BRASIL
        // =========================

        Jugador vinicius = new Jugador(
                "Vinicius Jr",
                2000,
                7,
                Posicion.DELANTERO,
                73,
                1.76);

        Jugador alisson = new Jugador(
                "Alisson Becker",
                1992,
                1,
                Posicion.ARQUERO,
                91,
                1.93);

        seleccionBrasil.agregarJugador(vinicius);

        seleccionBrasil.agregarJugador(alisson);

        // =========================
        // GRUPO
        // =========================

        Grupo grupoA = new Grupo("Grupo A");

        grupoA.agregarSeleccion(
                seleccionArgentina);

        grupoA.agregarSeleccion(
                seleccionBrasil);

        // =========================
        // PARTICIPACIONES
        // =========================

        Participacion participacionArgentina =
                new Participacion(
                        seleccionArgentina,
                        grupoA);

        Participacion participacionBrasil =
                new Participacion(
                        seleccionBrasil,
                        grupoA);

        // =========================
        // PARTIDO
        // =========================

        Partido partido = new Partido(
                "15/06/2026",
                "21:00",
                NombreFase.GRUPOS,
                monumental,
                seleccionArgentina,
                seleccionBrasil);

        // =========================
        // EVENTOS
        // =========================

        Evento golMessi = new Evento(
                15,
                TipoEvento.GOL,
                messi);

        Evento amarillaVinicius =
                new Evento(
                        40,
                        TipoEvento.TARJETA_AMARILLA,
                        vinicius);

        Evento golMessi2 = new Evento(
                70,
                TipoEvento.GOL,
                messi);

        partido.agregarEvento(golMessi);

        partido.agregarEvento(
                amarillaVinicius);

        partido.agregarEvento(golMessi2);

        // =========================
        // RESULTADO
        // =========================

        partido.registrarResultado(2, 0);

        participacionArgentina
                .registrarVictoria(2, 0);

        participacionBrasil
                .registrarDerrota(0, 2);

        participacionArgentina
                .setFaseAlcanzada(
                        NombreFase.SEMIFINAL);

        // =========================
        // MOSTRAR PARTIDO
        // =========================

        System.out.println(partido);

        // =========================
        // TABLA DE RESULTADOS
        // =========================

        System.out.println(
                "\n===== RESULTADOS =====");

        participacionArgentina
                .mostrarResultados();

        System.out.println();

        participacionBrasil
                .mostrarResultados();

        // =========================
        // RANKING GOLEADORES
        // =========================

        System.out.println(
                "\n===== GOLEADORES =====");

        System.out.println(
                messi.getNombre()
                + " - "
                + messi.getGoles()
                + " goles");

        System.out.println(
                vinicius.getNombre()
                + " - "
                + vinicius.getGoles()
                + " goles");

        // =========================
        // INFORME DISCIPLINARIO
        // =========================

        System.out.println(
                "\n===== TARJETAS =====");

        partido.mostrarTarjetas();

        // =========================
        // ESTADISTICAS ESTADIO
        // =========================

        System.out.println(
                "\n===== ESTADIO =====");

        System.out.println(
                "Estadio: "
                + monumental.getNombre());

        System.out.println(
                "Ciudad: "
                + monumental
                    .getSede()
                    .getCiudad());

        System.out.println(
                "Capacidad: "
                + monumental
                    .getCapacidad());
    }
}