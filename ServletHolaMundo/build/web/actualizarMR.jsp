<%@page import="com.MregistroDTO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Actualizacion de Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <% MregistroDTO registro = (MregistroDTO)request.getAttribute("registroDTO");  %>
    </head>
    <body>
        <div class="container" >
            
            <div class="containerRegistro">
                
                <form name="formulario" method="post" 
                  action="Actualizar">
                <label>Nombre:</label>
                <input type="text" name="nombre" value="<%=registro.getNombre()%>" >
                <br>
                <label>Apellido Paterno:</label>
                <input type="text" name="appat" value="<%=registro.getAppat()%>" >
                <br>
                <label>Apellido Materno:</label>
                <input type="text" name="appmat" value="<%=registro.getApmat()%>" >
                <br>
                <label>Edad:</label>
                <input type="text" name="edad" value="<%=registro.getEdad()%>" >
                <br>
                <label>Correo:</label>
                <input type="email" name="correo" value="<%=registro.getCorreo()%>" >
                <br>
                <input type="hidden" name="idUsu" value="<%=registro.getIdUsu()%>">
                <input type="hidden" name="operacion" value="actualizar">
                <input type="submit" value="Actualizar de Usuarios" >
                <input type="reset" value="Reset Registro" >
            </form>
            </div>
                <div>
                    <a href='index.html'>Regresar a la pagina principal</a>
                    <br>
                    
                    <a href='Consultar'>Consultar Tabla General de Usuarios</a>
                    
                    
                </div>
                    
                    
                
        </div>
    </body>
</html>