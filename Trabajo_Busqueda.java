/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_busqueda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author asael
 */
public class Trabajo_Busqueda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int bandera=0;
        ArrayList<Integer> array=new ArrayList <Integer>();
        while (bandera==0){
           String menu="1. Añadir un numero \n2. Buscar un numero \n3. Mostrar array \n4. Salir";
           String menu2="1. Busqueda lineal \n2. Busqueda binaria";
           int decicion=Integer.parseInt(JOptionPane.showInputDialog(null,menu));  
           switch (decicion){
               case 1:
                   int numero=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero a ingresar: ")); 
                   array.add(numero);
                   break;
               case 2:
                    int numeroBuscar=Integer.parseInt(JOptionPane.showInputDialog(null,"Numero a buscar: "));
                    int opcion=Integer.parseInt(JOptionPane.showInputDialog(null,"Selecciona una de las opciones disponibles: \n"+menu2));
                    if (opcion==1){
                        busquedaLineal(array,numeroBuscar);
                    }
                    else if(opcion==2){
                        ArrayList<Integer> copia=array;
                        Busquedabinaria(copia,numeroBuscar);
                    }else{
                        JOptionPane.showMessageDialog(null,"Opcion incorrecta, selecciona una de las opciones validas ");
                    }
                   break;
               case 3: 
                   if (array.isEmpty())
                   {
                       JOptionPane.showMessageDialog(null,"Array vacio "); 
                   }else{
                       
                       String mensaje="";
                       for (int i=0;i<array.size();i++){
                       mensaje+=" ["+array.get(i)+"] ";
                   }
                       JOptionPane.showMessageDialog(null,"Array: "+mensaje); 
                   }
                   break;
               case 4:
                   JOptionPane.showMessageDialog(null,"Perfecto nos vemos ");
                   bandera=1;
                   break;
               default:
                   JOptionPane.showMessageDialog(null,"Opcion incorrecta, selecciona una de las opciones validas ");
                   
                
           }
        }
       
        
    }
    public static void Busquedabinaria(ArrayList<Integer>array,int numeroBuscar){
        ArrayList<Integer> copia=new ArrayList<>(array);
        Collections.sort(copia);//metodo srot para ordenar datos en un array de menor a mayor
        //tamaño del arreglo
        int n=copia.size();
        //mitad del arreglo
        int mitad;
        //tamaño del inico
        int inferior=0;
        //tamaño del final
        int superior=n-1;
        
        int bandera=1;
        int coordenadas=0;
        int contador=0;
        while(inferior<=superior){
            mitad=(inferior+superior)/2;
            if (copia.get(mitad)==numeroBuscar){
               coordenadas=mitad;
               bandera=0; 
               inferior=superior+1;
            }
            else if(numeroBuscar<copia.get(mitad)){
                superior=mitad-1;
            }else if (numeroBuscar>copia.get(mitad)){
                inferior=mitad+1;
            }
            contador++;
        }
        if (bandera==0){
            JOptionPane.showMessageDialog(null, "Numero encontrado en la posicion: "+ coordenadas + " con un tiempo de: "+contador);
        }else{
            JOptionPane.showMessageDialog(null, "Numero no encontrado");
        }
              
    }
    public static void busquedaLineal(ArrayList<Integer> array, int numeroBuscar){
        int contador=0;
        int banderita=0;
        for (int i=0;i<array.size();i++){
            contador++;
            if (array.get(i)==numeroBuscar){
                JOptionPane.showMessageDialog(null, "Numero encontrado en la posicion: "+ i+ " con un tiempo de: " +contador);
                banderita=1;
            } 
        }
        if (banderita==0){
            JOptionPane.showMessageDialog(null, "Numero no encontrado");
        }
    }
    
}
