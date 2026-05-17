package uni3;

import java.util.Arrays;

public class EnfoqueTopDown {
    private int[][][] memo;

    public int resolver(Producto[] productos, int capacidadMax, int presupuestoMax) {
        int n = productos.length;
        memo = new int[n + 1][capacidadMax + 1][presupuestoMax + 1];
        // Inicializa la matriz de memoria con -1 para indicar estados no visitados
        for (int[][] m2 : memo) {
            for (int[] m1 : m2) {
                Arrays.fill(m1, -1);
            }
        }
        return optimizarTopDown(productos, n, capacidadMax, presupuestoMax);
    }

    private int optimizarTopDown(Producto[] productos, int n, int w, int b) {
        if (n == 0 || w <= 0 || b <= 0) return 0;
        
        // Si ya se calculo este estado, se retorna directamente
        if (memo[n][w][b] != -1) return memo[n][w][b];

        Producto p = productos[n - 1];

        if (p.peso > w || p.costo > b) {
            memo[n][w][b] = optimizarTopDown(productos, n - 1, w, b);
        } else {
            int noIncluir = optimizarTopDown(productos, n - 1, w, b);
            int incluir = p.beneficio + optimizarTopDown(productos, n - 1, w - p.peso, b - p.costo);
            memo[n][w][b] = Math.max(noIncluir, incluir);
        }
        return memo[n][w][b];
    }
}