public class Main {
    public static void main(String[] args) {
        
        // 1. INSTANCIA MUNDIAL
        Mundial mundial = new Mundial(2026, "La'eeb", 20260610, 20260710);

        // 2. FASES Y GRUPOS
        Fase faseGrupos = new Fase(NombreFase.GRUPOS);
        Grupo grupoA = new Grupo("A", "Grupo A del Mundial 2026", faseGrupos);
        faseGrupos.agregarGrupo(grupoA);

        // 3. PAÍSES 
        Pais paisArg = new Pais("Argentina", "Bandera Argentina", null);
        Pais paisBra = new Pais("Brasil", "Bandera Brasil", null);

        // 4. SELECCIONES Y VINCULARLAS A SUS PAÍSES
        Seleccion arg = new Seleccion("AFA", "Celeste y Blanca", "Morada", true, 1, paisArg, grupoA);
        paisArg.setSeleccion(arg); // Vinculación bidireccional

        Seleccion bra = new Seleccion("CBF", "Amarilla", "Azul", false, 2, paisBra, grupoA);
        paisBra.setSeleccion(bra); // Vinculación bidireccional

        // Agregamos las selecciones al grupo
        grupoA.agregarSeleccion(arg);
        grupoA.agregarSeleccion(bra);

        // 5. PERSONAL Y CUERPO TÉCNICO
        DirectorTecnico dtArg = new DirectorTecnico("Lionel Scaloni", 19780516, 2018);
        arg.agregarDirectorTecnico(dtArg);
        
        DirectorTecnico dtBra = new DirectorTecnico("Dorival Junior", 19620425, 2024);
        bra.agregarDirectorTecnico(dtBra);

        CuerpoTecnico ctArg = new CuerpoTecnico("Pablo Aimar", 19791103, Rol.AYUDANTE_CAMPO);
        arg.agregarCuerpoTecnico(ctArg);

        // 6. JUGADORES Y ASIGNARLOS
        Jugador messi = new Jugador("Lionel Messi", 19870624, 10, Posicion.DELANTERO, 72.0f, 1.70f);
        Jugador alvarez = new Jugador("Julian Alvarez", 20000131, 9, Posicion.DELANTERO, 71.0f, 1.70f);
        arg.agregarJugador(messi);
        arg.agregarJugador(alvarez);

        Jugador vini = new Jugador("Vinicius Junior", 20000712, 7, Posicion.DELANTERO, 73.0f, 1.76f);
        Jugador neymar = new Jugador("Neymar Junior", 19920205, 10, Posicion.DELANTERO, 68.0f, 1.75f);
        bra.agregarJugador(vini);
        bra.agregarJugador(neymar);

        // 7. SEDES Y ESTADIOS
        Sede sedeBA = new Sede("Buenos Aires", 25.0f, "Templado", "GMT-3", paisArg);
        Estadio monumental = new Estadio("Monumental", 85000, sedeBA);
        mundial.agregarSede(sedeBA);

        // 8. ÁRBITROS
        Arbitro collina = new Arbitro("Pierluigi Collina", 19600213, 20, paisArg);
        Arbitro diaz = new Arbitro("Roberto Diaz", 19800101, 10, paisArg);
        Arbitro lopez = new Arbitro("Carlos Lopez", 19820101, 8, paisArg);

        // 9. ORGANIZAR EL PARTIDO
        Partido partido = new Partido("10/06/2026", "18:00", 90, 5, NombreFase.GRUPOS, monumental);
        partido.setSeleccionLocal(arg);
        partido.setSeleccionVisitante(bra);

        // Registrar las participaciones de las selecciones en el partido
        Participacion partArg = new Participacion(true, arg, partido);
        Participacion partBra = new Participacion(false, bra, partido);
        arg.agregarParticipacion(partArg);
        bra.agregarParticipacion(partBra);

        // Asignar el arbitraje al partido
        partido.agregarArbitraje(new Arbitraje(collina, CategoriaArbitro.PRINCIPAL));
        partido.agregarArbitraje(new Arbitraje(diaz, CategoriaArbitro.ASISTENTE1));
        partido.agregarArbitraje(new Arbitraje(lopez, CategoriaArbitro.ASISTENTE2));

        // 10. EVENTOS Y RESULTADO
        Evento golMessi = new Evento(TipoEvento.GOL, 15, messi);
        Evento amarillaVini = new Evento(TipoEvento.TARJETA_AMARILLA, 30, vini);
        partido.agregarEvento(golMessi);
        partido.agregarEvento(amarillaVini);

        partido.registrarResultado(1, 0); 

        // 11. IMPRESIÓN DE RESULTADOS POR CONSOLA
        System.out.println("===============================================");
        System.out.println(mundial.toString());
        System.out.println("===============================================");
        System.out.println(grupoA.toString());
        System.out.println("===============================================");
        System.out.println(partido.toString());
    }
}