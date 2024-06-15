/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceutec.proyectojuego;
import java.util.Random;
/**
 * 
 * @author enzoa
 */
public class Tablero4x4 extends Tablero{
    
    public Tablero4x4(){
        super(4);
    }
    
    @Override
    public void devolverTablero(){
        //Generar arreglo de 16 elementos y rellenar con pares de 0 - 7 
        String[] datos = new String[16]; //array de 16 elementos string VACIO 
        for (int i=0; i<8;i++){ //bucle para llegar hasta 7 
            //asegura colocar el dato en posiciones consecutivas
            //al final el arreglo queda con pares del 0 a 7 en posiciones consecutivas
            datos[2 *i ] = String.valueOf(i); 
            datos[2 * i + 1] = String.valueOf(i);
            //[0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7]
        } 
        
        //Sortear aleatorio los datos en arreglo de datos 
        Random rand = new Random(); //inicializamos un objeto random
        for(int i =0; i<datos.length; i++){
            int indiceRandom = rand.nextInt(datos.length); //dato random de 0 a length
            String temp = datos[i];//se agarra datos[i] se guarda en temp
            datos[i] = datos[indiceRandom];//se agarra datos[random] y se pone en datos[i]
            datos[indiceRandom] = temp;//se agarra temp y se pone en datos[random]
        }
        
        //Asignar a arreglo tablero valores de arreglo datos, y adivinados todo falso
        int index = 0; //index que recorrera datos 
        String[][] tablero = getTablero(); //arreglo bidi tablero vacio que llenaremos despues 
        boolean[][] adivinado = getAdivinado(); //arreglo bidi adivinado vacio que llenaremos despues
        for (int i = 0; i < getTamano(); i++) { //bucle que itera hasta 3 filas , 3 columnas por el tamano
            for (int j = 0; j < getTamano(); j++) {//bucle que itera hasta 3 filas , 3 columnas por el tamano
                tablero[i][j] = datos[index++];//iterara todo el arreglo random de datos y ubicara info en tablero
                adivinado[i][j] = false; //marca todos los adivinados falsos al iniicar el juego
            }
        }
    

    }
}


