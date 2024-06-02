public class Ponto2D {
    private double x;
    private double y;

    // Construtor padrão (na origem do espaço 2D)
    public Ponto2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Construtor com coordenadas especificadas
    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Construtor que inicializa o ponto com outro ponto
    public Ponto2D(Ponto2D ponto) {
        this.x = ponto.x;
        this.y = ponto.y;
    }

    // Getters e Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Métodos de movimentação do ponto
    public void mover(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void mover(Ponto2D ponto) {
        this.x = ponto.x;
        this.y = ponto.y;
    }

    // Método de comparação semântica do ponto (equals)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Ponto2D ponto = (Ponto2D) obj;
        return Double.compare(ponto.x, x) == 0 &&
               Double.compare(ponto.y, y) == 0;
    }

    // Método de representação do objeto como String
    @Override
    public String toString() {
        return "Ponto2D{" +
               "x=" + x +
               ", y=" + y +
               '}';
    }

    // Método para calcular a distância entre dois pontos
    public double calcularDistancia(Ponto2D ponto) {
        double dx = this.x - ponto.x;
        double dy = this.y - ponto.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Método para criar um novo ponto no mesmo local (clone)
    @Override
    public Ponto2D clone() {
        return new Ponto2D(this);
    }

    // Método principal para teste
    public static void main(String[] args) {
        // Testando os construtores
        Ponto2D p1 = new Ponto2D();
        Ponto2D p2 = new Ponto2D(3, 4);
        Ponto2D p3 = new Ponto2D(p2);

        // Testando os getters e setters
        System.out.println("Ponto p1: " + p1);
        System.out.println("Ponto p2: " + p2);
        System.out.println("Ponto p3: " + p3);

        // Testando o método de movimentação
        p1.mover(1, 2);
        System.out.println("Ponto p1 movido: " + p1);

        p1.mover(p2);
        System.out.println("Ponto p1 movido para p2: " + p1);

        // Testando o método de comparação
        System.out.println("p1 é igual a p2? " + p1.equals(p2));

        // Testando o método de cálculo de distância
        System.out.println("Distância entre p1 e p3: " + p1.calcularDistancia(p3));

        // Testando o método de clonagem
        Ponto2D p4 = p1.clone();
        System.out.println("Ponto p4 (clone de p1): " + p4);
    }
}