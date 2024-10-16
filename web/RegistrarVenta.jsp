<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Venta</title>
        <style>
            @media print{
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>

        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=RegistrarVenta" method="POST">
                        <div class="card-body">
                            <!-- Datos del cliente -->
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-5 d-flex">
                                    <input type="text" name="codigocliente" value="${clienteB.getDni()}" class="form-control" placeholder="Codigo">&nbsp
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-primary">&nbsp&nbsp&nbsp
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" value="${clienteB.getNom()}" name="nombrescliente" class="form-control" placeholder="Datos del cliente">
                                </div>
                            </div>
                            <!-- Datos del producto -->
                            <br>
                            <div class="form-group">
                                <label>Datos del Producto</label>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-5 d-flex">
                                    <input type="text" name="codigoproducto" value="${productoB.getId()}" class="form-control" placeholder="Codigo">&nbsp
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-primary">Buscar</button>&nbsp&nbsp&nbsp
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" value="${productoB.getNom()}" name="nombresproducto" class="form-control" placeholder="Datos del producto">
                                </div>
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-5 d-flex">
                                    <input type="number" value="${productoB.getPrecio()}" name="precio" class="form-control" placeholder="S/. 0.00">&nbsp&nbsp&nbsp
                                </div>
                                <div class="col-sm-3 d-flex">
                                    <input type="number" value="1" name="cant" class="form-control" placeholder="">&nbsp&nbsp&nbsp
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="${productoB.getStock()}"  name="stock" class="form-control" placeholder="Stock">
                                </div>
                            </div>
                            <!-- Boton para agregar producto al registro -->
                            <div class="form-group">
                                <br>
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            &nbsp&nbsp&nbsp
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 m-auto" style="float: right">
                            <label class="d-flex col-sm-4 m-auto">NRO. SERIE</label>
                            <input type="text" name="NumeroSerie:" value="${nserie}" class="form-control text-center">
                        </div>

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Codigo</th>
                                    <th>Descripcion</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>SubTotal</th>
                                    <th class="accion">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdproducto()}</td>
                                        <td>${list.getDescripcionP()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>
                                            <a class="btn btn-warning">Editar</a>
                                            <a class="btn btn-danger">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=RegistrarVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="d-flex col-sm-4 m-auto">
                            <label class="d-flex col-sm-4 m-auto">Total Pagar</label>
                            <input type="text" name="txtTotal" value="S/. ${totalpagar}" class="form-control text-center font-weight-arial-arial">
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
    </body>
</html>
