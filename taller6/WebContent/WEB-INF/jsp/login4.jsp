<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Scripts y Link se declaran en el tag HEAD del documento HTML -->
        <!-- ...Incluyo framework jQuery -->
        <script type="text/javascript" src="./jquery-1.10.2.js"></script>
        <!-- ...Incluyo javascript del objeto -->
        <script src="./logintest.js" type="text/javascript"></script>
        <link rel="stylesheet" href="./resources/css/login.css">
        <!-- ...Incluyo framework CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <!-- ...Titulo App  -->
		<title>Sistema de Tickets - IRSO</title>
    </head>
    <body>  
         <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Ingrese usuario y contraseña</h1>
                    <div class="account-wall">
                        <img class="profile-img" src="http://www.irso.edu.ar/images/marcaindex.gif"
                            alt="">
                        <form class="form-signin">
                        <input id="loginUsuario" type="text" class="form-control" placeholder="Usuario" required autofocus>
                        <input id="loginPassword" type="password" class="form-control" placeholder="Contraseña" required>
                        <button id="btnIngresar" class="btn btn-lg btn-primary btn-block" type="button">
                            Ingresar</button>
                        <label class="checkbox pull-left">
                            <input type="checkbox" value="remember-me">
                            Recordar mis credenciales
                        </label>
                        <a href="#" class="pull-right need-help">Ayuda? </a><span class="clearfix"></span>
                        </form>
                    </div>
                    <a href="#" class="text-center new-account">Registrarse </a>
                </div>
            </div>
        </div>
    </body>
</html>
    
   