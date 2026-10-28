public class Aventurero {
    private String nombreAventurero;
    private int vidaActualAventurero;
    private int vidaMaximoAventurero;
    private int danoBaseAventurero;
    private int cantidadPociones;

    public static final int curacion = 25;

    public Aventurero(String nombreAventurero, int vidaMaximoAventurero, int danoBaseAventurero, int cantidadPociones) {
        this.nombreAventurero = nombreAventurero;
        this.vidaMaximoAventurero = vidaMaximoAventurero;
        this.vidaActualAventurero = vidaMaximoAventurero; 
        this.danoBaseAventurero = danoBaseAventurero;
        this.cantidadPociones = cantidadPociones;
    }

    public void atacarAventurero(Enemigo objetivo) {
        objetivo.recibirDanoEnemigo(danoBaseAventurero);
    }

    public void beberPocion() {
        if (cantidadPociones > 0) {
            cantidadPociones--;
            vidaActualAventurero += curacion; 
            
            if (vidaActualAventurero > vidaMaximoAventurero) {
                vidaActualAventurero = vidaMaximoAventurero; 
            }
            System.out.println("Has bebido una poción! Vida actual: " + vidaActualAventurero);
            cantidadPociones--;
        } else {
            System.out.println("No dispones de pociones");
        }
    }

    public void recibirDanoAventurero(int dano) {
        vidaActualAventurero = vidaActualAventurero - dano;
        if (vidaActualAventurero < 0) {
            vidaActualAventurero = 0;
        }
    }

    public boolean estaCaido() {
        return vidaActualAventurero <= 0;
    }
    
    
    //GETTERS y SETTERS
    public String getNombreAventurero() {
        return nombreAventurero;
    }

    public int getVidaActualAventurero() {
        return vidaActualAventurero;
    }

    public int getVidaMaximoAventurero() {
        return vidaMaximoAventurero;
    }

    public int getDanoBaseAventurero() {
        return danoBaseAventurero;
    }

    public int getCantidadPociones() {
        return cantidadPociones;
    }

    public void setNombreAventurero(String nombreAventurero) {
        this.nombreAventurero = nombreAventurero;
    }
    
}