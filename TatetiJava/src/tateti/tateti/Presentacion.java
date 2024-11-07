
package tateti;

import java.util.Scanner;

public class Presentacion {
    private static Scanner entrada = new Scanner(System.in);

    public static void mostrarPresentacion() {
        System.out.println("======================================================");
        System.out.println("             Bienvenidos al juego de Ta-Te-Ti         ");
        System.out.println("                     GoldenBytes                      ");
        System.out.println("------------------------------------------------------");
        System.out.println("           ¡Disfruta de este clásico juego!           ");
        System.out.println("  Juega con un amigo y demuestra tus habilidades en   ");
        System.out.println("            estrategia y pensamiento rápido.          ");
        System.out.println("======================================================\n");

        System.out.println("Presiona Enter 2 veces para comenzar...");
        entrada.nextLine(); // Espera la entrada de Enter
    }

    public static void mostrarBienvenida(Jugador jugador1, Jugador jugador2) {
        System.out.println("\n¡Bienvenidos, " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");
        System.out.println("Prepárense para una partida emocionante de Ta-Te-Ti.\n");
    }

    public static void mostrarReglas() {
        System.out.println("\n===== REGLAS DEL JUEGO =====");
        System.out.println("1. El juego es para dos jugadores: 'X' y 'O'.");
        System.out.println("2. Los jugadores se turnan para colocar su símbolo en una celda vacía del tablero.");
        System.out.println("3. El primer jugador que logre colocar tres símbolos en línea (horizontal, vertical o diagonal) gana.");
        System.out.println("4. Si todas las celdas se llenan sin un ganador, el juego termina en empate.");
        System.out.println("Presiona Enter para regresar al menú...");
        entrada.nextLine();
    }

    public static void mostrarCreditos() {
        System.out.println("\n===== CRÉDITOS =====");
        System.out.println("Juego desarrollado por GoldenBytes.\n");
        System.out.println("Presiona Enter para regresar al menú...");
        entrada.nextLine();
    }

    public static void mostrarDespedida() {
        System.out.println("\n¡Gracias por jugar! ¡Hasta la próxima!");
    }
}