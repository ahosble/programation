import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cesta cesta = new Cesta();
        
        System.out.println("\033[33m================================");
        System.out.println("BIENVENIDO A LA CESTA DE LA FORTUNA");
        System.out.println("================================");
        System.out.print("Introduce el nombre del concursante: \033[0m");
        String nombre = scanner.nextLine();
        Concursante concursante = new Concursante(nombre);

        boolean enJuego = true;
        boolean sacoNegra = false;

        while (enJuego && !sacoNegra && cesta.obtenerTotalBolas() > 0) {
            System.out.println("\n\033[35m--------------------------------------");
            System.out.println("Concursante: " + nombre);
            System.out.println("Premio acumulado: " + concursante.getPrecioAcumulado() + " euros");
            System.out.println("Bolas restantes en la cesta -> \033[0mBlancas: " + cesta.getBolasBlancas() + 
                               " ,Azules: " + cesta.getBolasAzules() + 
                               " ,Negras: " + cesta.getBolasNegras());
            System.out.println("\n\033[35m¿Qué deseas hacer?");
            System.out.println("\033[36m1.Sacar bola de la cesta.");
            System.out.println("2. Plantarse y llevarse el dinero.");
            System.out.print("Elige una opción: \033[0m");

            int opcion = -1;
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Mensaje requerido si introducen una letra en lugar de un número
                System.out.println("\033[31mEl presentador no te ha entendido, por favor pulsa 1 o 2 y vuelve a preguntar.\033[0m");
                scanner.next(); 
                continue;
            }

            switch (opcion) {
                case 1: 
                    char bola = cesta.sacarBola();
                    if (bola == 'B') {
                        concursante.sumarPremio(Concursante.valorBolaBlanca);
                        System.out.println("¡Has sacado una bola \033[37mBLANCA\033[0m! +100 euros");
                    } else if (bola == 'A') {
                        concursante.sumarPremio(Concursante.valorBolaAzul);
                        System.out.println("¡Has sacado una bola \033[34mAZUL\033[0m! +200 euros");
                    } else if (bola == 'N') {
                        concursante.bancarrota();
                        sacoNegra = true;
                        System.out.println("¡OH NO! ¡Has sacado la bola NEGRA! Pierdes todo el dinero.");
                    } else {
                        System.out.println("La cesta está vacía.");
                        enJuego = false;
                    }
                    break;
                    
                case 2: 
                    System.out.println("Has decidido plantarte.");
                    enJuego = false;
                    break;
                    
                default:
                    System.out.println("El presentador no te ha entendido, por favor pulsa 1 o 2 y vuelve a preguntar.");
                    break;
            }
        }

        // Despedida final
        System.out.println("\n========================================");
        System.out.println("¡FIN DEL PROGRAMA!");
        System.out.println("Muchas gracias por participar, ha ganado usted: " + concursante.getPrecioAcumulado() + " euros");
        System.out.println("========================================");

        scanner.close();
    }   
}