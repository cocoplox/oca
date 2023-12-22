import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
public class oca{
    public static boolean GAME = true;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Aqui van a ir todas las variables
        Random numeroRandom = new Random();
        boolean numeroValido = false;
        int numeroJugadores; //Se declara mas tarde

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
        }
        System.out.println("Final del bucle");
        numeroJugadores = input.nextInt();
        while (!GAME){

        }
        input.close();
    }
    //Aqui creamos los metodos. Seguramente aqui estaran las casillas especiales
}