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
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" value="${empleado.getDni()}" name="txtDni" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${empleado.getNom()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" value="${empleado.getTel()}" name="txtTelefono" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${empleado.getEstado()}" name="txtEstado" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${empleado.getUser()}" name="txtUsuario" class="form-control">
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
                            <th>NOMBRES</th>
                            <th>TELEFONO</th>
                            <th>ESTADO</th>
                            <th>USUARIO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                            <tr>
                                <td>${em.getId()}</td>
                                <td>${em.getDni()}</td>
                                <td>${em.getNom()}</td>
                                <td>${em.getTel()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getUser()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                    <a class="btn btn-danger"  href="Controlador?menu=Empleado&accion=Delete&id=${em.getId()}">Delete</a>
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
