package tateti;

import java.util.Scanner;

public class TaTeTi {

    private static Scanner entrada = new Scanner(System.in);
    private static String nombreJugador1;
    private static String nombreJugador2;
    private static char[][] tablero = new char[3][3];
    private static char jugadorActual = 'X';

    public static void main(String[] args) {
        mostrarPresentacion();
        inicializarTablero();
        mostrarMenu();
    }

    private static void mostrarPresentacion() {
        System.out.println("======================================================");
        System.out.println("             Bienvenidos al juego de Ta-Te-Ti         ");
        System.out.println("                     GoldenBytes                      ");
        System.out.println("------------------------------------------------------");
        System.out.println("           ¡Disfruta de este clásico juego!           ");
        System.out.println("  Juega con un amigo y demuestra tus habilidades en   ");
        System.out.println("            estrategia y pensamiento rápido.          ");
        System.out.println("======================================================\n");

        System.out.println("Presiona Enter para comenzar...");
        entrada.nextLine(); // Espera la entrada de Enter
    }

    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("===== MENÚ DEL JUEGO =====");
            System.out.println("1. Jugar");
            System.out.println("2. Reglas del juego");
            System.out.println("3. Créditos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> iniciarJuego();
                case 2 -> mostrarReglas();
                case 3 -> mostrarCreditos();
                case 4 -> System.out.println("Gracias por jugar. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private static void mostrarReglas() {
        System.out.println("\n===== REGLAS DEL JUEGO =====");
        System.out.println("1. El juego es para dos jugadores: 'X' y 'O'.");
        System.out.println("2. Los jugadores se turnan para colocar su símbolo en una celda vacía del tablero.");
        System.out.println("3. El primer jugador que logre colocar tres símbolos en línea (horizontal, vertical o diagonal) gana.");
        System.out.println("4. Si todas las celdas se llenan sin un ganador, el juego termina en empate.");
        System.out.println("Presiona Enter para regresar al menú...");
        entrada.nextLine();
    }

    private static void mostrarCreditos() {
        System.out.println("\n===== CRÉDITOS =====");
        System.out.println("Juego de Ta-Te-Tí desarrollado en Java.");
        System.out.println("Autor: GoldenBytes");
        System.out.println("Universidad Tecnológica Nacional, Proyecto Integrador.");
        System.out.println("Presiona Enter para regresar al menú...");
        entrada.nextLine();
    }

    private static void iniciarJuego() {
        System.out.print("Ingrese el nombre del Jugador 1 (X): ");
        nombreJugador1 = entrada.nextLine();
        System.out.print("Ingrese el nombre del Jugador 2 (O): ");
        nombreJugador2 = entrada.nextLine();
        inicializarTablero();
        jugadorActual = 'X';

        while (true) {
            mostrarTablero();
            String nombreJugadorActual = (jugadorActual == 'X') ? nombreJugador1 : nombreJugador2;
            System.out.println(nombreJugadorActual + ", es tu turno. Jugador: " + jugadorActual);
            System.out.print("Ingrese fila (1-3): ");
            int fila = entrada.nextInt() - 1;
            System.out.print("Ingrese columna (1-3): ");
            int columna = entrada.nextInt() - 1;

            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugadorActual;
                if (verificarGanador()) {
                    mostrarTablero();
                    System.out.println("¡Felicidades, " + nombreJugadorActual + "! El jugador " + jugadorActual + " ha ganado.");
                    break;
                } else if (verificarEmpate()) {
                    mostrarTablero();
                    System.out.println("¡El juego terminó en empate!");
                    break;
                }
                cambiarJugador();
            } else {
                System.out.println("Movimiento inválido. Intente nuevamente.");
            }
        }
    }

    private static void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    private static void mostrarTablero() {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    private static boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual)
                return true;
            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)
                return true;
        }
        return (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) ||
               (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual);
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private static void cambiarJugador() {
        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
    }
}