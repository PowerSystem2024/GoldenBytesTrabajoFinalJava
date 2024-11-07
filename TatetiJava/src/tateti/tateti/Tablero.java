package tateti;

public class Tablero {
    private char[][] tablero;

    public Tablero() {
        tablero = new char[3][3];
    }

    public void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';  // Vaciar el tablero al inicio
            }
        }
    }

    public void mostrar() {
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

    public boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ';
    }

    public void marcar(int fila, int columna, char simbolo) {
        tablero[fila][columna] = simbolo;
    }

    public boolean verificarGanador(char simbolo) {
        // Comprobación para ganar en filas, columnas o diagonales
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo) return true;  // Filas
            if (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo) return true;  // Columnas
        }
        if (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo) return true;  // Diagonal principal
        if (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo) return true;  // Diagonal inversa
        return false;
    }

    public boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false; // Si hay alguna celda vacía, no es empate
                }
            }
        }
        return true;
    }
}
