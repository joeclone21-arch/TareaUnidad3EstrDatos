package uni3;

public class EnfoqueRecursiva {
    public static int resolver(Producto[] productos, int n, int capacidadRestante, int presupuestoRestante) {
        // Caso base si no quedan productos o no hay espacio/presupuesto
        if (n == 0 || capacidadRestante <= 0 || presupuestoRestante <= 0) {
            return 0;
        }

        Producto prodActual = productos[n - 1];

        // Si el producto actual excede alguna restriccion no se puede incluir
        if (prodActual.peso > capacidadRestante || prodActual.costo > presupuestoRestante) {
            return resolver(productos, n - 1, capacidadRestante, presupuestoRestante);
        }

        // Evalua las dos opciones no incluir vs incluir el producto
        int noIncluir = resolver(productos, n - 1, capacidadRestante, presupuestoRestante);
        int incluir = prodActual.beneficio + resolver(productos, n - 1, 
                capacidadRestante - prodActual.peso, 
                presupuestoRestante - prodActual.costo);

        // Retorna el máximo beneficio entre ambas decisiones
        return Math.max(noIncluir, incluir);
    }
}