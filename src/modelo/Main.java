public class Main {

    public static void main(String[] args) {

        // =========================
        // PAIS
        // =========================

        Pais argentinaPais = new Pais("Argentina", "America");

        // =========================
        // JUGADORES
        // =========================

        Jugador j1 = new Jugador(
                "Lionel Messi",
                1987,
                10,
                Posicion.DELANTERO,
                72,
                1.70f
        );

        Jugador j2 = new Jugador(
                "Julian Alvarez",
                2000,
                9,
                Posicion.DELANTERO,
                75,
                1.80f
        );

        Jugador[] jugadoresArgentina = {j1, j2};

        // =========================
        // DIRECTOR TECNICO
        // =========================

        DirectorTecnico dtArgentina = new DirectorTecnico(
                "Lionel Scaloni",
                1978,
                2018
        );

        // =========================
        // CUERPO TECNICO
        // =========================

        CuerpoTecnico ct1 = new CuerpoTecnico(
                "Pablo Aimar",
                1979,
                Rol.AYUDANTE_CAMPO
        );

        CuerpoTecnico[] cuerpoTecnicoArgentina = {ct1};

        // =========================
        // SELECCION
        // =========================

        Seleccion argentina = new Seleccion(
                "AFA",
                "Celeste y Blanca",
                "Morada",
                true,
                1,
                argentinaPais,
                dtArgentina,
                jugadoresArgentina,
                cuerpoTecnicoArgentina
        );

        // =========================
        // GRUPO
        // =========================

        Seleccion[] grupoASelecciones = {argentina};

        Grupo grupoA = new Grupo(
                "A",
                grupoASelecciones
        );

        // =========================
        // SEDE
        // =========================

        Sede sede = new Sede(
                "Buenos Aires",
                argentinaPais
        );

        // =========================
        // ESTADIO
        // =========================

        Estadio monumental = new Estadio(
                "Monumental",
                85000,
                sede
        );

        // =========================
        // ARBITRO
        // =========================

        Arbitro arbitro = new Arbitro(
                "Pierluigi Collina",
                1960,
                20
        );

        // =========================
        // ARBITRAJE
        // =========================

        Arbitraje arbitraje1 = new Arbitraje(
                arbitro,
                CategoriaArbitro.PRINCIPAL
        );

        Arbitraje[] arbitrajes = {arbitraje1};

        // =========================
        // EVENTOS
        // =========================

        Evento[] eventos = new Evento[0];

        // =========================
        // PARTIDO
        // =========================

        Partido partido = new Partido(
                "10/06/2026",
                "18:00",
                NombreFase.GRUPOS,
                monumental,
                argentina,
                argentina,
                arbitrajes,
                eventos
        );

        // =========================
        // PARTICIPACION
        // =========================

        Participacion participacion = new Participacion(
                3,
                1,
                0,
                0,
                argentina,
                grupoA
        );

        Participacion[] participaciones = {participacion};

        // =========================
        // MUNDIAL
        // =========================

        Grupo[] grupos = {grupoA};

        Partido[] partidos = {partido};

        Sede[] sedes = {sede};

        Mundial mundial = new Mundial(
                "Mundial 2026",
                2026,
                grupos,
                partidos,
                sedes,
                participaciones
        );

        // =========================
        // MOSTRAR
        // =========================

        System.out.println(mundial);
    }
}