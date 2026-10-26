import java.util.InputMismatchException;
import java.util.Scanner;

public class Mazmorra {
    private static int leerNaturalSeguro(){
        Scanner Scanner = new Scanner(System.in);
        int natural = 0;
        boolean esNatural= false;
        do { 
            try {
                natural = Scanner.nextInt();
                if (natural <=0){
                    System.out.println("Introduzca un numero mayor que 0");
                }
                else {
                    esNatural=true;
                }   
            } 
            catch (InputMismatchException ex) {
                System.out.println("No es un numero.Introduzcalo de nuevo");
                Scanner.next();
            }
            catch(Exception ex){
            }
        }while (!esNatural);
       return natural;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aventurero aventurero=new Aventurero("héroe", 0, 0, 0);

        System.out.println("¿Cual es tu nombre de heroe?: ");
        String nuevoNombre=scanner.nextLine();
        aventurero.setNombreAventurero(nuevoNombre);
        
    }
}