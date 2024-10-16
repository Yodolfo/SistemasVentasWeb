
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoDAO {
 
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscarProducto(int id){
        Producto producto = new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                producto.setId(rs.getInt(1));
                producto.setNom(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setStock(rs.getInt(4));
                producto.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar un producto");
        }
        return producto;
    }
    
    public int ActualizarStock(int id, int stock){
        String sql="update producto set Stok=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
     // Operaciones CRUD en JAVA
    
    public List listar(){
        String sql="select * from producto";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                Producto prod = new Producto();
                prod.setId(rs.getInt(1));
                prod.setNom(rs.getString(2));
                prod.setPrecio(rs.getDouble(3));
                prod.setStock(rs.getInt(4));
                prod.setEstado(rs.getString(5));
                lista.add(prod);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar la tabla Cliente");
        }
        return lista;
    }
    
    public  int agregar(Producto pro){
        String sql="insert into producto(Nombres,Precio,Stok,Estado)values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getNom());
            ps.setDouble(2, pro.getPrecio());
            ps.setInt(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar producto");
        }
        return r;
    }
    
    public Producto listarId(int id){
        Producto producto=new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {  
                producto.setId(rs.getInt(1));
                producto.setNom(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setStock(rs.getInt(4));
                producto.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
            
        }
        return producto;
    }
    
    public int actualizar(Producto p1){
        String sql="update producto set Nombres=?, Precio=?, Stok=?, Estado=? where IdProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, p1.getNom());
            ps.setDouble(2, p1.getPrecio());
            ps.setInt(3, p1.getStock());
            ps.setString(4, p1.getEstado());
            ps.setInt(5, p1.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar Producto");
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
