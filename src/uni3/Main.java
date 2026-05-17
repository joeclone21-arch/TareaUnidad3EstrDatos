package uni3;

public class Main {
    public static void main(String[] args) {
        // Conjunto de datos para pruebas
        Producto[] productos = {
            new Producto("Producto A", 150, 10, 20),
            new Producto("Producto B", 100, 20, 15),
            new Producto("Producto C", 90, 5, 10),
            new Producto("Producto D", 200, 15, 25),
            new Producto("Producto E", 70, 8, 5)
        };

        int capacidadMax = 30;
        int presupuestoMax = 40;

        System.out.println("-----PRUEBAS DE RENDIMIENTO------");

        // Prueba Recursiva
        long inicio = System.nanoTime();
        int resRec = EnfoqueRecursiva.resolver(productos, productos.length, capacidadMax, presupuestoMax);
        long fin = System.nanoTime();
        System.out.printf("Enfoque Recursivo : Beneficio Máximo: %d | Tiempo: %.4f ms\n", resRec, (fin - inicio) / 1e6);

        // Prueba BottomUp
        inicio = System.nanoTime();
        int resBU = EnfoqueBottomUp.resolver(productos, capacidadMax, presupuestoMax);
        fin = System.nanoTime();
        System.out.printf("Enfoque Bottom-Up : Beneficio Máximo: %d | Tiempo: %.4f ms\n", resBU, (fin - inicio) / 1e6);

        // Prueba TopDown
        EnfoqueTopDown std = new EnfoqueTopDown();
        inicio = System.nanoTime();
        int resTD = std.resolver(productos, capacidadMax, presupuestoMax);
        fin = System.nanoTime();
        System.out.printf("Enfoque Top-Down  : Beneficio Máximo: %d | Tiempo: %.4f ms\n", resTD, (fin - inicio) / 1e6);
        System.out.println("-------------------------------------");
    }
}