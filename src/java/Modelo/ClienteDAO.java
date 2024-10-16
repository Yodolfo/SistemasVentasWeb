
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String dni){
        Cliente cliente = new Cliente();
        String sql="select * from cliente where Dni="+dni;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNom(rs.getString(3));
                cliente.setDirec(rs.getString(4));
                cliente.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    
    // Operaciones CRUD en JAVA
    
    public List listar(){
        String sql="select * from cliente";
        List<Cliente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Cliente c1 = new Cliente();
                c1.setId(rs.getInt(1));
                c1.setDni(rs.getString(2));
                c1.setNom(rs.getString(3));
                c1.setDirec(rs.getString(4));
                c1.setEstado(rs.getString(5));
                lista.add(c1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar la tabla Cliente");
        }
        return lista;
    }
    
    public  int agregar(Cliente c1){
        String sql="insert into cliente(Dni,Nombres,Direccion,Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c1.getDni());
            ps.setString(2, c1.getNom());
            ps.setString(3, c1.getDirec());
            ps.setString(4, c1.getEstado());
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el Cliente");
        }
        return r;
    }
    
    public Cliente listarId(int id){
        Cliente client=new Cliente();
        String sql="select * from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                client.setDni(rs.getString(2));
                client.setNom(rs.getString(3));
                client.setDirec(rs.getString(4));
                client.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar el cliente");
        }
        return client;
    }
    
    public int actualizar(Cliente c1){
        String sql="update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c1.getDni());
            ps.setString(2, c1.getNom());
            ps.setString(3, c1.getDirec());
            ps.setString(4, c1.getEstado());
            ps.setInt(5, c1.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar el Cliente");
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
