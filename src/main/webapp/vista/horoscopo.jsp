
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container">
             <div class="row">
                 <div class="col-6">
                     <h1>Horoscopo</h1>
                    <form action="horoscopo" method="post">
                        
                        
                         <%    ArrayList<String> meses = (ArrayList<String>) request.getAttribute("meses"); 
                               ArrayList<String> dias = (ArrayList<String>) request.getAttribute("dias");
                               
                               
                               String dia = (String) request.getAttribute("dia");
                               if ( dia==null )dia="1";
                               
                               String mes = (String) request.getAttribute("mes");
                               if ( mes==null )mes="1";
                               
                               String nombre = (String) request.getAttribute("nombre");
                               if ( nombre==null )nombre=""; 
                       %>
                       
                       
                       Ingrese su nombre:<input type="text" class="form-control" id="nombre" value="<%=nombre%>" name="nombre"/><br>

                       
                       Ingrese el mes de nacimiento: <select class="form-control" name="mes" id="mes">
                           
                           
                       <% for( int i=0; i<meses.size(); i++){
                           String cadenaSelected = "";
                           if (Integer.parseInt(mes) == Integer.parseInt(meses.get(i))){
                               cadenaSelected = "selected";
                           }             
                       %>
                       
                       
                           <option value="<%=meses.get(i)%>" <%=cadenaSelected%> ><%=meses.get(i)%> </option>
                       <% } %>
                       </select><br>


                       
                       Ingrese el dia de nacimiento:<select class="form-control" name="dia" id="dia">
                           
                           
                           <% for( int d=0; d<dias.size(); d++){ 
                               String cadenaSelected = "";
                               if (Integer.parseInt( dia ) == Integer.parseInt(dias.get(d))){
                                   cadenaSelected = "selected";
                               }  
                           %>
                           
                           
                           <option value="<%=dias.get(d)%>" <%=cadenaSelected%> ><%=dias.get(d)%> </option>   
                        <% } %>
                        
                        
                       </select><br>
                       
                       
                       <input class="btn btn-primary" type="submit" value="Enviar">
                   </form>
                        
                        
                        <% String signo = (String) request.getAttribute("signo");
                        if ( signo!=null ) { %>
                        
                        
                        <h1 class="alert alert-success">Eres del signo: <%=signo%> !!</h1>
                        
                        
                        <% } %> 
                        
                        
             </div>
                        
         </div>
                        
                        
    </body>
</html>
