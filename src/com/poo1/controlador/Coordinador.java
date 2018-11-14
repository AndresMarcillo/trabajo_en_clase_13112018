/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo1.controlador;

import com.poo1.modelo.Punto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Coordinador {
    ArrayList<Punto> puntos = new ArrayList<Punto>();
    
    public void menu(){
        int op=0;
        do {
            try {
                op=Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion:\n"
                + "1) Ingresar punto\n"
                + "2) Calcular distancia entre dos puntos\n"
                + "3) Redefinir ubicacion\n"
                + "4) Imprimir puntos\n"
                + "5) Calcular distancia a la torre\n"
                + "6) Salir"));
                
                switch(op){
                    case 1:
                        System.out.println("Caso 1");
                        ingresarPunto();
                        break;
                    case 2:
                        System.out.println("Caso 2");
                        calcularDistancia();
                        break;
                    case 3:
                        System.out.println("Caso 3");
                        break;
                    case 4:
                        System.out.println("Caso 4");
                        JOptionPane.showMessageDialog(null, imprimirPuntos());
                        break;
                    case 5:
                        System.out.println("Caso 5");
                        break;
                    case 6:
                        System.out.println("Caso 6");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error!!!");
            }
            
        } while (op!=6);
    }
    
    public void ingresarPunto(){
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese X"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Y"));
        puntos.add(new Punto(x,y));
    }
    
    public String imprimirPuntos(){
        String datos="";
        for (Punto punto : puntos) {
            datos += (1+puntos.indexOf(punto))+".- "+punto.toString()+"\n";
        }
        //JOptionPane.showMessageDialog(null, datos);
        return datos;
    }
    
    public void calcularDistancia(){
        int sel1 = 0;
        int sel2 = 0;
        try {
            sel1 = Integer.parseInt(JOptionPane.showInputDialog(imprimirPuntos()+"\nIngresa un punto: "))-1;
            sel2 = Integer.parseInt(JOptionPane.showInputDialog(imprimirPuntos()+"\nIngresa otro punto: "))-1;
            
            double v1=Math.pow(puntos.get(sel2).getX()-puntos.get(sel1).getX(),2);
            double v2=Math.pow(puntos.get(sel2).getY()-puntos.get(sel1).getY(),2);;
            double di=Math.sqrt(v1+v2);
            JOptionPane.showMessageDialog(null, "La distancia es: " + di);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                
        
    }
}
