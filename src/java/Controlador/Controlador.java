package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SYBOR
 */
public class Controlador extends HttpServlet {

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente c1 = new Cliente();
    ClienteDAO dao = new ClienteDAO();
    Producto pro = new Producto();
    ProductoDAO prodao = new ProductoDAO();
    int ide;

    Venta venta = new Venta();
    List<Venta> lista = new ArrayList<>();

    int item;
    int cod;
    String descripcion;
    double precio;
    int cantidad;
    double subtotal;
    double totalPagar;

    String numeroserie;
    VentaDAO ventasDao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTelefono");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTelefono");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUsuario");
                    em.setDni(dni1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        //Clientes

        if (menu.equals("Clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = dao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtClienteDni");
                    String nom = request.getParameter("txtClienteNombre");
                    String direc = request.getParameter("txtClienteDireccion");
                    String est = request.getParameter("txtClienteEstado");
                    c1.setDni(dni);
                    c1.setNom(nom);
                    c1.setDirec(direc);
                    c1.setEstado(est);
                    dao.agregar(c1);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Cliente c = dao.listarId(ide);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtClienteDni");
                    String nom1 = request.getParameter("txtClienteNombre");
                    String direc1 = request.getParameter("txtClienteDireccion");
                    String est1 = request.getParameter("txtClienteEstado");
                    c1.setDni(dni1);
                    c1.setNom(nom1);
                    c1.setDirec(direc1);
                    c1.setEstado(est1);
                    c1.setId(ide);
                    dao.actualizar(c1);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    dao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        //Producto
        if (menu.equals("Producto")) {
            switch (accion) {
                case "Listar":
                    List lista = prodao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombreProducto");
                    double precio = Double.parseDouble(request.getParameter("txtPrecioProducto"));
                    int stok = Integer.parseInt(request.getParameter("txtStokProducto"));
                    String est = request.getParameter("txtEstadoProducto");
                    pro.setNom(nom);
                    pro.setPrecio(precio);
                    pro.setStock(stok);
                    pro.setEstado(est);
                    prodao.agregar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;

                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Producto p = prodao.listarId(ide);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1 = request.getParameter("txtNombreProducto");
                    double precio1 = Double.parseDouble(request.getParameter("txtPrecioProducto"));
                    int stok1 = Integer.parseInt(request.getParameter("txtStokProducto"));
                    String est1 = request.getParameter("txtEstadoProducto");
                    pro.setNom(nom1);
                    pro.setPrecio(precio1);
                    pro.setStock(stok1);
                    pro.setEstado(est1);
                    pro.setId(ide);
                    prodao.actualizar(pro);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide = Integer.parseInt(request.getParameter("id"));
                    prodao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("RegistrarVenta")) {

            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigocliente");
                    c1.setDni(dni);
                    c1 = dao.buscar(dni);
                    request.setAttribute("clienteB", c1);
                    request.setAttribute("nserie", numeroserie);

                    break;
                case "BuscarProducto":
                    /*
                    int cod = Integer.parseInt(request.getParameter("codigoproducto"));
                    pro.setId(cod);
                    pro = prodao.buscarProducto(cod);
                    request.setAttribute("productoB", pro);*/

                    int id = Integer.parseInt(request.getParameter("codigoproducto"));
                    pro = prodao.listarId(id);
                    request.setAttribute("clienteB", c1);
                    request.setAttribute("productoB", pro);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("nserie", numeroserie);

                    break;
                case "Agregar":
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = pro.getId();
                    descripcion = request.getParameter("nombresproducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cantidad;
                    venta = new Venta();
                    venta.setItem(item);
                    venta.setIdproducto(cod);
                    venta.setDescripcionP(descripcion);
                    venta.setPrecio(precio);
                    venta.setCantidad(cantidad);
                    venta.setSubtotal(subtotal);
                    lista.add(venta);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("clienteB", c1);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "GenerarVenta":
                    //Guardar datos de la venta
                    for (int i = 0; i < lista.size(); i++) {
                        Producto prod = new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        //instanciar la clase para usar sus metodos
                        ProductoDAO prdao= new ProductoDAO();
                        prod=prdao.buscarProducto(idproducto);
                        int StokActualizado=prod.getStock()-cantidad;
                        prdao.ActualizarStock(idproducto, StokActualizado);
                        
                    }
                    
                    venta.setIdcliente(c1.getId());
                    venta.setIdempleado(2);
                    venta.setNumserie(numeroserie);
                    venta.setFecha("2019-06-14");
                    venta.setMonto(totalPagar);
                    venta.setEstado("1");
                    ventasDao.guardarVenta(venta);
                    //Guardar detalle de ventas
                    
                    int idventas=Integer.parseInt(ventasDao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        venta=new Venta();
                        venta.setId(idventas);
                        venta.setIdproducto(lista.get(i).getIdproducto());
                        venta.setCantidad(lista.get(i).getCantidad());
                        venta.setPrecio(lista.get(i).getPrecio());
                        ventasDao.guardarDetalleventas(venta);
                    }
                    break;
                    
                default:
                    venta=new Venta();
                    numeroserie=ventasDao.GenerarSerie();
                    if (numeroserie==null) {
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }else{
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }

            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

        /*
        switch (accion) {
            case "Principal":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "Producto":
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                break;
            case "Empleado":
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                break;
            case "Clientes":
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                break;
            case "RegistrarVenta":
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                break;    
            default:
                throw new AssertionError();
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
