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
}