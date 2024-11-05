
package tateti;

import java.util.Scanner;

public class TaTeTi {

    private static Scanner scanner = new Scanner(System.in);
    private static String player1Name;
    private static String player2Name;
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        inicializarTablero();
        mostrarMenu();
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
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

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
        scanner.nextLine();
    }

    private static void mostrarCreditos() {
        System.out.println("\n===== CRÉDITOS =====");
        System.out.println("Juego de Ta-Te-Tí desarrollado en Java.");
        System.out.println("Autor: Tu Nombre");
        System.out.println("Universidad Tecnológica Nacional, Proyecto Integrador.");
        System.out.println("Presiona Enter para regresar al menú...");
        scanner.nextLine();
    }

    private static void iniciarJuego() {
        System.out.print("Ingrese el nombre del Jugador 1 (X): ");
        player1Name = scanner.nextLine();
        System.out.print("Ingrese el nombre del Jugador 2 (O): ");
        player2Name = scanner.nextLine();
        inicializarTablero();
        currentPlayer = 'X';

        while (true) {
            mostrarTablero();
            String currentPlayerName = (currentPlayer == 'X') ? player1Name : player2Name;
            System.out.println(currentPlayerName + ", es tu turno. Jugador: " + currentPlayer);
            System.out.print("Ingrese fila (1-3): ");
            int fila = scanner.nextInt() - 1;
            System.out.print("Ingrese columna (1-3): ");
            int columna = scanner.nextInt() - 1;

            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && board[fila][columna] == ' ') {
                board[fila][columna] = currentPlayer;
                if (verificarGanador()) {
                    mostrarTablero();
                    System.out.println("¡Felicidades, " + currentPlayerName + "! El jugador " + currentPlayer + " ha ganado.");
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
                board[i][j] = ' ';
            }
        }
    }

    private static void mostrarTablero() {
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    private static boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private static void cambiarJugador() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}