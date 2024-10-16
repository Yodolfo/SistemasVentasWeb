
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class VentaDAO {
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                numeroserie=rs.getString(1);
                
            }
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "Error");
        }
        return numeroserie;
    }
    
    public String IdVentas(){
        String idventas="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {                
                idventas=rs.getString(1);
                
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    
    public int guardarVenta(Venta venta){
        String sql="insert into ventas(IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) values(?,?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getIdcliente());
            ps.setInt(2, venta.getIdempleado());
            ps.setString(3, venta.getNumserie());
            ps.setString(4, venta.getFecha());
            ps.setDouble(5, venta.getMonto());
            ps.setString(6, venta.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public int guardarDetalleventas(Venta venta){
        String sql="insert into detalle_ventas(IdVentas,IdProducto,Cantidad,PrecioVenta) values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public void delete(int id){
        String sql="delete from ventas where IdVentas="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al eliminar venta");
        }
    }
}
