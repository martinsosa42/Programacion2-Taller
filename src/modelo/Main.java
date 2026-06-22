
import java.util.Scanner;

public class Main {
    // --- ESTAS LÍNEAS TIENEN QUE ESTAR ACÁ ARRIBA ---
    private static Jugador nuevoJugador = null;
    private static Partido partido = null;
    private static ServicioMundial servicio = new ServicioMundial();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Cargamos datos ficticios para que puedas probar el menú de una
        cargarDatosDePrueba();
        
        int opcion = -1;
        do {
            System.out.println("\n===========================================");
            System.out.println("     SISTEMA DE GESTIÓN - MUNDIAL 2026");
            System.out.println("===========================================");
            System.out.println("1. Cargar datos manualmente");
            System.out.println("2. Registrar partido / eventos");
            System.out.println("3. Ver informes");
            System.out.println("0. Salir");
            System.out.println("===========================================");
            System.out.print("Opción: ");

            try {
                String entrada = scanner.nextLine();
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- CARGAR NUEVO JUGADOR ---");
                        
                        System.out.print("Nombre del jugador: ");
                        String nombre = scanner.nextLine();
                        
                        System.out.print("Año de nacimiento (ej. 1998): ");
                        int fecNacimiento = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Número de camiseta (Dorsal): ");
                        int dorsal = Integer.parseInt(scanner.nextLine());
                        
                        // --- MENÚ DE SELECCIÓN DE TU ENUM POSICION ---
                        System.out.println("Seleccione la posición del jugador:");
                        System.out.println("1. ARQUERO");
                        System.out.println("2. DEFENSOR");
                        System.out.println("3. MEDIOCAMPISTA");
                        System.out.println("4. DELANTERO");
                        System.out.print("Opción de posición (1-4): ");
                        int opcPos = Integer.parseInt(scanner.nextLine());
                        
                        Posicion posicion = null;
                        switch(opcPos) {
                            case 1: posicion = Posicion.ARQUERO; break;
                            case 2: posicion = Posicion.DEFENSOR; break;
                            case 3: posicion = Posicion.MEDIOCAMPISTA; break;
                            case 4: posicion = Posicion.DELANTERO; break;
                            default: 
                                System.out.println("[Aviso] Opción inválida, se asignará ARQUERO por defecto.");
                                posicion = Posicion.ARQUERO;
                        }
                        // ---------------------------------------------

                        System.out.print("Peso (ej. 75.5): ");
                        float peso = Float.parseFloat(scanner.nextLine());
                        
                        System.out.print("Altura (ej. 1.82): ");
                        float altura = Float.parseFloat(scanner.nextLine());

                        // CREAMOS EL JUGADOR CON TU CONSTRUCTOR PARAMETRIZADO
                         nuevoJugador = new Jugador(nombre, fecNacimiento, dorsal, posicion, peso, altura);

                        System.out.println("\n✅ ¡Jugador creado con éxito!");
                        System.out.println("Datos registrados: " + nuevoJugador.toString());
                        break;
                    case 2:
                        System.out.println("\n--- REGISTRAR PARTIDO Y EVENTOS ---");
                        
                        System.out.print("Ingrese la fecha del partido (ej. 14/06/2026): ");
                        String fecha = scanner.nextLine();
                        
                        System.out.print("Ingrese la hora (ej. 16:00): ");
                        String hora = scanner.nextLine();
                        
                        System.out.print("Duración en minutos (ej. 90): ");
                        int duracion = Integer.parseInt(scanner.nextLine());
                        
                        System.out.print("Tiempo adicional (ej. 5): ");
                        int tiempoAdicional = Integer.parseInt(scanner.nextLine());
                        
                        NombreFase fase = null; 
                        Estadio estadio = new Estadio(); 
                        
                        // USAMOS LA VARIABLE GLOBAL SIN "Partido" ADELANTE
                        partido = new Partido(fecha, hora, duracion, tiempoAdicional, fase, estadio);
                        
                        Seleccion local = new Seleccion();
                        local.setNombreFederacion("Argentina");
                        Seleccion visitante = new Seleccion();
                        visitante.setNombreFederacion("Francia");
                        
                        partido.setSeleccionLocal(local);
                        partido.setSeleccionVisitante(visitante);

                        System.out.println("\n--- REGISTRAR RESULTADO ---");
                        System.out.print("Goles de " + local.getNombreFederacion() + ": ");
                        int gL = Integer.parseInt(scanner.nextLine());
                        System.out.print("Goles de " + visitante.getNombreFederacion() + ": ");
                        int gV = Integer.parseInt(scanner.nextLine());
                        
                        partido.registrarResultado(gL, gV);

                        System.out.println("\n--- REGISTRAR EVENTO EN EL PARTIDO ---");
                        System.out.print("Minuto del evento: ");
                        int minuto = Integer.parseInt(scanner.nextLine());
                        
                        if (nuevoJugador != null) {
                            local.agregarJugador(nuevoJugador); 
                            TipoEvento tipoE = TipoEvento.GOL; 
                            Evento nuevoEvento = new Evento(tipoE, minuto, nuevoJugador);
                            
                            try {
                                partido.agregarEvento(nuevoEvento);
                                System.out.println("✅ Evento (GOL) asignado con éxito al jugador: " + nuevoJugador.getNombre());
                            } catch (EventoJugadorNoParticipaException e) {
                                System.out.println("❌ Error: " + e.getMessage());
                            }
                        } else {
                            System.out.println("[Aviso] No hay un jugador creado previamente en la Opción 1 para simular el evento.");
                        }
                        break; // <-- Importante: acá solo frena, NO imprime nada en pantalla.
                    case 3:
                        mostrarInformes(); // Llama al método de abajo
                        break;
                    case 0:
                        System.out.println("\n¡Gracias por usar el sistema! Saliendo...");
                        break;
                    default:
                        System.out.println("\n❌ Opción inválida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Error: Por favor, ingrese un número válido.");
                opcion = -1;
            }
        } while (opcion != 0);
    }

    private static void cargarDatosDePrueba() {
        System.out.println("Datos de prueba cargados automáticamente.");
        // Acá tu ServicioMundial o clase Mundial debería inicializar 
        // algunos países, selecciones y jugadores de prueba.
    }

   private static void mostrarInformes() {
        System.out.println("\n===========================================");
        System.out.println("            INFORMES DEL MUNDIAL");
        System.out.println("===========================================");

        // 1. INFORME DE JUGADORES
        System.out.println("📋 [Informe] Último Jugador Registrado:");
        if (nuevoJugador != null) {
            System.out.println(nuevoJugador.toString());
            System.out.println("⚽ Goles totales calculados en el torneo: " + nuevoJugador.calcularGoles());
        } else {
            System.out.println("❌ No hay ningún jugador cargado en el sistema todavía (Usá la Opción 1).");
        } 

        System.out.println("\n-------------------------------------------");

        // 2. INFORME DE PARTIDOS
        System.out.println("🎬 [Informe] Último Partido Registrado:");
        if (partido != null) {
            System.out.println(partido.toString());
        } else {
            System.out.println("❌ No hay ningún partido registrado en el sistema todavía (Usá la Opción 2).");
        }
        
        System.out.println("\n⚙️ Sistema de control (Servicio): " + servicio.hashCode());
        System.out.println("===========================================");
    }
        
       
}