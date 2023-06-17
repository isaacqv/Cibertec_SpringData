<%-- 
    Document   : fotoUsuario
    Created on : 7 jun. 2023, 22:23:35
    Author     : 51990
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Base64"%>
<%@page import="edu.cibertec.capitulo3.dao.entity.UsuarioEntity"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foto usuario</title>
    </head>
    <body>
        <h1>Foto del usuario</h1>
        <% if(request.getAttribute("usuario") == null || ((UsuarioEntity)request.getAttribute("usuario")).getFoto() == null){%>
        <h2>Usuario aún sin foto</h2>
        <%} else{%>
        <img src="<%="data:image/jpeg;base64,"+
                Base64.getEncoder().encodeToString(((UsuarioEntity)request.getAttribute("usuario")).getFoto())%>"/>
        <%}%>
        
        <form method="post" action="fotoGrabar.do" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>Seleciona foto: </td>
                    <td><input type="file" name="archivo"></td>
                </tr>
                <tr>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Subir foto en jpg"></td>
                </tr>
            </table>
            <input type="hidden" name="codigoUsuario"
                   value="<%=((UsuarioEntity)request.getAttribute("usuario")).getUsuario()%>">
        </form>
        
    </body>
</html>
