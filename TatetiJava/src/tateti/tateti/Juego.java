package tateti;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Juego {
    private static Scanner entrada = new Scanner(System.in);
    private tateti.Tablero tablero;
    private Jugador jugador1, jugador2, jugadorActual;

    public Juego() {
        this.tablero = new tateti.Tablero();
        this.jugador1 = new Jugador("Jugador 1", 'X');
        this.jugador2 = new Jugador("Jugador 2", 'O');
        this.jugadorActual = jugador1;  // Comienza el jugador 1
    }

    public void iniciar() {
        Presentacion.mostrarPresentacion();
        solicitarNombresJugadores();
        Presentacion.mostrarBienvenida(jugador1, jugador2);
        mostrarMenu();
    }

    private void solicitarNombresJugadores() {
        do {
            System.out.print("Ingrese el nombre del Jugador 1 (X) (mínimo 3 letras): ");
            jugador1.setNombre(entrada.nextLine());
        } while (jugador1.getNombre().length() < 3);

        do {
            System.out.print("Ingrese el nombre del Jugador 2 (O) (mínimo 3 letras): ");
            jugador2.setNombre(entrada.nextLine());
        } while (jugador2.getNombre().length() < 3);
    }

    private void mostrarMenu() {
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
                case 1:
                    jugar();
                    break;
                case 2:
                    Presentacion.mostrarReglas();
                    break;
                case 3:
                    Presentacion.mostrarCreditos();
                    break;
                case 4:
                    Presentacion.mostrarDespedida();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 4);
    }

    private void jugar() {
        tablero.inicializar();
        while (true) {
            tablero.mostrar();
            String nombreJugadorActual = jugadorActual.getNombre();
            System.out.println(nombreJugadorActual + ", es tu turno. Jugador: " + jugadorActual.getSimbolo());

            int fila = -1, columna = -1;
            boolean coordenadasValidas = false;
            while (!coordenadasValidas) {
                try {
                    System.out.print("Ingrese fila (1-3): ");
                    fila = entrada.nextInt() - 1;
                    System.out.print("Ingrese columna (1-3): ");
                    columna = entrada.nextInt() - 1;

                    if (tablero.esPosicionValida(fila, columna)) {
                        coordenadasValidas = true;
                    } else {
                        System.out.println("Movimiento inválido. Intente nuevamente.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese números enteros.");
                    entrada.nextLine(); // Limpiar la entrada
                }
            }

            tablero.marcar(fila, columna, jugadorActual.getSimbolo());

            if (tablero.verificarGanador(jugadorActual.getSimbolo())) {
                tablero.mostrar();
                System.out.println("¡Felicidades, " + nombreJugadorActual + "! El jugador " + jugadorActual.getSimbolo() + " ha ganado.");
                break;
            } else if (tablero.verificarEmpate()) {
                tablero.mostrar();
                System.out.println("¡El juego terminó en empate!");
                break;
            }

            cambiarJugador();
        }
    }

    private void cambiarJugador() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }
}
