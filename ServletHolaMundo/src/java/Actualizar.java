/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
Connection nos ayuda a realizar la conexion con las bd, con el servidor
*/
import java.sql.Connection;
import java.sql.DriverManager;
/*
Statement nos ayuda a poder definir y manipular los datos de las bd
creacion de la bd, insertar tablas, eleminar tablas,  create, drop, alter
    manipulacion de los datos, insert, update, delete
*/
import java.sql.Statement;
/*
nos ayuda para las querrys, o las consultas a la bd
*/
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import com.MregistroDTO;
/**
 *
 * @author demon
 */
public class Actualizar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //variables globales
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //el constructor del servlet
    //nos va a ayudar a inicializar la conexion con la bd
    
    public void init(ServletConfig cfg) throws ServletException{
        
        //lo primero que necesitamos es trazar la ruta al servidor DB
        String URL = "jdbc:mysql://localhost:3306/registro4iv8?useSSL=false";
        //driver:gestor:puerto//IP/nombreBD
        
        String userName = "root";
        String password = "eduardo";
        
        try{
            //colocamos el tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            
            /*
            en algunas ocaciones enviar error al conectarse con la bd
            y eso se debe a que ya estegrado el puerto en el driver
            URL = "jdbc:mysql://localhost/registro4iv8";
            */
           // URL = "jdbc:mysql://localhost/registro4iv8";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher dispatcher;
            String operacion = request.getParameter("operacion");
            String id = request.getParameter("idactualizar");
            MregistroDTO registroDto;
            System.out.println("Empezamos con busqueda: " + id);
            if(operacion.equals("Busqueda")){
            System.out.println("Comienza busqueda: " + id);
                registroDto=getMregistro(id);
                System.out.println("DTO encontrado: " + registroDto.getNombre());
                request.setAttribute("registroDTO", registroDto);
                dispatcher=request.getRequestDispatcher("actualizarMR.jsp");
                dispatcher.forward(request, response);
            }else{
            
            String nombre = request.getParameter("nombre");
            String apppat = request.getParameter("appat");
            String appmat = request.getParameter("appmat");
            String correo = request.getParameter("correo");
            String edad = request.getParameter("edad");
           String idUsu = request.getParameter("idUsu");
           
        
            
            String q = "UPDATE MREGISTRO SET NOM_USU = '"+nombre +"'" +
                                           ",APPAT_USU='" +apppat+"'" +
                                           ",APMAT_USU='"+appmat+"'" +
                                           ",EDAD_USU=" + edad +
                                           ",CORREO_USU='"+correo+"' "
                    + "WHERE ID_USU = "+ idUsu;
                  
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Actualizar</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            try{
                
                set.executeUpdate(q);
                System.out.println("Registro actualizado");
            out.println("<h1>Usuario Actuaizado</h1>");
             set.close();
            }catch(Exception e){
            out.println("<h1>Usuario No Agregado</h1>");
                System.out.println("No se pudo agregar el usuario");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
             
            }
           
            
            
            out.println("<br>"
                    + "<a href='index.html'>Regresar a la pagina principal</a>"
                    + "<br>"
                    + "<a href='./'>Insertar nuevo Usuario</a>"
                    + "<br>"
                    + "<a href='Consultar'>Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");  
            
            
            }
                
            
           }
            
    }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public void destroy(){
        try{
            con.close();
            System.out.println("Se destruyo wiiii");
        
        }catch(Exception e){
            super.destroy();
        
        }
    }    
    
        
        public MregistroDTO getMregistro(String id) {
            
            MregistroDTO registro = new MregistroDTO();

            String q = "SELECT * FROM MREGISTRO WHERE ID_USU="+ id;
                    
                
        try {
                set = con.createStatement();
               rs = set.executeQuery(q);
                
                if(rs.next()){
                //mientras exista un registro hay que obtener los datos de la consulta
                    registro.setNombre(rs.getString("nom_usu"));
                    registro.setAppat(rs.getString("appat_usu"));
                    registro.setApmat(rs.getString("apmat_usu"));
                    registro.setEdad(rs.getInt("edad_usu"));
                    registro.setCorreo(rs.getString("correo_usu"));
                    registro.setIdUsu(rs.getInt("id_usu"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                System.out.println("Consulta Exitosa");
            
        return registro;
    }
        
}