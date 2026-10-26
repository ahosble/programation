public class Enemigo {
    private String nombreEnemigo;
    private int vidaActualEnemigo;
    private int vidaMaximoEnemigo;
    private int danoBaseEnemigo;

    public Enemigo(String nombreEnemigo, int vidaMaximoEnemigo, int danoBaseEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
        this.vidaMaximoEnemigo = vidaMaximoEnemigo;
        this.vidaActualEnemigo = vidaMaximoEnemigo; 
        this.danoBaseEnemigo = danoBaseEnemigo;   
    }

    public void atacarEnemigo(Aventurero objetivo) {
        objetivo.recibirDanoAventurero(danoBaseEnemigo);
    }

    public void recibirDanoEnemigo(int dano) {
        this.vidaActualEnemigo -= dano; 
        if (this.vidaActualEnemigo < 0) {
            this.vidaActualEnemigo = 0; 
        }
    }

    public boolean estaDerrotadoEnemigo() {
        return this.vidaActualEnemigo <= 0;
    }


    //GETTERS Y SETTERS
    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public int getVidaActualEnemigo() {
        return vidaActualEnemigo;
    }

    public void setVidaActualEnemigo(int vidaActualEnemigo) {
        this.vidaActualEnemigo = vidaActualEnemigo;
    }

    public int getVidaMaximoEnemigo() {
        return vidaMaximoEnemigo;
    }

    public void setVidaMaximoEnemigo(int vidaMaximoEnemigo) {
        this.vidaMaximoEnemigo = vidaMaximoEnemigo;
    }

    public int getDanoBaseEnemigo() {
        return danoBaseEnemigo;
    }

    public void setDanoBaseEnemigo(int danoBaseEnemigo) {
        this.danoBaseEnemigo = danoBaseEnemigo;
    }
}