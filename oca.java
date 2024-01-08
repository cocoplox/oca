import java.util.Random;
import java.util.Scanner;
public class oca{
    public static boolean GAME = true;
    public static int CASILLA_FINAL = 63;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Aqui van a ir todas las variables
        Random numeroRandom = new Random();
        boolean numeroValido = false;
        int numeroJugadores = 0; // Se le da valor mas tarde
        int dado;
        int[] casillasEspeciales = {1,5,9,14,18,23,27,32,36,41,45,50,54,59,63,6,12,31,26,53,42,52,58};
        int[] casillasOca = {1,5,9,14,18,23,27,32,36,41,45,50,54,59,63};
        int[] casillasPuente = {6,12};

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
                System.out.println("El dado ha caido en " + dado);
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
                        //Caso de que el jugador 1 (0)::
                        i--;
                    }
                    //Bloque puente
                    if(esPuente(jugadores[i])){
                        System.out.println("De puente a puente y tiro porque me lleva la corriente");
                        if(jugadores[i] == 6){
                            System.out.println("El Puente te lleva rio arriba, a la casilla 12");
                            jugadores[i] = 12;
                        }
                        else if(jugadores[i] == 12){
                            System.out.println("El puente te lleva rio abajo, hasta la casilla 6");
                            jugadores[i] = 6;
                        }
                        //En caso de jugador 1 (i = 0) no puedo restarle 1
                        i--;
                    }
                    if (esPozo(jugadores[i])){
                        System.out.println("Caiste en un pozo, Te quedaras aqui, hasta que otro tenga tu mismo destino o hasta que seas el ultimo");
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
        for (int i = 0; i < casillasOca.length;i++){
            if (posicionActual == casillasOca[i]){
                nuevaPosicion = casillasOca[i+1];
            }
        }
        return nuevaPosicion;
    }
    public static boolean esPuente (int posicion){
        if (posicion == 6 || posicion == 12){
            return true;
        }
        return false;
    }
    public static boolean esPozo (int posicion){
        if (posicion == 31){
            return true;
        }
        return false;

    }
    public static int esJugador1 (int  posicion){
        int jugador1 = 0;
        return jugador1;
    }
    //Aqui creamos los metodos. Seguramente aqui estaran las casillas especiales
}