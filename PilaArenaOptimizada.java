import java.util.*;

public class PilaArenaOptimizada{

    public static void estabilizar(int[][] mat, int i, int j, Pila p){
        /* void estabilizar: estabiliza la celda que le es asignada y luego verifica si es necesario incluir las celdas
            adyacentes a la pila de desborde
         */
        int a = 0, b = 0, c = 0, d = 0, cant = 0;
        cant = mat[i][j] / 4;
        mat[i][j] = mat[i][j]%4;
        a = mat[i + 1][j];
        mat[i + 1][j] += cant;
        if(a < 4 && mat[i + 1][j] >= 4){
            p.apilar(i + 1, j);
        }
        b = mat[i][j + 1];
        mat[i][j + 1] += cant;
        if(b < 4 && mat[i][j + 1] >= 4){
            p.apilar(i, j + 1);
        }
        c = mat[i - 1][j];
        mat[i - 1][j] += cant;
        if(c < 4 && mat[i - 1][j] >= 4){
            p.apilar(i - 1, j);
        }
        d = mat[i][j - 1];
        mat[i][j - 1] += cant;
        if(d < 4 && mat[i][j - 1] >= 4){
            p.apilar(i, j - 1);
        }
    }

    static public void main(String[] args){
		/*
		Parametros:
			int N: cantidad de granos de arena
			int dim: dimension que toma la matriz
			int[][] mat: matriz que contiene a los granos
			Pila porDesbordar: Pila donde se guardan las celdas que tienen mas de 3 granos
			int[] indices: array que contiene los indices de la celda por desbordar
		*/
        Scanner s = new Scanner(System.in);
        System.out.print("¿Cuantos granos de arena pondra en el centro?: ");
        int N = s.nextInt();
        double d = Math.floor(Math.sqrt(N));
        int dim = (int) d;
        int[][] mat = new int[dim][dim];
        mat[dim/2][dim/2] = N;
        Pila porDesbordar = new Pila();
        porDesbordar.apilar(dim/2,dim/2);
        int[] indices;

        while(!porDesbordar.estaVacia()){
            indices = porDesbordar.desapilar();
            estabilizar(mat, indices[0], indices[1], porDesbordar);
        }
        Ventana v = new Ventana(600);
        v.mostrarMatriz(mat);

    }
}