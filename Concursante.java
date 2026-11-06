public class Concursante {
    private String nombre;
    private int precioAcumulado;
    
    // Constantes de valor de las bolas
    public static final int valorBolaBlanca = 100;
    public static final int valorBolaAzul = 200;

    public Concursante(String nombre) {
        this.nombre = nombre;
        this.precioAcumulado = 0;
    }

    public void sumarPremio(int cantidad) {
        this.precioAcumulado += cantidad;
    }

    public void bancarrota() {
        this.precioAcumulado = 0;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioAcumulado() {
        return precioAcumulado;
    }

    public void setPrecioAcumulado(int precioAcumulado) {
        this.precioAcumulado = precioAcumulado;
    }
}