<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Principal</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <!--<div class="container-fluid">-->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Producto</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta&accion=default" target="myFrame">Nueva Venta</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center">
                    <a class="dropdown-item" href="#">
                        <img src="img/usuario.jpg" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">Usuario@gmail.com</a>
                    <div class="dropdown-divider"></div>
                    <form action="Validar" method="POST">
                        <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                    </form>
                </div>
            </div>
            <!--</div>-->
        </nav>
                    
                    <div class="m-4" style="height: 550px;">
                        <iframe name="myFrame" style="height: 100%;width: 100%;"></iframe>
                    </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
    </body>
</html>
