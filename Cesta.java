import java.util.Random;

public class Cesta {
    private int bolasBlancas;
    private int bolasAzules;
    private int bolasNegras;

    // Constructor parametrizado
    public Cesta(int bolasBlancas, int bolasAzules, int bolasNegras) {
        this.bolasBlancas = bolasBlancas;
        this.bolasAzules = bolasAzules;
        this.bolasNegras = bolasNegras;
    }

    // Constructor por defecto
    public Cesta() {
        this(10, 1, 1); // 10 blancas, 1 azul y 1 negra por defecto
    }

    public int obtenerTotalBolas() {
        return this.bolasAzules + this.bolasBlancas + this.bolasNegras;
    }

    private char extraerBola(int b, int a, int n) {
        Random rand = new Random();
        int totalBolas = b + a + n;
        
        if (totalBolas == 0) {
            return 'V';
        }
        int tirada = rand.nextInt(totalBolas) + 1;
        
        if (tirada <= b) {
            return 'B';
        } else if (tirada <= (b + a)) {
            return 'A';
        } else {
            return 'N';
        }
    }

    public char sacarBola() {
        char color = extraerBola(this.bolasBlancas, this.bolasAzules, this.bolasNegras);
        if (color == 'B') {
            this.bolasBlancas--;
        } else if (color == 'A') {
            this.bolasAzules--;
        } else if (color == 'N') {
            this.bolasNegras--;
        }
        return color;
    }

    // Getters y Setters
    public int getBolasBlancas() { return bolasBlancas; }
    public void setBolasBlancas(int bolasBlancas) { this.bolasBlancas = bolasBlancas; }

    public int getBolasAzules() { return bolasAzules; }
    public void setBolasAzules(int bolasAzules) { this.bolasAzules = bolasAzules; }

    public int getBolasNegras() { return bolasNegras; }
    public void setBolasNegras(int bolasNegras) { this.bolasNegras = bolasNegras; }
}