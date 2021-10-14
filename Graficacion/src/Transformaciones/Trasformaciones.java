package Transformaciones;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static oracle.jrockit.jfr.events.Bits.floatValue;

public class Trasformaciones {

    float[][] matrizTransformada = new float[3][4];
    float[][] matriz2;
    float dx, dy;
    float ex, ey, xc, yc;
    float grados;

    public static void main(String args[]) {
        Figura ventana = new Figura();
        Trasformaciones operar = new Trasformaciones();
        ventana.setResizable(false);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        ventana.setVisible(true);
        //Rotar
         ventana.setMatriz(operar.rotacion(20f, 0f, 0f, 1f));
        //Escalar
        //ventana.setMatriz(operar.escalar(0.4f, 0.4f, 1f));
        //Traslacion
        //ventana.setMatriz(operar.traslacion(413f, 100f, 1f));
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public float[][] rotacion(float gra, float x, float y, float z) {
        float[][] matrizV;
        double pi = Math.PI;
        double grados = (float) (gra * (pi / 180));
        float coseno = (float) Math.cos(grados);
        float senoN = (float) -Math.sin(grados);
        float seno = floatValue(Math.sin(grados));
        float[][] rota = {{coseno, senoN, 0}, {seno, coseno, 0}, {0, 0, 1}};
        Figura ventana = new Figura();
        matriz2 = traspuesta(ventana.getMatriz());
        matrizTransformada = producto(rota, matriz2);
        matrizV = regresar(matriz2[0][3] - matrizTransformada[0][3], matriz2[1][3] - matrizTransformada[1][3], 0f, matrizTransformada);
        return traspuesta(matrizV);
    }

    public float[][] escalar(float ex, float ey, float z) {

        float[][] escala = {{ex, 0, 0}, {0, ey, 0}, {0, 0, 1}};
        float[][] matriz2;
        float[][] matrizV;

        Figura ventana = new Figura();
        matriz2 = traspuesta(ventana.getMatriz());
        matrizTransformada = producto(escala, matriz2);

        if (ex != 1 && ey != 1) {
            System.out.println("if numero 1 ");
            matrizV = regresar(matriz2[0][0] - matrizTransformada[0][0], matriz2[1][1] - matrizTransformada[1][1], 0f, matrizTransformada);
            return traspuesta(matrizV);
        } else if (ex != 1 && ey == 1) {
            matrizV = regresar(matriz2[0][0] - matrizTransformada[0][0], 1, 0f, matrizTransformada);
            return traspuesta(matrizV);
        } else if (ey != 1 && ex == 1) {
            matrizV = regresar(1, matriz2[1][1] - matrizTransformada[1][1], 0f, matrizTransformada);
            return traspuesta(matrizV);
        }

        return null;
    }

    public float[][] regresar(float x, float y, float z, float matriz0[][]) {
        float[][] matriz;
        float traslacion[][] = {{1, 0, x}, {0, 1, y}, {0, 0, 1}};
        matriz = producto(traslacion, matriz0);
        return matriz;
    }

    public float[][] traslacion(float dx, float dy, float z) {
        float traslacion[][] = {{1, 0, dx}, {0, 1, dy}, {0, 0, 1}};
        float[][] matrizTra;

        Figura ventana = new Figura();
        matriz2 = ventana.getMatriz();
        matrizTra = traspuesta(ventana.getMatriz());
        matrizTransformada = producto(traslacion, matrizTra);
        return traspuesta(matrizTransformada);
    }

    public float[][] traspuesta(float[][] matriz) {
        float[][] matrizTranspuesta = new float[matriz[0].length][matriz.length];
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                matrizTranspuesta[y][x] = matriz[x][y];
            }
        }
        return matrizTranspuesta;
    }

    private static float[][] producto(float m1[][], float m2[][]) {
        int fil_m1 = m1.length;
        int col_m1 = m1[0].length;

        int fil_m2 = m2.length;
        int col_m2 = m2[0].length;

        if (col_m1 != fil_m2) {
            throw new RuntimeException("No se pueden multiplicar las matrices");
        }

        // La nueva matriz es de filas de M1 y columnas de M2
        float[][] multiplicacion = new float[fil_m1][col_m2];

        for (int x = 0; x < multiplicacion.length; x++) {
            for (int y = 0; y < multiplicacion[x].length; y++) {

                // El nuevo bucle suma la multiplicación de la fila por la columna
                for (int z = 0; z < col_m1; z++) {
                    multiplicacion[x][y] += m1[x][z] * m2[z][y];
                }
            }
        }

        return multiplicacion;
    }

}
