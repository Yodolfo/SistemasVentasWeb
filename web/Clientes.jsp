<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="d-flex">
            <div class="card col-sm-6">
                <div class="card-body">
                    <form action="Controlador?menu=Clientes" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${cliente.getDni()}" name="txtClienteDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${cliente.getNom()}" name="txtClienteNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${cliente.getDirec()}" name="txtClienteDireccion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${cliente.getEstado()}" name="txtClienteEstado" class="form-control">
                        </div>
                        <br>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info btn-b">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success btn-b">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRE</th>
                            <th>DIRECCIÓN</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c1" items="${clientes}">
                            <tr>
                                <td>${c1.getId()}</td>
                                <td>${c1.getDni()}</td>
                                <td>${c1.getNom()}</td>
                                <td>${c1.getDirec()}</td>
                                <td>${c1.getEstado()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Clientes&accion=Editar&id=${c1.getId()}">Editar</a>
                                    <a class="btn btn-danger"  href="Controlador?menu=Clientes&accion=Delete&id=${c1.getId()}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
    </body>
</html>
