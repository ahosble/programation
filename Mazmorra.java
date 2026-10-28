import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

    public class Mazmorra {

        private static int tirarDado20() {
            Random dado = new Random();
            return dado.nextInt(20) + 1;
        }

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
        Aventurero aventurero=new Aventurero("héroe", 100, 25, 0);
        Enemigo enemigo = new Enemigo("villano", 100, 23);
        
        System.out.println("¿Cual es tu nombre de heroe?: ");
        String nombreHeroe=scanner.nextLine();
        aventurero.setNombreAventurero(nombreHeroe);

        System.out.println("¿Cual es el nombre de tu enemigo: ");
        String nombreEnemigo= scanner.nextLine();
        enemigo.setNombreEnemigo(nombreEnemigo);
        
        
        int opcion;
        System.out.println("1.Atacar con arma.");
        System.out.println("2.Beber poción.");
        opcion = scanner.nextInt();
        
        
        do { 
            switch (opcion) {
                case 1:
                    int resultadoDado= tirarDado20();   
                    System.out.println("Has sacado un "+resultadoDado+" en el dado.");
                        if (resultadoDado==20) {
                            int danoCritico= aventurero.getDanoBaseAventurero()*2;
                            enemigo.recibirDanoEnemigo(danoCritico);
                            break;
                        } else if (resultadoDado==1){
                            System.out.println("PIFIA! No se ha realizado el ataque!");
                            break;
                        } else{
                            int danoBase= aventurero.getDanoBaseAventurero();
                            aventurero.atacarAventurero(enemigo);
                            System.out.println("Has quitado "+danoBase+" puntos de daño");
                             break;
                        }
                case 2:
                    if(aventurero.getCantidadPociones()>0){
                        aventurero.beberPocion();
                        System.out.println("Te has bebido un copazo mi compadre");
                    }else if(aventurero.getCantidadPociones()==0){
                        System.out.println("No hay cubata para ti sus huevos");
                    }
            }

            

        } while (!aventurero.estaCaido() || !enemigo.estaDerrotadoEnemigo());


    }
}