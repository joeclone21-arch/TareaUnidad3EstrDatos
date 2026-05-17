package uni3;

public class EnfoqueBottomUp {
    public static int resolver(Producto[] productos, int capacidadMax, int presupuestoMax) {
        int n = productos.length;
        // dp[i][w][b] guardara el beneficio máximo usando los primeros 'i' productos, 
        // con capacidad 'w' y presupuesto 'b'.
        int[][][] dp = new int[n + 1][capacidadMax + 1][presupuestoMax + 1];

        for (int i = 1; i <= n; i++) {
            Producto p = productos[i - 1];
            for (int w = 0; w <= capacidadMax; w++) {
                for (int b = 0; b <= presupuestoMax; b++) {
                    if (p.peso <= w && p.costo <= b) {
                        // Maximo entre no incluir e incluir
                        dp[i][w][b] = Math.max(dp[i - 1][w][b], p.beneficio + dp[i - 1][w - p.peso][b - p.costo]);
                    } else {
                        // No se puede incluir
                        dp[i][w][b] = dp[i - 1][w][b];
                    }
                }
            }
        }
        return dp[n][capacidadMax][presupuestoMax];
    }
}