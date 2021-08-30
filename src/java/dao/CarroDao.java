/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Carro;

public class CarroDao {
    Conexion conn;
    
    public CarroDao (Conexion conn){
    
        this.conn = conn;
    
    }
    public boolean insertar (Carro ca){
    String sql="insert into carro values (?,?,?,?,?)";
    
    try{
    PreparedStatement ps = conn.conectar().prepareStatement(sql);
    
    ps.setInt(1, ca.getIdCarro() );
    ps.setString(2,ca.getColor());
    ps.setString(3, ca.getMarca());
    ps.setString(4,ca.getModelo());
    ps.setString(5, ca.getFechaFabricacion());
    ps.executeUpdate();
    return true;
    }catch(Exception e){
       return false;
    }
    }
    
    public List<Carro>selectALL(){
     String sql="select * from carro";
    
    try{
    PreparedStatement ps = conn.conectar().prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    Carro car;
    List<Carro> lista = new LinkedList<>(); 
    while(rs.next()){
    car = new Carro(rs.getInt("idCarro"));
    car.setColor(rs.getString("color"));
    car.setMarca(rs.getString("marca"));
    car.setModelo(rs.getString("modelo"));
    car.setFechaFabricacion(rs.getString("fechaFabricacion"));
    
    lista.add(car);
    }

    return lista;
    }catch(Exception e){
       return null;
    }
    
    }
}
