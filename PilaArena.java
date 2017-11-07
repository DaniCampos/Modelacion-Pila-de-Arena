import java.util.*;


public class PilaArena{

    public static void estabilizar(int[][] mat,int i,int j,int a){
        /*
        mat[i][j] = mat[i][j] - 4;
        if((i+1)<a-1)mat[i+1][j]++;
        if((j+1)<a-1)mat[i][j+1]++;
        if((i-1)>0)mat[i-1][j]++;
        if((j-1)>0)mat[i][j-1]++;*/
        int cant = mat[i][j]/4;
        mat[i][j] = mat[i][j]%4;
        if((i+1)<a-1)mat[i+1][j] += cant;
        if((j+1)<a-1)mat[i][j+1] += cant;
        if((i-1)>0)mat[i-1][j] += cant;
        if((j-1)>0)mat[i][j-1] += cant;

    }

    static public void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("¿Cuantos granos de arena pondrá en el centro? : ");
        int N = s.nextInt();
        int a = 301;

        int[][] mat = new int[a][a];

       /*for (int i=0; i<a; ++i) {
            for (int j=0; j<a; ++j) {
                mat[i][j]=0;
            }
        }*/

        mat[a/2][a/2] = N;
        int count = 0;

        while(count < a*a){

            count = 0;
            for (int i=0; i<a; ++i) {
                for (int j=0; j<a ; ++j) {
                    if(mat[i][j] >= 4){
                        estabilizar(mat,i,j,a);
                    }
                    else count++;

                }

            }
        }

        Ventana v = new Ventana(600);
        v.mostrarMatriz(mat);
    }

}