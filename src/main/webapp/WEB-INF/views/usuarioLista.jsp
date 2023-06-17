<%-- 
    Document   : usuarioLista
    Created on : 7 jun. 2023, 20:24:48
    Author     : 51990
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.cibertec.capitulo3.dao.entity.UsuarioEntity" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <title>Mantenimiento de Usuario</title>
    </head>

    <body>
        
        <h1>Listado de Usuarios</h1>
        <br>
        <% List<UsuarioEntity> lista = (List<UsuarioEntity>) request.getAttribute("lista"); %>
        <div class="table-responsive">
            <table class="table table-responsive table-sm table-dark table-striped table-bordered table-hover">
                <thead>
                    <tr class="info">
                        <th>Usuario</th>
                        <th>Clave</th>
                        <th>Nombre Completo</th>
                        <th>Foto</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (UsuarioEntity usuario : lista) {%>
                    <tr>
                        <td> <%=usuario.getUsuario()%> </td>
                        <td> <%=usuario.getClave()%></td>
                        <td> <%=usuario.getNombreCompleto()%></td>
                        <td> <a href="fotoMostrar.do?codigoUsuario=<%=usuario.getUsuario()%>">foto</td>
                    </tr>
                    <% }%>
                </tbody>
            </table> 
        </div>
        <a href="usuarioCrear.do" class="btn btn-primary btn-lg active" >Crear Usuario</a>
        <br>
        <h3>Se han creado en esta sesión ${sessionScope.contador} usuarios!</h3>
        
    </body>

</html>
