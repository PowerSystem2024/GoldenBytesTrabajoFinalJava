package batallanavaljava;


public class BatallaNavalJava {
<<<<<<< HEAD

    
    public static void main(String[] args) {
        System.out.println("Hola GoldenBytes!");
    }
    
}
=======
    public static final int TAMANO_MATRIZ = 11;
    public static final String COLUMNAS_LETRAS = " ABCDEFGHIJ";
    public static final String FILAS_NUMEROS = " 1234567890";
    //private static final String[] FILAS_NUMEROS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static boolean esJugador;
    
    
    public static void main(String[] args) {
        System.out.println("Bienvenido a Batalla Naval!");
        String nombreJugador = "Pacnhito";
        
        // Crear una instancia de Tablero
        BatallaNavalLoop batallaNavalLoop = new BatallaNavalLoop();
        batallaNavalLoop.batallaNavalLoop(nombreJugador);  
               
        
    }
}
>>>>>>> 97d494e09ec07db217125eddb769952303b067e3
