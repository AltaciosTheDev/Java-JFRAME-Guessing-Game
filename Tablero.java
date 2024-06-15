/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceutec.proyectojuego;

/**
 *
 * @author enzoa
 */

//clase abstract
public abstract class Tablero { 
    private int tamano; //se almacenara el tamano escogido
    private String [][] tablero; //arreglo bidi para letras o numeros de juego
    private boolean [][] adivinado; //arreglo para determinar que se ha adivinado
    private int movimientos; //registro de movimientos
    private int puntos; //registro de puntos
 
    public Tablero(int tamano) {
        this.tamano = tamano;
        this.tablero = new String [tamano][tamano];
        this.adivinado = new boolean [tamano][tamano];
        this.movimientos = 0;
        this.puntos = 0;
        devolverTablero();
    }   
    
    
       public String[][] getTablero() {
        return tablero;
    }

    public boolean[][] getAdivinado() {
        return adivinado;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getTamano() {
        return tamano;
    }
    
    //metodo abstracto devolver tablero que se modificara dinamico en cada subclase
    public abstract void devolverTablero();
    
    //metodo verificar pares en la clase base 
    public boolean verificarPar(int x1, int y1, int x2, int y2) {
        movimientos++; //cada verificacion indica un movimiento y se suma
        if (tablero[x1][y1].equals(tablero[x2][y2])) { //coordenadas 1 equals coordenadas 2
            adivinado[x1][y1] = true; //se marca adivinado el primero 
            adivinado[x2][y2] = true; //se marca adivinado el segundo 
            puntos += 5; //se suman 5 puntos por adivinar 
            return true; //regresa true la funcion por adivinar bien
        } else {
            puntos -= 1; //se adivina mal se resta un punto
            return false; //regresa falso la funcion 
        }
    }
    
    // Método para cargar el estado del tablero
    public void cargarEstado(int movimientos, int puntos, String[][] tablero, boolean[][] adivinado) {
        this.movimientos = movimientos;
        this.puntos = puntos;
        for (int i = 0; i < this.tamano; i++) {
            for (int j = 0; j < this.tamano; j++) {
                this.tablero[i][j] = tablero[i][j];
                this.adivinado[i][j] = adivinado[i][j];
            }
        }
    }
    //Para cuando se quiere empezar de 0, se borran los datos y se devuelve nuevo tablero
    public void reiniciarTalero(){
        movimientos = 0;
        puntos = 0;
        devolverTablero();
    }
    
    //solo era para imprimir en consola el tablero 
    public void imprimirTablero(){
        for (int i=0;i<tamano;i++){
            for(int j=0;j<tamano;j++){
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
