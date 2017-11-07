import java.util.*;

public class Pila{

    private Node ultimo;
    private int tamano;

    private class Node{
        int indicex;
        int indicey;
        Node sgte;
    }

    public Pila(){
        ultimo = null;
        tamano = 0;
    }

    boolean estaVacia(){
        if(tamano == 0){
            return true;
        }
        return false;
    }

    void apilar(int i, int j){
        if(estaVacia()){
            ultimo = new Node();
            ultimo.indicex = i;
            ultimo.indicey = j;
            ultimo.sgte = null;
        }
        else{
            Node anterior = ultimo;
            ultimo = new Node();
            ultimo.indicex = i;
            ultimo.indicey = j;
            ultimo.sgte = anterior;
        }
        ++tamano;
    }

    int[] desapilar() {
        int[] pos;
        pos = new int[2];

        if (estaVacia()) {
            System.out.println("Pila Vacia");
            pos[0] = -1;
            pos[1] = -1;
        }
        else {

            pos[0] = ultimo.indicex;
            pos[1] = ultimo.indicey;

            if (tamano == 1) {
                ultimo = null;
            } else {
                ultimo = ultimo.sgte;
            }
            --tamano;
        }

        return pos;

    }
}