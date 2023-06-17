<%-- 
    Document   : usuarioDatos
    Created on : 7 jun. 2023, 20:40:33
    Author     : 51990
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos del Usuario</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style type="text/css">
            .formFieldError{
                background: #FFC;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row d-flex justify-content-center mx-auto" >
                <h1>Datos del Usuario</h1>
                <br>
                <div class="col-md-6 col-xs-12 div-style">
                    <mvc:form modelAttribute="usuarioBean" action="usuarioGrabar.do">
                        <table>
                            <tr>
                                <td><mvc:label path="usuario">Usuario:</mvc:label></td>
                                <td><mvc:input path="usuario" cssErrorClass="form-control text-box formFieldError" cssClass="form-control text-box"></mvc:input></td>
                                <td><mvc:errors path="usuario"></mvc:errors></td>
                                </tr>
                                <tr>
                                    <td><mvc:label path="clave">Clave:</mvc:label></td>
                                <td><mvc:input path="clave" cssErrorClass="form-control text-box formFieldError" cssClass="form-control text-box"></mvc:input></td>
                                <td><mvc:errors path="clave"></mvc:errors></td>
                                </tr>
                                <tr>
                                    <td><mvc:label path="nombreCompleto">Nombre Completo:</mvc:label></td>
                                <td><mvc:input path="nombreCompleto" cssErrorClass="form-control text-box formFieldError" cssClass="form-control text-box"></mvc:input></td>
                                <td><mvc:errors path="nombreCompleto"></mvc:errors></td>
                                </tr>
                                <tr>
                                    <td colspan="1">
                                        <input type="submit" value="Insertar" class="btn btn-primary button-submit"/>
                                    </td>
                                </tr>
                            </table>
                    </mvc:form>
                </div>
            </div>
        </div>
    </body>
</html>
