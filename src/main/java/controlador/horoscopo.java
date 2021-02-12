
package controlador;

import Modelo.Utilidades;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class horoscopo extends HttpServlet {

    
    private ArrayList<String> meses = Utilidades.getMeses();
    private ArrayList<String> dias = Utilidades.getDias();
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet horoscopo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet horoscopo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
        
        
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
        request.setAttribute("meses", this.meses);
        request.setAttribute("dias", this.dias);
        
        
        request.getRequestDispatcher("vista/horoscopo.jsp").forward(request, response);
        
        
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
        request.setAttribute("meses", this.meses);
        request.setAttribute("dias", this.dias);
        
        
        String nombre = request.getParameter("nombre");
        
        

        String mes = request.getParameter("mes");
                
        String dia = request.getParameter("dia");
        
        String signo = Utilidades.getHoroscopo(Integer.parseInt(dia),Integer.parseInt(mes));
        
        
        
        request.setAttribute("nombre", nombre);
        request.setAttribute("dia", dia);
        request.setAttribute("mes", mes);
        request.setAttribute("signo", signo);
        
        
        request.getRequestDispatcher("vista/horoscopo.jsp").forward(request, response);
    }

    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
