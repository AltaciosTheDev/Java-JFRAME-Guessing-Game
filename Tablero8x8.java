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
public class Tablero8x8 extends Tablero{
    public Tablero8x8(){
        super(8);
    }
    
    @Override
    public void devolverTablero(){
        String[] datos = new String[64];
        for (int i=0;i<32;i++){
            datos[2 * i] = String.valueOf((char) ('A' + i));
            datos[2 * i + 1] = String.valueOf((char) ('A' + i));
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