# TareaUnidad3EstrDatos
Tarea Unidad 3 Programación Dinámica UPS

# Optimización de Inventario mediante Programación Dinámica 

Este repositorio contiene la implementación y el análisis de rendimiento de un sistema de optimización de inventario diseñado para maximizar los beneficios de una empresa. El proyecto resuelve un problema incorporando restricciones simultáneas de espacio físico y recursos financieros.

## Descripción del Problema

Una empresa necesita decidir de forma óptima qué productos incluir en su inventario para maximizar el beneficio económico total. Sin embargo, la toma de decisiones está sujeta a dos limitaciones críticas e independientes:
1. **Capacidad de almacenamiento máxima:** Restricción física basada en el **peso** acumulado de los productos.
2. **Presupuesto disponible:** Restricción económica basada en el **costo** financiero de adquirir/mantener cada producto.

El software evalúa un conjunto de productos —donde cada uno posee un beneficio, peso y costo específico— y determina la combinación exacta que produce la mayor ganancia posible sin violar ninguna de las dos restricciones.

## Enfoques Algorítmicos Implementados

Para resolver el problema y analizar la eficiencia computacional, se desarrollaron tres estrategias en **Java**:

1. **Enfoque Recursivo Puro:** Solución por fuerza bruta que explora el árbol de decisiones completo. Su complejidad temporal es exponencial $O(2^N)$, lo que la vuelve ineficiente para grandes volúmenes de datos.
2. **Programación Dinámica - Bottom-Up (Tabulación):** Solución iterativa que construye una tabla tridimensional `dp[i][w][b]` desde los casos base. Optimiza el tiempo de ejecución a un comportamiento pseudopolinomial $O(N \times W \times B)$.
3. **Programación Dinámica - Top-Down (Memoización):** Solución recursiva inteligente que almacena en memoria los subproblemas ya calculados para evitar la redundancia, manteniendo la misma eficiencia óptima que el enfoque Bottom-Up.

## Análisis de Complejidad

| Enfoque | Complejidad Temporal | Complejidad Espacial | Eficiencia |
| :--- | :--- | :--- | :--- |
| **Recursivo Puro** | $O(2^N)$ | $O(N)$ | Ineficiente (Exponencial) |
| **Bottom-Up** | $O(N \times W \times B)$ | $O(N \times W \times B)$ | Óptima (Tabulación) |
| **Top-Down** | $O(N \times W \times B)$ | $O(N \times W \times B) + O(N)$ | Óptima (Memoización) |

Donde:
* $N$: Número total de productos disponibles.
* $W$: Capacidad máxima de almacenamiento (peso).
* $B$: Presupuesto financiero total disponible.

##  Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 17 o superior)
* **Conceptos:** Programación Dinámica, Notación Big O, Estructuras de Datos Matriarcales, Algoritmos de Optimización.
