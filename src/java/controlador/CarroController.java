/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.CarroDao;
import java.util.List;
import java.util.Scanner;
import modelo.Carro;



public class CarroController {
    public static void main(String[] args) {
        Scanner scann = new Scanner (System.in);
        Carro car = new Carro(0);
        Conexion conn = new Conexion();
        CarroDao card = new CarroDao(conn);
        
        System.out.println("Inserte el color del automovil");
        car.setColor(scann.next());
        System.out.println("Inserte la marca del automovil");
        car.setMarca(scann.next());
        System.out.println("Ingrese la modelo del vehiculo");
        car.setModelo(scann.next());
        System.out.println("Ingrese la fecha de fabricacion");
        car.setFechaFabricacion(scann.next());
        
        ///card.insertar(car);
        
        boolean respuesta = card.insertar(car);
        
        if(respuesta){
            System.out.println("Su registro fue exitoso");
        }else{
            System.out.println("Error al guardar");
        }
        
         List<Carro> list = card.selectALL();
            for (Carro car2 : list){
                System.out.println("El id del carro es" + car2.getIdCarro());
                System.out.println("el color es"+ car2.getColor());
                System.out.println("la marca es "+car2.getMarca());
                System.out.println("el modelo es "+car2.getModelo());
                System.out.println("fecha fabricacion"+car2.getFechaFabricacion());


            }
   
    }
    
}
