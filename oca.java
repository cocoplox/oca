import java.util.Random;
import java.util.Scanner;
public class oca{
    public static boolean GAME = true;
    public static int CASILLA_FINAL = 63;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int prueba = 10;
        //Aqui van a ir todas las variables
        Random numeroRandom = new Random();
        boolean numeroValido = false;
        int numeroJugadores = 0; // Se le da valor mas tarde
        int dado;
        int[] casillasEspeciales = {1,5,9,14,18,23,27,32,36,41,45,50,54,59,63,6,12,31,26,53,42,52,58};
        int[] casillasOca = {1,5,9,14,18,23,27,32,36,41,45,50,54,59,63};

        System.out.println("Vamos a jugar al juego de la oca");
        System.out.println("Introduce el numero de jugadores (1-4)");

        while(!numeroValido){
            try {
                numeroJugadores = input.nextInt();
                if(numeroJugadores >= 1 && numeroJugadores <= 4){
                    System.out.println("Okay sereis: " + numeroJugadores + " jugadores");
                    numeroValido = true;
                }
                else{
                    System.out.println("El numero debe de estar entre 1-4");
                }
            } catch (Exception InputMismatchException) {
                System.out.println("Error: Debes introducir un valor numérico, Introduce un nuevo numero: ");
                input.next();
            }
            finally{input.nextLine();} //Limpiamos el buffer
        }
        //Se crean los jugadores en base al numero introducido:

        int[] jugadores = new int[numeroJugadores];
        //El indice de esta array es el jugador, y el valor es su posicion en el tablero

        while (GAME){
            for (int i = 0; i < jugadores.length; i++){
                System.out.println("Es el turno del jugador: " + (i+1));
                System.out.println("Actualmente estas en la casilla: " + jugadores[i]);
                System.out.println("Pulsa ENTER para tirar los dados");
                input.nextLine();

                dado = numeroRandom.nextInt(6)+1;
                jugadores[i] += dado;
                System.out.println("el jugador " + (i+1) + " se ha desplazado a la casilla: " + jugadores[i]);
                // Metodo casilla especial
                if (esCasillaEspecial(jugadores[i], casillasEspeciales)){
                    System.out.println("Estas en una casilla especial DEBUG");

                    //Bloque oca
                    if(esOca(jugadores[i], casillasOca)){
                        System.out.println("De oca a oca y tiro porque me toca");
                        int nuevaPosicion = posicionOcaAOca(jugadores[i], casillasOca);
                        jugadores[i] = nuevaPosicion;
                        System.out.println("Te has desplazado a la casilla: " + jugadores[i]);
                        System.out.println("Vuelves a tirar");
                        i--;
                    }


                }
                System.out.println("\n");
            }
        }
        input.close();
    }
    public static boolean esCasillaEspecial (int posicion, int[] casillasEspeciales){
        for (int valor : casillasEspeciales){
            if (valor == posicion){
                return true;
            }
        }
        return false;
    }
    public static boolean esOca (int posicion, int[] casillasOca){
        for(int valores : casillasOca){
            if (valores == posicion){
                return true;
            }
        }
        return false;
    }
    public static int posicionOcaAOca (int posicionActual, int[] casillasOca){
        int nuevaPosicion = 0;
        for (int i = 0; i < casillasOca.length -1;i++){
            if (posicionActual == casillasOca[i]){
                nuevaPosicion = casillasOca[i+1];
            }
        }
        return nuevaPosicion;
    }
    //Aqui creamos los metodos. Seguramente aqui estaran las casillas especiales
}